package stepdefinition;

import static org.junit.Assert.fail;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import test.BaseTest;
import utils.ScreenshotUtils;

public class BookStoreStepDef extends BaseStepDef {

	LoginPage login = new LoginPage(BaseTest.getDriver());

	@When("clicks on Login button")
	public void clicks_on_login_button() {
		login.clickOnLogin();
	}

	@When("user enters {string} in {string} textbox")
	public void user_enters_in_textbox_on_page(String value, String fieldName) {
		if (fieldName.equalsIgnoreCase("username"))
			login.setUserName(value);
		if (fieldName.equalsIgnoreCase("password"))
			login.setPassword(value);
	}
	
	@Then("{string} should be displayed")
	public void assertText(String value) {
		try {
		Assert.assertEquals(value, basePage.getTextOfUserName());
		}catch (AssertionError e) {
			ScreenshotUtils.takeScreenshot(BaseTest.getDriver());
			fail();
		}
	}
	
}
