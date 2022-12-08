package ui.steps;

import api.models.ResponseBoards;
import io.cucumber.java.en.Then;
import utils.PagesUtils;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageSteps extends PagesUtils {
    @Then("Проверка HomePage {string}")
    public void checkHomePage(String header) {
        homePageFlow.checkHeaderName(header);
    }


}
