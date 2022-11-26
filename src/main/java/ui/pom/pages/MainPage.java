package ui.pom.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainPage {
    @FindBy(xpath = "//a[text()='Log in']")
    private SelenideElement singInButton;
}
