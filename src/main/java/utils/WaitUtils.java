package utils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private static int implicitTimeoutInSeconds = 10;
	private static int explicitTimeoutInSeconds = 10;

	public static void setImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(implicitTimeoutInSeconds, TimeUnit.SECONDS);
	}

	public static WebElement waitForElementUntilClickable(WebDriver driver, By locator) {
		return new WebDriverWait(driver, explicitTimeoutInSeconds)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static Alert waitForAlert(WebDriver driver) {
		return new WebDriverWait(driver, explicitTimeoutInSeconds).until(ExpectedConditions.alertIsPresent());
	}

	public static WebElement waitForElementUntilVisible(WebDriver driver, WebElement element) {
		return new WebDriverWait(driver, explicitTimeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
	}

	public static List<WebElement> waitForElementsUntilVisible(WebDriver driver, By locator) {
		return new WebDriverWait(driver, explicitTimeoutInSeconds)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public static WebElement getElementUsingFluentWait(WebDriver driver, final By locator) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			return wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			});
		} catch (Exception e) {
			ScreenshotUtils.takeScreenshot(driver);
			throw e;
		}
	}

	public static List<WebElement> getListOfElementsUsingFluentWait(WebDriver driver, final By locator) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
			return wait.until(new Function<WebDriver, List<WebElement>>() {
				public List<WebElement> apply(WebDriver driver) {
					return driver.findElements(locator);
				}
			});
		} catch (Exception e) {
			ScreenshotUtils.takeScreenshot(driver);
			throw e;
		}
	}

	public static WebElement waitForElementUntilClickable(WebDriver driver, WebElement element) {
		return new WebDriverWait(driver, explicitTimeoutInSeconds)
				.until(ExpectedConditions.elementToBeClickable(element));
	}

}
