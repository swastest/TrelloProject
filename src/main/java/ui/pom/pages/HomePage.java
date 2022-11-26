package ui.pom.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ui.pom.interfaces.ProfileHeaderNavigation;
import ui.pom.interfaces.ProfileMenu;

@Getter
public class HomePage implements ProfileHeaderNavigation, ProfileMenu {
    @FindBy(css = ".boards-page-board-section-header-name")
    private SelenideElement myBoardsHeaderName;

    @FindBy(css = "[data-test-id='create-board-tile']")
    private SelenideElement createBoardButton;

    @FindBy(css = "ul.boards-page-board-section-list")
    private CollectionCondition boardsList;
    }

