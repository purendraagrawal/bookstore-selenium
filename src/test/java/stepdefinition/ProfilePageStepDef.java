package stepdefinition;

import org.junit.Assert;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProfilePage;

public class ProfilePageStepDef extends BaseStepDef {

	ProfilePage profilePage;

	public ProfilePageStepDef(TestContext context) {
		testContext = context;
		profilePage = testContext.getPageObjectManager().getProfilePage();
	}

	@When("{string} is present on Books List")
	public void bookIsPresent(String bookTitle) {
		Assert.assertTrue(profilePage.isBookPresent(bookTitle));
	}

	@When("user removes {string} book")
	public void userRemovesBook(String bookTitle) {
		profilePage.deleteBook(bookTitle);
	}

	@Then("user gets a pop-up with message {string}")
	public void validatePopupMessage(String message) {
		Assert.assertEquals(message, profilePage.getDialogMessage());
	}

	@When("user clicks on OK button in pop-up")
	public void clickOnOkButtonInPopUp() {
		profilePage.clickOnOkayButtonInDialog();
	}

}
