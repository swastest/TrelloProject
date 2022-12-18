package ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = {"src/test/resources/features/boards.feature",
                "src/test/resources/features/login.feature",
                "src/test/resources/features/card.feature",
                "src/test/resources/features/api.feature"})
public class RunCucumberTest {

}