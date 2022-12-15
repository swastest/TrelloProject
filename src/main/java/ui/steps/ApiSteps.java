package ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PagesUtils;
import utils.testData.Users;

import java.util.Arrays;

public class ApiSteps extends PagesUtils {
    @When("Создать новую доску {string} юзером {}")
    public void createNewCard(String arg0, Users arg1) {
        boardsPrecondition.createBoard(arg1,arg0);
    }

    @Then("Удаление добавленной доски {string} юзером {}")
    public void deleteNewAddedBoard(String boardName, Users userName) {
      String a = String.valueOf(Arrays.stream(boardsPrecondition.boards(userName))
              .filter(e->e.getName().equals(boardName)).filter(e->e.getClosed()!=true).map(e->e.getId()).findFirst().get().toString());
      boardsPrecondition.deleteBoard(userName,a);
    }
}
