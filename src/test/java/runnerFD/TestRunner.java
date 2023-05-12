package runnerFD;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepDef "},
		dryRun= true,
		plugin = {"pretty"},
		monochrome=true
		)
public class TestRunner {

}
