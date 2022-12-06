package ui.pom.interfaces;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public interface ProfileHeaderNavigation {
    SelenideElement memberMenuButton = $("[data-testid='header-member-menu-button']");
    SelenideElement headerInfoButton = $("[data-testid='header-info-button']");

    default void clickProfileButton(){
        memberMenuButton.click();
    }
    default void clickFaqButton(){
        headerInfoButton.click();
    }
}
