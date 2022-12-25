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

    private ElementsCollection spaseBoards = $$(".boards-page-board-section-list");

    private SelenideElement tableButton = $("a[href*='helloworld']");
}
