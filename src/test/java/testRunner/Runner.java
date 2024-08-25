package testRunner;
/*
 * This is Runner file to execute the test
 */
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { ".//features" }, glue = { "stepsDefinitions", "hooks" }, plugin = { "pretty",
		"html:reports/myreport.html"},dryRun=false,monochrome=true, tags = "@regression")
public class Runner {

}
