package ui;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


public class Actions {
    private StartPageLocators startPageLocators = new StartPageLocators();

    @Step("Нажать на кнопку Логин")
    public Actions clickLoginButton() {
        startPageLocators.loginButton.click();
        return this;
    }

    public Actions setValueEmail(String googleEmail) {
        startPageLocators.inputLoginEmail.setValue(googleEmail);
        return this;
    }

    public Actions clickNextButton() {
        startPageLocators.nextButton.click();
        return this;
    }

    public Actions setValPass(String pass) {
        startPageLocators.inputPass.val(pass);
        return this;
    }

    public Actions clickSubmitButton() {
        startPageLocators.submitButton.click();
        return this;
    }

    public Actions clickUserConsole(){
        startPageLocators.userConsole.click();
        return this;
    }

    public Actions checkUserName(String userName){
        startPageLocators.userMenu.shouldBe(Condition.text(userName));
        return this;
    }
}
