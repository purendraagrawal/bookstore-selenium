package stepdefinition;

import pages.BasePage;
import test.BaseTest;

public class BaseStepDef {

	protected BasePage basePage;

	public BaseStepDef() {
		basePage = new BasePage(BaseTest.getDriver());
	}
}
