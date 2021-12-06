package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

plugin = { "pretty",
		"rerun:ReRunScenarios/FailedReRun.txt"} ,
glue = {"stepdefinitions"},
features = {"@ReRunScenarios/FailedReRun.txt"}

																							
)
public class FailedRun  extends AbstractTestNGCucumberTests  {

}
