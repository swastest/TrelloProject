package ui.flow;

import com.codeborne.selenide.Selenide;
import ui.pom.pages.HomePage;

import static com.codeborne.selenide.Condition.text;

public class HomePageFlow {
    public HomePageFlow checkHeaderName(String text) {
        Selenide.page(HomePage.class).getMyBoardsHeaderName().shouldHave(text(text));
        return this;
    }

    public HomePageFlow clickProfileButton(String text){
        Selenide.page(HomePage.class).clickProfileButton();
        return this;
    }

    public HomePageFlow checkUserNameProfile(String text){
        Selenide.page(HomePage.class).checkUserName(text);
        return this;
    }




}
