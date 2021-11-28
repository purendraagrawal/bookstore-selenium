package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Constants;

public class BaseTest {

	private static WebDriver driver;

	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.URL);
	}

	public static void tearDown() {
		if (driver != null)
			driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
