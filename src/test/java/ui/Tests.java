package ui;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import utils.PagesUtils;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class Tests extends PagesUtils {
    @Test
    void test01(){
        open("https://trello.com");
        mainPageFlow.clickSingInButton();
        singInPageFlow.setValueEmailLogin(userConfig.email())
                .clickNextAuthButton()
                .setValuePassword(userConfig.pass())
                .clickSubmitLoginButton();
        mainBoardPageFlow.clickOnTable();
       $$("div#board .list").findBy(Condition.text("В процессе")).$("a.open-card-composer").click();
       int a = 0;
    }

}
