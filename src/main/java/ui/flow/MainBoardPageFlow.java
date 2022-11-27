package ui.flow;

import com.codeborne.selenide.Selenide;
import ui.pom.interfaces.ProfileHeaderNavigation;
import ui.pom.interfaces.ProfileMenu;
import ui.pom.pages.MainBoardsPage;

import static com.codeborne.selenide.Condition.text;

public class MainBoardPageFlow implements ProfileHeaderNavigation, ProfileMenu {
    public MainBoardPageFlow checkAllBoards(String text){
        Selenide.page(MainBoardsPage.class).getAllBoards().shouldHave(text(text));
        return this;
    }
}
