package pages;

import java.util.InputMismatchException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Constants;
import utils.ElementUtil;

public class BookStorePage extends BasePage {

	private final String booksList = "//span[@class='mr-2']/a";
	private final String bookTitle = "//div[@id='title-wrapper']//label[@id='userName-value']";
	private final String btnAddToYourCollection = "//button[normalize-space()='Add To Your Collection']";

	public BookStorePage(WebDriver driver) {
		super(driver);
	}

	private List<WebElement> getListOfBooks() {
		return ElementUtil.findElementsUntilVisible(driver, Constants.XPATH, booksList);
	}

	public String getTitleOfBook() {
		return ElementUtil.findElementUntilVisible(driver, Constants.XPATH, bookTitle).getText();
	}

	public void addBookToLibrary() {
		ElementUtil.click(driver, Constants.XPATH, btnAddToYourCollection);
	}

	public void clickOnABookLink(String bookTitle) {
		boolean flag = false;
		for (WebElement element : getListOfBooks()) {
			if (element.getText().equalsIgnoreCase(bookTitle)) {
				ElementUtil.click(element, driver);
				flag = true;
				break;
			}
		}
		if (!flag)
			throw new InputMismatchException(bookTitle + " is not present in the books list");
	}
}
