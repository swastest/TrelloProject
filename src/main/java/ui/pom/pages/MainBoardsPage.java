package ui.pom.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainBoardsPage {
    @FindBy(css = ".all-boards")
    private SelenideElement allBoards;
}
