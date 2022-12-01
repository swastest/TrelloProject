package ui.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.PagesUtils;

public class LoginSteps extends PagesUtils {

    @Given("Открыть сайт {string}")
    public void openSite(String url) {
        Selenide.open(url);
    }

    @When("Нажать на кнопку Log In")
    public void clickLogInButton() {
        mainPageFlow.clickSingInButton();
    }

    @And("Ввод в поле логин email")
    public void setValueLoginEmail() {
        singInPageFlow.setValueEmailLogin(userConfig.email());
    }

    @And("Нажать на кнопку продолжить")
    public void clickNextButton() {
        singInPageFlow.clickNextAuthButton();
    }

    @And("Ввод пароля")
    public void setPassword() {
        singInPageFlow.setValuePassword(userConfig.pass());
    }

    @And("Нажать на кнопку Войти")
    public void clickEnterButton() {
        singInPageFlow.clickSubmitLoginButton();
    }

    @When("Авторизация")
    public void auth() {
        clickLogInButton();
        setValueLoginEmail();
        clickNextButton();
        setPassword();
        clickEnterButton();
    }
}
