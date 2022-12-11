package ui.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.PagesUtils;
import utils.UserController;

public class LoginSteps extends PagesUtils {

    @Given("Юзер {string} авторизирован")
    public void auth(String login) {
        clickLogInButton();
        setValueLoginEmail(login);
        clickNextButton();
        setPassword(login);
        clickEnterButton();
    }

    @Given("Открыта главная страница сайта {string}")
    public void openSite(String url) {
        Selenide.open(url);
    }

    @When("Нажать на кнопку Log In")
    public void clickLogInButton() {
        mainPageFlow.clickSingInButton();
    }

    @When("Ввод в поле логин {string}")
    public void setValueLoginEmail(String email) {
        singInPageFlow.setValueEmailLogin(email);
    }

    @When("Нажать на кнопку продолжить")
    public void clickNextButton() {
        singInPageFlow.clickNextAuthButton();
    }

    @When("Ввод пароля юзера {string}")
    public void setPassword(String email) {
        singInPageFlow.setValuePassword(new UserController().getUserPass(email));
    }

    @When("Нажать на кнопку Войти")
    public void clickEnterButton() {
        singInPageFlow.clickSubmitLoginButton();
    }

}
