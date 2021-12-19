package utils;

import java.util.InputMismatchException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

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

	private static WebElement findElement(WebDriver driver, String locator, String address) {
		return driver.findElement(getLocator(locator, address));
	}

	private static List<WebElement> findElements(WebDriver driver, String locator, String address) {
		return driver.findElements(getLocator(locator, address));
	}

	public static WebElement findElementUntilVisible(WebDriver driver, String locator, String address) {
		return WaitUtils.waitForElementUntilVisible(driver, findElement(driver, locator, address));
	}

	public static List<WebElement> findElementsUntilVisible(WebDriver driver, String locator, String address) {
		return WaitUtils.waitForElementsUntilVisible(driver, getLocator(locator, address));
	}

	public static WebElement getElementUsingfluentWait(WebDriver driver, String locator, String address) {
		return WaitUtils.getElementUsingFluentWait(driver, getLocator(locator, address));
	}

	public static List<WebElement> getListOfElementUsingfluentWait(WebDriver driver, String locator, String address) {
		return WaitUtils.getListOfElementsUsingFluentWait(driver, getLocator(locator, address));
	}

	public static void sendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static void click(WebElement element, WebDriver driver) {
		try {
			element.click();
		} catch (ElementClickInterceptedException e) {
			clickUsingJavaScript(element, driver);
		}
	}

	public static void click(WebDriver driver, String locator, String address) {
		WebElement element = null;
		try {
			element = getElementUsingfluentWait(driver, locator, address);
			element.click();
		} catch (ElementClickInterceptedException e) {
			if (element != null)
				clickUsingJavaScript(element, driver);
			else
				throw e;
		}
	}

	private static void clickUsingJavaScript(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", element);
	}

	private static Alert switchToAlert(WebDriver driver) {
		WaitUtils.waitForAlert(driver);
		return driver.switchTo().alert();
	}

	public static String getTextOfAlert(WebDriver driver) {
		return switchToAlert(driver).getText();
	}

	public static void acceptAlert(WebDriver driver) {
		switchToAlert(driver).accept();
	}

}
