package ui.steps;

import io.cucumber.java.en.Then;
import utils.PagesUtils;

public class AllBoardsSteps extends PagesUtils {
    @Then("Проверка основного экрана досок {string}, {string}")
    public void checkAllBoards(String text1, String text2) {

    }

    @Then("Проверка имени аккаунта")
    public void checkAccountName() {
        mainBoardPageFlow.clickProfileButton();
        mainBoardPageFlow.checkUserName("Тaтьяна Казакова");
    }
}
