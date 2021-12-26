package stepdefinition;

import context.TestContext;
import utils.ConfigReader;

public class BaseStepDef {

	protected final String userName;
	protected final String password;
	protected ConfigReader config;
	protected TestContext testContext;

	public BaseStepDef() {
		config = ConfigReader.getInstance();
		userName = config.getValueOfKey("username");
		password = config.getValueOfKey("password");
	}
}
