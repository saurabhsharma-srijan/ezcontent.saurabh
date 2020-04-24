package ezcontent.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.Wait;

public class LoginPage extends TestBase {

	// Page Factory = Object Repository:

	@FindBy(id = "edit-name")
	WebElement username;

	@FindBy(id = "edit-pass")
	WebElement password;

	@FindBy(id = "edit-submit")
	WebElement loginButton;

	@FindBy(id = "edit-forgot-password-link")
	WebElement forgetPswd;

	@FindBy(xpath = "//div[@class='layout-container']//a//img")
	WebElement logo;

	// to initialize the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}

	public void validateLogin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
	}

	public void forgetPaswd() {
		forgetPswd.click();

	}

}
