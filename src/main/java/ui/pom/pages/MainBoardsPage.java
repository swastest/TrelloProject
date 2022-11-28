package ui.pom.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class MainBoardsPage {
    @FindBy(css = ".all-boards")
    private SelenideElement allBoards;

 //   @FindBy(css = ".boards-page-board-section-list")
    private ElementsCollection spaseBoards = $$(".boards-page-board-section-list");

 //   @FindBy(css = "[title='Argentina Ullrich']")
    private SelenideElement tableButton = $("[title='Argentina Ullrich']").ancestor("a");
}
