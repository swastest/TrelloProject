package ui.pom.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class SingInPage {
    @FindBy(css = "input#user")
    private SelenideElement inputEmail;

    @FindBy(css = "input#login")
    private SelenideElement nextAuthButton;

    @FindBy(css = "input#password")
    private SelenideElement inputPassword;

    @FindBy(xpath = "//span[text()='Войти']")
    private SelenideElement loginAuthButton;
}
