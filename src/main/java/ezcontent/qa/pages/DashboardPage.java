package ezcontent.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.Wait;

public class DashboardPage extends TestBase {

	// Page Factory = Object Repository:

	@FindBy(id = "toolbar-item-user")
	WebElement admin;

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logout;

	@FindBy(xpath = "//a[@id='toolbar-item-administration']")
	WebElement manage;

	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-system-admin-content']")
	WebElement content;

	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-admin-toolbar-tools-add-content']")
	WebElement addContent;

	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-node-add-article']")
	WebElement article;
	
	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-node-add-smart-article']")
	WebElement smartArticle;
	
	@FindBy(xpath = "//img[@class='img-fluid d-inline-block align-top']")
	WebElement dashboardLogo;
	
	@FindBys({
		@FindBy(xpath = "//li[@class = 'menu-item menu-item--expanded']/a[text()='Content']/following-sibling::ul/li/a") })
List<WebElement> allcontentList;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateDashboardTitle() {
		return driver.getTitle();
	}

	public boolean validateDashboardLogo() {
		return dashboardLogo.isDisplayed();
	}

	public void clickArticleLink() {
		Actions actions = new Actions(driver);
		Wait.visibiltyOfElement(10, content);
		actions.moveToElement(content).perform();
		
//		List<WebElement> elementlist = allcontentList;
//		System.out.println(elementlist.size());
//		for(WebElement element: elementlist) {
//		System.out.println(element.getText());	
//		if(element.getText().equalsIgnoreCase("Add content")) {
//		actions.moveToElement(addContent).perform();
//	    break;	 	 
//		}}	
		
		actions.moveToElement(addContent).perform();
		Wait.visibiltyOfElement(5, article);
		article.click();
	}
	
	public void clickSmartArticleLink() {
		Actions actions = new Actions(driver);
		Wait.visibiltyOfElement(10, content);
		actions.moveToElement(content).perform();
		actions.moveToElement(addContent).perform();
		Wait.visibiltyOfElement(5, smartArticle);
		smartArticle.click();
	}
	

	public void logout() {
		admin.click();
		logout.click();
	}

}
