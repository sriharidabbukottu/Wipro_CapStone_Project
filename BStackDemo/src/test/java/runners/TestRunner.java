package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefs","base"},
		plugin = {"pretty","html:target/cucumber-reports.html"},
		publish = false
		)
public class TestRunner extends AbstractTestNGCucumberTests
{
	
}
