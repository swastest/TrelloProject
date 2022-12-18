package ui.steps;

import api.models.ResponseBoards;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import utils.PagesUtils;
import utils.testData.Users;

import java.util.List;
import java.util.stream.Collectors;

public class ApiSteps extends PagesUtils {

    @When("Пользователь {} добавляет доску {string}")
    public void createNewCard1(Users users, String arg1) {
        boardController.createBoard(users, arg1, 200);

    }

    @Then("Удаление добавленной доски {string} юзером {}")
    public void deleteNewAddedBoard(String boardName, Users userName) {
        String a = boardController.getAllBoardsList(userName, 200).stream()
                .filter(e -> e.getName().equals(boardName)).filter(e -> e.getClosed() != true)
                .map(e -> e.getId()).findFirst().get();
        boardController.deleteTable(userName,a,200);
    }

    @Then("Проверка, что новая доска {string} отображается в списке всех досок, для пользователя {}")
    public void checkNewBoard(String boardName, Users users) {
        List<ResponseBoards> bList = boardController.getAllBoardsList(users, 200);
        List<String> s = bList.stream().map(ResponseBoards::getName).collect(Collectors.toList());
        Assertions.assertTrue(s.contains(boardName));
        String boardId = bList.stream().filter(e->e.getName().equals(boardName))
                .map(e->e.getId()).collect(Collectors.toList()).get(0);
        boardController.deleteTable(users,boardId,200);
    }

    @When("Пользователь {} добавил новую колонну {string} на доску {string}")
    public void createNewColumnOnBoard (Users user, String columnName, String boardName) {
       String boardId = boardController.getAllBoardsList(user,200).stream().filter(e->e.getName().equals(boardName))
                .map(e->e.getId()).findFirst().orElseThrow();
       listController.createNewListOnBoard(user,columnName,boardId,200);
    }

    @Then("Проверка, что пользователь {} видит новую  колонну {string} в списке колонн для доски {string}")
    public void checkNewColumnOnBoard(Users user, String columnName, String boardName) {
        String boardId = boardController.getAllBoardsList(user,200).stream().filter(e->e.getName().equals(boardName))
                .map(e->e.getId()).findFirst().orElseThrow();
        List <String> s = listController.getAllListsOnBoard(user,boardId,200).stream()
                .map(e->e.getName()).collect(Collectors.toList());
        Assertions.assertTrue(s.contains(columnName));
    }
}
