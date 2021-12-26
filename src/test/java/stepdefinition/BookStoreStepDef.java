package stepdefinition;

import org.junit.Assert;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.BookStorePage;

public class BookStoreStepDef extends BaseStepDef {

	BookStorePage bookStorePage;
	BasePage basePage;

	public BookStoreStepDef(TestContext context) {
		testContext = context;
		bookStorePage = testContext.getPageObjectManager().getBookStorePage();
		basePage = testContext.getPageObjectManager().getBasePage();
	}

	@When("user clicks on {string} book")
	public void user_clicks_on_book(String bookName) {
		bookStorePage.clickOnABookLink(bookName);
	}

	@When("user clicks on {string} page")
	public void user_clicks_on_page(String pageName) {
		if (pageName.equalsIgnoreCase("Book Store"))
			basePage.clickOnBookStoreLink();
		else if (pageName.equalsIgnoreCase("Profile"))
			basePage.clickOnProfileLink();
	}

	@Then("{string} title page should be displayed")
	public void title_page_should_be_displayed(String bookName) {
		Assert.assertEquals(bookName, bookStorePage.getTitleOfBook());
	}

	@When("user clicks on Add To Your Collection button")
	public void user_clicks_on_button() {
		bookStorePage.addBookToLibrary();
	}

}
