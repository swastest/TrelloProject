package ui.steps;

import io.cucumber.java.en.Then;


public class HomePageSteps extends PagesUtils {
    @Then("Проверка HomePage {string}")
    public void checkHomePage(String header) {
        homePageFlow.checkHeaderName(header);
    }

/*    @Before(value = "UI")
    public void setUp(){
        Configuration.baseUrl = userConfig.url();
        Configuration.browserSize = "1800x500";
        System.out.println("======================");
    }

    @Before(value = "UI")
    public void afterMethod(){
        Selenide.closeWebDriver();
    }*/
}
