package ui.steps;

import io.cucumber.java.en.Then;
import utils.testData.PagesUtils;


public class HomePageSteps extends PagesUtils {
    @Then("Проверка HomePage {string}")
    public void checkHomePage(String header) {
        homePageFlow.checkHeaderName(header);
    }
}
