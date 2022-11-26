package ui.pom.interfaces;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public interface ProfileMenu {

    SelenideElement userMenu = $("[data-test-id='header-member-menu-popover']");

    default void checkUserName(String text){
        userMenu.shouldHave(text(text));
    }
}
