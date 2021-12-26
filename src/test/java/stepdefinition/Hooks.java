package stepdefinition;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtils;

public class Hooks {

	TestContext context;

	public Hooks(TestContext context) {
		this.context = context;
	}

	@Before
	public void before() {

	}

	@After
	public void after(Scenario scenario) {
		if (scenario.isFailed()) {
			ScreenshotUtils.takeScreenshot(context.getWebDriverManager().getDriver());
		}
		context.getWebDriverManager().tearDown();
	}
}
