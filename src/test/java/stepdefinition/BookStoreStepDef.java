package stepdefinition;

import static org.junit.Assert.fail;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookStorePage;
import pages.LoginPage;
import pages.ProfilePage;
import test.BaseTest;
import utils.ScreenshotUtils;

public class BookStoreStepDef extends BaseStepDef {

	private LoginPage login = new LoginPage(BaseTest.getDriver());
	private BookStorePage bookStorePage;
	private ProfilePage profilePage;

	@When("clicks on Login button")
	public void clicks_on_login_button() {
		profilePage = login.clickOnLogin();
	}

	@When("user enters {string} credentials")
	public void user_enters_in_textbox_on_page(String status) {
		if (status.equalsIgnoreCase("valid")) {
			login.setUserName(userName);
			login.setPassword(password);
		} else {
			login.setUserName("invalid");
			login.setPassword("invalid");
		}
	}

	@Then("username should be displayed")
	public void assertText() {
		try {
			Assert.assertEquals(userName, basePage.getTextOfUserName());
		} catch (AssertionError e) {
			ScreenshotUtils.takeScreenshot(BaseTest.getDriver());
			fail();
		}
	}

	@When("user clicks on {string} book")
	public void user_clicks_on_book(String bookName) {
		bookStorePage.clickOnABookLink(bookName);
	}

	@When("user clicks on {string} page")
	public void user_clicks_on_page(String pageName) {
		if (pageName.equalsIgnoreCase("Book Store"))
			bookStorePage = basePage.clickOnBookStoreLink();
	}

	@Then("{string} title page should be displayed")
	public void title_page_should_be_displayed(String bookName) {
		try {
			Assert.assertEquals(bookName, bookStorePage.getTitleOfBook());
		} catch (AssertionError e) {
			ScreenshotUtils.takeScreenshot(BaseTest.getDriver());
			fail();
		}
	}

	@When("user clicks on Add To Your Collection button")
	public void user_clicks_on_button() {
		bookStorePage.addBookToLibrary();
	}

	@Then("{string} alert should displayed")
	public void alert_should_displayed(String alertMessage) {
		try {
			Assert.assertEquals(alertMessage, basePage.getTextOfAlert());
		} catch (AssertionError e) {
			ScreenshotUtils.takeScreenshot(BaseTest.getDriver());
			fail();
		}
	}

	@Then("user accepts the alert")
	public void acceptAlert() {
		bookStorePage.acceptAlert();
	}

	@Then("user clicks on Logout button")
	public void clickOnLogout() {
		basePage.clickOnLogOutLink();
	}

}
