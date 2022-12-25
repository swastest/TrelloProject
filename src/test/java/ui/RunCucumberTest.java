package ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        //      glue= {"src/main/java/ui/steps"},
        features = {"src/test/resources/features"})
public class RunCucumberTest {

}