package ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PagesUtils;

public class SomeTableSteps extends PagesUtils {
    @And("Проверка имени первой колонки")
    public void checkFirstColumnName() {
        someTableFlow.checkColumnName(0,"Нужно сделать");
    }

    // And Проверка имени колонки '0', соответствует тексту "Нужно сделать"
    @And("Проверка имени колонки {string}, соответствует тексту {string}")
    public void checkColumnName(int arg0, String arg1) {
        someTableFlow.checkColumnName(arg0,arg1);
    }

    @And("Нажать на кнопку добавить карточку")
    public void clickAddNewCard() {
        someTableFlow.clickAddCard(2);
    }

    @And("Ввод текста в новую карточку {string}")
    public void setValueInTextAriaNewCard(String arg0) {
        someTableFlow.setTextInNewCard(2, arg0);
    }

    @Then("Проверка что текст {string} отображается в колонке")
    public void checkContentInColumn(String arg0) {
        someTableFlow.checkColumnContent(2,arg0);
    }

    @And("Подтвердить добавление новой записи")
    public void confirmAddNewCard() {
        someTableFlow.confirmAddedText(2);
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
