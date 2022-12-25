package ui.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import utils.Attach;
import utils.testData.Users;

public class LoginSteps extends PagesUtils {

    @Step("Авторизация юзера")
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


    @Before(value = "@UI")
    public static void beforeMethod(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        System.out.println("++++++++++++++ _________------------");
        Configuration.browserSize = "1800x500";
    }
    @After(value = "@UI")
    public void afterMethod(){
        Attach.screenshotAs("LastStep");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Selenide.closeWebDriver();

        System.out.println("++++++++++++++ _________------------");
    }
}
