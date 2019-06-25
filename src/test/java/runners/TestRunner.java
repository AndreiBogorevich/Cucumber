package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature", 
				glue = { "stepDefinition" }, 
				plugin = { "pretty", "html:target/cucumber-reports" },
				monochrome = true, 
				dryRun = false)
public class TestRunner {

}
