package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Constants;

public class WebDriverManager {

	WebDriver driver;

	private WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		return driver;
	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver == null ? driver = createDriver() : driver;
	}

}
