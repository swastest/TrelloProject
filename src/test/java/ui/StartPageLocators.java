package ui;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StartPageLocators {
    SelenideElement loginButton = $(By.linkText("Log in"));
    SelenideElement googleButtonLogin = $("#googleButton");
    SelenideElement inputEmail = $("[type=email]");
    SelenideElement nextButton = $(byText("Далее"));

}
