package ui.steps;

import api.conrtollers.AuthController;
import api.models.ResponseBoards;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import utils.testData.PagesUtils;
import utils.testData.Users;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ApiSteps extends PagesUtils {

    public Map<Users, List<String>> context;
    public static Map<String, String> cookies = new HashMap<>();

    //если бы нужно было передавать куки
    public static Map<String, String> getCookies(){
        if(cookies==null) cookies = new AuthController().getAuthCookies();

        return cookies;
    }

    @Before(order = 1)
    public void startMethod() {
        log.info("Before UI method");
        context = new HashMap<>();

    }

    @After(order = 9999)
    public void lastMethod() {
        log.info("After UI method");
        context.forEach((k, v) -> v.forEach(id -> boardController
                .deleteTable(k, id, 200)));
    }

    @When("Пользователь {} добавляет доску {string}")
    public void createNewCard1(Users users, String arg1) {
        boardController.createBoard(users, arg1, 200);
    }

    @Then("Удаление добавленной доски {string} юзером {}")
    public void deleteNewAddedBoard(String boardName, Users userName) {
        String a = boardController.getAllBoardsList(userName, 200).stream()
                .filter(e -> e.getName().equals(boardName)).filter(e -> e.getClosed() != true)
                .map(e -> e.getId()).findFirst().get();
        boardController.deleteTable(userName, a, 200);
    }

    @Then("Проверка, что новая доска {string} отображается в списке всех досок, для пользователя {}")
    public void checkNewBoard(String boardName, Users users) {
        List<ResponseBoards> bList = boardController.getAllBoardsList(users, 200);
        List<String> s = bList.stream().map(ResponseBoards::getName).collect(Collectors.toList());
        Assertions.assertTrue(s.contains(boardName));
        String boardId = bList.stream().filter(e -> e.getName().equals(boardName))
                .map(e -> e.getId()).collect(Collectors.toList()).get(0);

        context.put(users, Collections.singletonList(boardId));
    }

    @When("Пользователь {} добавил новую колонну {string} на доску {string}")
    public void createNewColumnOnBoard(Users user, String columnName, String boardName) {
        String boardId = boardController.getAllBoardsList(user, 200).stream().filter(e -> e.getName().equals(boardName))
                .map(e -> e.getId()).findFirst().orElseThrow();
        listController.createNewListOnBoard(user, columnName, boardId, 200);
    }

    @Then("Проверка, что пользователь {} видит новую  колонну {string} в списке колонн для доски {string}")
    public void checkNewColumnOnBoard(Users user, String columnName, String boardName) {
        log.info("Request boardId from allBoard");
        String boardId = boardController.getAllBoardsList(user, 200)
                .stream().filter(e -> e.getName().equals(boardName))
                .map(e -> e.getId()).findFirst().orElseThrow();
        log.info("Request list boards name");
        List<String> s = listController.getAllListsOnBoard(user, boardId, 200).stream()
                .map(e -> e.getName()).collect(Collectors.toList());
        log.info("Assertions contains columnName");
        Assertions.assertTrue(s.contains(columnName));
    }

}
