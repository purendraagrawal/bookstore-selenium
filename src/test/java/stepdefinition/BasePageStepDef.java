package stepdefinition;

import org.junit.Assert;
import context.TestContext;
import io.cucumber.java.en.Then;
import pages.BasePage;

public class BasePageStepDef extends BaseStepDef {
	BasePage basePage;

	public BasePageStepDef(TestContext context) {
		testContext = context;
		basePage = testContext.getPageObjectManager().getBasePage();
	}

	@Then("username should be displayed")
	public void assertText() {
		Assert.assertEquals(userName, basePage.getTextOfUserName());
	}

	@Then("{string} alert should displayed")
	public void alert_should_displayed(String alertMessage) {
		Assert.assertEquals(alertMessage, basePage.getTextOfAlert());
	}

	@Then("user accepts the alert")
	public void acceptAlert() {
		basePage.acceptAlert();
	}

	@Then("user clicks on Logout button")
	public void clickOnLogout() {
		basePage.clickOnLogOutLink();
	}

}
