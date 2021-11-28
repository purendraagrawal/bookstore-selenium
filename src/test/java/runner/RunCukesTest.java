package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import test.BaseTest;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featureFiles", glue = { "stepdefinition" }, plugin = { "pretty",
		"json:target/cucumber-report/cucumber.json", "html:target/cucumber-report/cucumber.html" }, monochrome = true)
public class RunCukesTest {

	@BeforeClass
	public static void setup() {
		BaseTest.setup();
	}

	@AfterClass
	public static void tearDown() {
		BaseTest.tearDown();
	}
}
