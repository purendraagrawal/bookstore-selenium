package stepdefinition;

import pages.BasePage;
import test.BaseTest;
import utils.ConfigReader;

public class BaseStepDef {

	protected BasePage basePage;
	protected final String userName;
	protected final String password;
	protected ConfigReader config;

	public BaseStepDef() {
		basePage = new BasePage(BaseTest.getDriver());
		config = ConfigReader.getInstance();
		userName = config.getValueOfKey("username");
		password = config.getValueOfKey("password");
	}
}
