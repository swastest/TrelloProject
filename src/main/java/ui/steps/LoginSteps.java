package ui.steps;

import com.codeborne.selenide.Selenide;
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
}
