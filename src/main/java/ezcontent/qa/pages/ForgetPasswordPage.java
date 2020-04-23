package ezcontent.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;

public class ForgetPasswordPage extends TestBase {
	
	@FindBy(id = "edit-name")
	WebElement username;

	@FindBy(id = "edit-submit")
	WebElement resetButton;

	@FindBy(xpath = "//div[@class='layout-container']//a//img")
	WebElement logo;
	
	@FindBy(xpath = "//div[@class='messages__content']")
	WebElement statusMessage;

	// to initialize the page objects
	public ForgetPasswordPage() {
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:

	public String validateForgetPaswdTitle() {
		return driver.getTitle();
	}

	public boolean validateForgetPaswdLogo() {
		return logo.isDisplayed();
	}

	public void submitForgetPaswd(String regMail) {
		username.sendKeys(regMail);
		resetButton.click();
	}
	
	public String validateStatusMessage() {
		return statusMessage.getText();
	}
	
}