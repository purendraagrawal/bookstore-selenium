package pages;

import java.util.InputMismatchException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Constants;
import utils.ElementUtil;

public class ProfilePage extends BasePage {

	private final String booksNameList = "//span[@class='mr-2']//a";
	private final String deleteBookButtonList = "//span[@id='delete-record-undefined']//*[name()='svg']";
	private final String deleteBookDialogMessage = "//div[@role='dialog']//div[@class='modal-body']";
	private final String btnOKDialog = "//button[contains(@id,'closeSmallModal-ok')]";

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	private List<WebElement> getListOfBooks() {
		return ElementUtil.findElementsUntilVisible(driver, Constants.XPATH, booksNameList);
	}

	private List<WebElement> getListOfDeleteButton() {
		return ElementUtil.findElementsUntilVisible(driver, Constants.XPATH, deleteBookButtonList);
	}

	public void clickOnOkayButtonInDialog() {
		ElementUtil.click(driver, Constants.XPATH, btnOKDialog);
	}

	public String getDialogMessage() {
		return ElementUtil.findElementUntilVisible(driver, Constants.XPATH, deleteBookDialogMessage).getText();
	}

	private int findIndex(String bookTitle) {
		List<WebElement> list = getListOfBooks();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equalsIgnoreCase(bookTitle))
				return i;
		}
		return -1;
	}

	public boolean isBookPresent(String bookTitle) {
		if (findIndex(bookTitle) == -1)
			return false;
		return true;
	}

	public void deleteBook(String bookTitle) {
		if (sizeEqualsOfLabelAndButton()) {
			int index = findIndex(bookTitle);
			getListOfDeleteButton().get(index).click();
		} else {
			throw new InputMismatchException("Books size is not equal to the buttons size");
		}
	}

	private boolean sizeEqualsOfLabelAndButton() {
		return getListOfBooks().size() == getListOfDeleteButton().size();
	}
}
