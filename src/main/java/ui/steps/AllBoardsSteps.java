package ui.steps;

import io.cucumber.java.en.Then;
import utils.PagesUtils;

import java.util.List;

public class AllBoardsSteps extends PagesUtils {
    @Then("Проверка основного экрана досок {string}, {string}")
    public void checkAllBoards(String text1, String text2) {
        mainBoardPageFlow.checkAllBoards(text1);
        mainBoardPageFlow.checkAllBoards(text2);
    }

    @Then("Проверка имени аккаунта")
    public void checkAccountName() {
        mainBoardPageFlow.clickProfileButton();
        mainBoardPageFlow.checkUserName("Тaтьяна Казакова");
    }

    @Then("Все активные доски отображаются на экране AllBoards")
    public void AllBoardsVisible() {
        List<String> expectResult = expectResultApi.actualAiiBoards();
        for (String e : expectResult) {
            mainBoardPageFlow.checkAllBoards(e);
        }
    }
}
