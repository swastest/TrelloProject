package ui;

import api.ApiClient;
import com.codeborne.selenide.Condition;
import io.restassured.http.Method;
import org.junit.jupiter.api.Test;
import utils.PagesUtils;
import utils.testData.EndPoints;
import utils.testData.Users;

import static com.codeborne.selenide.Selenide.*;

public class Tests extends PagesUtils {
    @Test
    void test01() {
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

    @Test
    void test02() {
        ApiClient api = new ApiClient();
        api.addContentTypeJson()
                .addQueryParam("key", Users.TEST_USER_1.getKey())
                .addQueryParam("token", Users.TEST_USER_1.getToken())
                .build()
                .sendRequest(Method.GET,200, EndPoints.ALL_BOARDS);
    }

}
