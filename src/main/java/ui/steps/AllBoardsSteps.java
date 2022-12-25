package ui.steps;

import api.models.ResponseBoards;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import utils.testData.PagesUtils;
import utils.testData.Users;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class AllBoardsSteps extends PagesUtils {

    @When("Нажать на кнопку перехода на доску")
    public void clickOnTable() {
        mainBoardPageFlow.clickOnTable();
    }

    @Then("Проверка открытых досок пользователя {}")
    public void checkAllActualBoards(Users login) {
        List<String> expectResult = boardController.getAllBoardsList(login,200).stream()
                .filter(e -> e.getClosed() != true)
                .map(ResponseBoards::getName).collect(Collectors.toList());
        for (String e : expectResult) {
            mainBoardPageFlow.checkAllBoards(e);
        }
    }

    @Then("Проверка, что новая доска {string} отображается на домашнем экране")
    public void checkNewBoardIsVisible(String arg0) {
        mainBoardPageFlow.checkAllBoards(arg0);
    }

    @Then("Проверка основного экрана досок {string}, {string}")
    public void checkAllBoards(String text1, String text2) {
        mainBoardPageFlow.checkAllBoards(text1);
        mainBoardPageFlow.checkAllBoards(text2);
    }

    @Then("Проверка имени аккаунта {string}")
    public void checkAccountName(String profileName) {
        log.info("Verify account Name");
        mainBoardPageFlow.clickProfileButton();
        mainBoardPageFlow.checkUserName(profileName);
    }
}
