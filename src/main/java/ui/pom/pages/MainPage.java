package ui.pom.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainPage {
    @FindBy(css = "a[href='/login']")
    private SelenideElement singInButton;
}
