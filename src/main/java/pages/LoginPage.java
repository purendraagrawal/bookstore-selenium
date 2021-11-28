package pages;

import org.openqa.selenium.WebDriver;

import utils.Constants;
import utils.ElementUitl;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private String userNameAddress = "//input[@id='userName']";
	private String passwordAddress = "//input[@id='password']";
	private String loginButtonAdress = "//button[@id='login']";

	public void setUserName(String username) {
		ElementUitl.sendKeys(ElementUitl.findElementUntilClickable(driver, Constants.XPATH, userNameAddress), username);
	}

	public void setPassword(String password) {
		ElementUitl.sendKeys(ElementUitl.findElementUntilClickable(driver, Constants.XPATH, passwordAddress), password);
	}

	public void clickOnLogin() {
		ElementUitl.findElementUntilClickable(driver, Constants.XPATH, loginButtonAdress).click();
	}
}
