package ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
    public void нажатьНаКнопкуДобавитьКарточку() {
        someTableFlow.clickAddCard(0);
    }

    @And("Ввод текста в новую карточку {string}")
    public void setValueInTextAriaNewCard(String arg0) {
        someTableFlow.setTextInNewCard(0, arg0);
    }

    @Then("Проверка что текст {string} отображается в колонке")
    public void проверкаЧтоТекстОтображаетсяВКолонке(String arg0) {
        someTableFlow.checkColumnContent(0,arg0);
    }

    @And("Подтвердить добавление новой записи")
    public void подтвердитьДобавлениеНовойЗаписи() {
        someTableFlow.confirmAddedText(0);
    }
}
