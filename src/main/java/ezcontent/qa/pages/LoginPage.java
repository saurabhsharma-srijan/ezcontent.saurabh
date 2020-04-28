package ezcontent.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
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
	WebElement forgetPassword;

	@FindBy(xpath = "//div[@class='layout-container']//a//img")
	WebElement logo;
	
	@FindBy(xpath = "//input[@id='edit-name']/preceding-sibling::label")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//input[@id='edit-pass']/preceding-sibling::label")
	WebElement passwordLabel;
	
	@FindBy(id = "edit-name--description")
	WebElement usernameHelpText;
	
	@FindBy(id = "edit-pass--description")
	WebElement passwordHelpText;
	
	@FindBy(id = "toolbar-item-user")
	WebElement toolBarIcon;
	
	@FindBy(linkText = "Log out")
	WebElement logout;
	
	

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
	

	public void forgetPassword() {
		forgetPassword.click();

	}
	public String validateUsernameLabel() {
		return usernameLabel.getText();
	}
	public String validatePasswordLabel() {
		return passwordLabel.getText();
	}
	public String validateuserNameHelpText() {
		return usernameHelpText.getText();
	}
	public String validatepasswordHelpText() {
		return passwordHelpText.getText();
	}
	
	public String validateDashboardPageTitle() {
		return driver.getTitle();
	}
	public void logOut() {
		toolBarIcon.click();
		if (logout.isDisplayed())
		{
			logout.click();
		}	
		else {
			System.out.println("Failed");
			
			
		}
		
		
}}
