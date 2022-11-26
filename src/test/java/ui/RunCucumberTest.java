package ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = "src/test/resources/features",
glue = {"cucumber", "cucumber/config", "cucumber/helpers", "cucumber/pages", "cucumber/steps" } )
public class RunCucumberTest {

}