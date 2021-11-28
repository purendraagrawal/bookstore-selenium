package pages;

import org.openqa.selenium.WebDriver;

import utils.Constants;
import utils.ElementUitl;

public class BasePage {

	protected WebDriver driver;
	private String welcomeUserNameAddress = "//label[@id='userName-value']";
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTextOfUserName() {
		return ElementUitl.fluentWait(driver, Constants.XPATH, welcomeUserNameAddress).getText();
	} 
	
	

}
