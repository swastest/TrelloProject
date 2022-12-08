package ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PagesUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllBoardsSteps extends PagesUtils {
    @Then("Проверка основного экрана досок {string}, {string}")
    public void checkAllBoards(String text1, String text2) {
        mainBoardPageFlow.checkAllBoards(text1);
        mainBoardPageFlow.checkAllBoards(text2);
    }

    @Then("Проверка имени аккаунта {string}")
    public void checkAccountName(String profileName) {
        mainBoardPageFlow.clickProfileButton();
        mainBoardPageFlow.checkUserName(profileName);
    }

    @Then("Все активные доски отображаются на экране AllBoards")
    public void AllBoardsVisible() {
        List<String> expectResult = expectResultApi.actualAiiBoards();
        for (String e : expectResult) {
            mainBoardPageFlow.checkAllBoards(e);
        }
    }

    @When("Нажать на кнопку перехода на доску")
    public void clickOnTable() {
        mainBoardPageFlow.clickOnTable();
    }

    @Then("Проверка открытых досок пользователя {string}")
    public void checkAllActualBoards(String login) {
        List<String> expectResult = Arrays.stream(boardsPrecondition.boards(login)).filter(e -> e.getClosed() != true)
                .map(e -> e.getName()).collect(Collectors.toList());
        for (String e : expectResult) {
            mainBoardPageFlow.checkAllBoards(e);
        }
    }


    @When("Создать новую доску {string} юзером {string}")
    public void createNewCard(String arg0, String arg1) {
        boardsPrecondition.createBoard(arg1,arg0);
    }


    @Then("Проверка, что новая доска {string} отображается на домашнем экране")
    public void checkNewBoardIsVisible(String arg0) {
        mainBoardPageFlow.checkAllBoards(arg0);
    }
}
