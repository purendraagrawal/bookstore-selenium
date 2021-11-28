package utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

	public static WebElement waitForElementUntilVisible(WebDriver driver, WebElement element) {
		return new WebDriverWait(driver, explicitTimeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement fluentWait(WebDriver driver, final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
	}

	public static WebElement waitForElementUntilClickable(WebDriver driver, WebElement element) {
		return new WebDriverWait(driver, explicitTimeoutInSeconds)
				.until(ExpectedConditions.elementToBeClickable(element));
	}

}
