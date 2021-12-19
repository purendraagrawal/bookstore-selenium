package utils;

import java.util.InputMismatchException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUitl {

	private static By getLocator(String locator, String address) {
		switch (locator.toLowerCase()) {
		case "css":
			return By.cssSelector(address);
		case Constants.XPATH:
			return By.xpath(address);
		case "id":
			return By.id(address);
		case "classname":
			return By.className(address);
		case "linktext":
			return By.linkText(address);
		case "partiallinktext":
			return By.partialLinkText(address);
		case "name":
			return By.name(address);
		case "tagname":
			return By.tagName(address);
		default:
			throw new InputMismatchException(locator + " not found in the code. Kindly check");
		}
	}

	public static WebElement findElementUntilClickable(WebDriver driver, String locator, String address) {
		return WaitUtils.waitForElementUntilClickable(driver, getLocator(locator, address));
	}

	public static WebElement findElement(WebDriver driver, String locator, String address) {
		return driver.findElement(getLocator(locator, address));
	}

	public static WebElement findElementUntilVisible(WebDriver driver, String locator, String address) {
		return WaitUtils.waitForElementUntilVisible(driver, findElement(driver, locator, address));
	}

	public static WebElement fluentWait(WebDriver driver, String locator, String address) {
		return WaitUtils.getElementUsingFluentWait(driver, getLocator(locator, address));
	}

	public static void sendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}
}
