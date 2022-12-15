package ui.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.PagesUtils;
import utils.testData.Users;

public class LoginSteps extends PagesUtils {

    @Given("Юзер {} авторизирован")
    public void auth(Users user) {
        clickLogInButton();
        setValueLoginEmail(user);
        clickNextButton();
        setPassword(user);
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

    @When("Ввод в поле логин юзера {}")
    public void setValueLoginEmail(Users email) {
        singInPageFlow.setValueEmailLogin(email.getLogin());
    }

    @When("Нажать на кнопку продолжить")
    public void clickNextButton() {
        singInPageFlow.clickNextAuthButton();
    }

    @When("Ввод пароля юзера {}")
    public void setPassword(Users password) {
        singInPageFlow.setValuePassword(password.getPassword());
    }

    @When("Нажать на кнопку Войти")
    public void clickEnterButton() {
        singInPageFlow.clickSubmitLoginButton();
    }

}
