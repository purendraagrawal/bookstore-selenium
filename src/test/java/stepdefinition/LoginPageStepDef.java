package stepdefinition;

import context.TestContext;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageStepDef extends BaseStepDef {

	LoginPage login;

	public LoginPageStepDef(TestContext context) {
		testContext = context;
		login = testContext.getPageObjectManager().getLoginPage();
	}

	@When("clicks on Login button")
	public void clicks_on_login_button() {
		login.clickOnLogin();
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

}
