package ui.flow;

import com.codeborne.selenide.Selenide;
import ui.pom.interfaces.ProfileHeaderNavigation;
import ui.pom.interfaces.ProfileMenu;
import ui.pom.pages.MainBoardsPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MainBoardPageFlow implements ProfileHeaderNavigation, ProfileMenu {
    public MainBoardPageFlow checkAllBoards(String text){
        Selenide.page(MainBoardsPage.class).getAllBoards().shouldHave(text(text));
        return this;
    }
    public MainBoardPageFlow clickOnTable(){
        Selenide.page(MainBoardsPage.class).getTableButton().shouldHave(visible, Duration.ofSeconds(15)).click();
        return this;
    }
}
