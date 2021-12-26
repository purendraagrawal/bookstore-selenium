package manager;

import org.openqa.selenium.WebDriver;

import pages.BasePage;
import pages.BookStorePage;
import pages.LoginPage;
import pages.ProfilePage;

public class PageObjectManager {

	private WebDriver driver;
	private BasePage basePage;
	private LoginPage loginPage;
	private ProfilePage profilePage;
	private BookStorePage bookStorePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public BasePage getBasePage() {
		return (basePage == null) ? basePage = new BasePage(driver) : basePage;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public ProfilePage getProfilePage() {
		return (profilePage == null) ? profilePage = new ProfilePage(driver) : profilePage;
	}
	
	public BookStorePage getBookStorePage() {
		return (bookStorePage == null) ? bookStorePage = new BookStorePage(driver) : bookStorePage;
	}

}
