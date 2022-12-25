package ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.testData.PagesUtils;

public class SomeTableSteps extends PagesUtils {

    @When("Проверка имени {int} колонки, соответствует {string}")
    public void checkFirstColumnName(int columnNumber, String columnName) {
        someTableFlow.checkColumnName(columnNumber-1, columnName);
    }

    @When("Проверка имени колонки {string}, соответствует тексту {string}")
    public void checkColumnName(int arg0, String arg1) {
        someTableFlow.checkColumnName(arg0,arg1);
    }

    @When("Нажать на кнопку добавить карточку, в колонке {int}")
    public void clickAddNewCard(int columnNumber) {
        someTableFlow.clickAddCard(columnNumber);
    }

    @When("Ввод текста в новую карточку {string}, в колонке {int}")
    public void setValueInTextAriaNewCard(String arg0, int columnNumber) {
        someTableFlow.setTextInNewCard(columnNumber, arg0);
    }

    @Then("Проверка что текст {string} отображается в колонке {int}")
    public void checkContentInColumn(String arg0, int columnNumber) {
        someTableFlow.checkColumnContent(columnNumber,arg0);
    }

    @And("Подтвердить добавление новой записи, в колонке {int}")
    public void confirmAddNewCard(int columnNumber) {
        someTableFlow.confirmAddedText(columnNumber);
    }

    @When("Нажать на кнопку добавить карточку, в колонке {string}")
    public void clickAddNewCard(String arg0) {
        someTableFlow.clickAddCard(arg0);
    }

    @And("Ввести текст {string}, в карточку колонки {string}")
    public void setValueInTextAriaNewCard(String arg0, String arg1) {
        someTableFlow.setTextInNewCard(arg1,arg0);
    }

    @And("Подтвердить добавление новой записи в колонке {string}")
    public void confirmAddNewCard(String arg0) {
        someTableFlow.confirmAddedText(arg0);
    }

    @Then("Проверить, что добавленный текст {string}, содержится в колонке {string}")
    public void checkContentInColumn(String arg0, String arg1) {
        someTableFlow.checkColumnContent(arg1,arg0);
    }
}
