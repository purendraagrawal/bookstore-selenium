package pages;

import org.openqa.selenium.WebDriver;

import utils.Constants;
import utils.ElementUtil;

public class BasePage {

	protected WebDriver driver;
	private final String welcomeUserNameAddress = "//label[@id='userName-value']";
	private final String bookStoreLink = "//span[normalize-space()='Book Store']";
	private final String profileLink = "//span[normalize-space()='Profile']";
	private final String logOutLink = "//button[@id='submit' and text()='Log out']";

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextOfUserName() {
		return ElementUtil.getElementUsingfluentWait(driver, Constants.XPATH, welcomeUserNameAddress).getText();
	}

	public BookStorePage clickOnBookStoreLink() {
		ElementUtil.click(driver, Constants.XPATH, bookStoreLink);
		return new BookStorePage(driver);
	}

	public LoginPage clickOnLogOutLink() {
		ElementUtil.click(driver, Constants.XPATH, logOutLink);
		return new LoginPage(driver);
	}

	public ProfilePage clickOnProfileLink() {
		ElementUtil.click(driver, Constants.XPATH, profileLink);
		return new ProfilePage(driver);
	}

	public String getTextOfAlert() {
		return ElementUtil.getTextOfAlert(driver);
	}

	public void acceptAlert() {
		ElementUtil.acceptAlert(driver);
	}
}
