package ui;

import io.qameta.allure.Step;

public class Actions {
  private   StartPageLocators startPageLocators = new StartPageLocators();

    @Step("Нажать на кнопку Логин")
    public Actions clickLoginButton() {
        startPageLocators.loginButton.click();
        return this;
    }

    public Actions selectGoogleLogin() {
        startPageLocators.googleButtonLogin.click();
        return this;
    }

    public Actions setValueEmail(String googleEmail) {
        startPageLocators.inputEmail.setValue(googleEmail);
        return this;
    }

    public Actions clickNextButton() {
        startPageLocators.nextButton.click();
        return this;
    }
}
