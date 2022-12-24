package ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/"},
        glue= {"src/main/java/ui/steps"},
        features = {"src/test/resources/features/boards.feature",
                "src/test/resources/features/login.feature",
                "src/test/resources/features/card.feature",
                "src/test/resources/features/api.feature"})
public class RunCucumberTest {

}