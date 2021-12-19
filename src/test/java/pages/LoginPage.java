package pages;

import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.ElementUtil;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private final String userNameAddress = "//input[@id='userName']";
	private final String passwordAddress = "//input[@id='password']";
	private final String loginButtonAdress = "//button[@id='login']";

	public void setUserName(String username) {
		ElementUtil.sendKeys(ElementUtil.findElementUntilClickable(driver, Constants.XPATH, userNameAddress), username);
	}

	public void setPassword(String password) {
		ElementUtil.sendKeys(ElementUtil.findElementUntilClickable(driver, Constants.XPATH, passwordAddress), password);
	}

	public ProfilePage clickOnLogin() {
		ElementUtil.click(driver, Constants.XPATH, loginButtonAdress);
		return new ProfilePage(driver);
	}
}
