package ui.flow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ui.pom.pages.MainPage;

public class MainPageFlow {
    public MainPageFlow clickSingInButton(){
        Selenide.page(MainPage.class).getSingInButton().shouldBe(Condition.visible).click();
        return this;
    }
}
