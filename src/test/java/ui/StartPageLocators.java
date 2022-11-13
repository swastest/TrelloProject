package ui;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StartPageLocators {
    SelenideElement loginButton = $(By.linkText("Log in"));
    SelenideElement inputLoginEmail = $("input#user");
    SelenideElement nextButton = $("input#login");
    SelenideElement inputPass = $("input#password");
    SelenideElement submitButton = $(byText("Войти"));
    SelenideElement userMenu = $("[data-test-id='header-member-menu-popover']");
    SelenideElement userConsole = $("[data-test-id='header-member-menu-button']");

//    public SelenideElement getUserConsole(String userName){
//        userConsole = $("[title*='"+userName+"']");
//     return  userConsole;
//    }


}
