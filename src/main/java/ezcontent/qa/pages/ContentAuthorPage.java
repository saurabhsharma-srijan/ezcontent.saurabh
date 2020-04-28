package ezcontent.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;

public class ContentAuthorPage extends TestBase{
	
	TestUtil util = new TestUtil();
	

	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-system-admin-content']")
	WebElement Content;

	@FindBy(linkText = "Add content")
	WebElement AddContent;

	@FindBy(linkText = "Author")
	WebElement Author;
	
	@FindBy(xpath = "//h1[@class='page-title']")
	WebElement header;
	
	@FindBy(id = "edit-title-0-value")
	WebElement FullName;
	
	@FindBy(xpath = "//summary[contains(text(),'Avatar')]")
	WebElement Avatar;
	
	@FindBy(xpath = "//input[@name='field_thumbnail_entity_browser_entity_browser']")
	WebElement selcetimagebutton;
	
	@FindBy(name="entity_browser_iframe_image_browser")
	WebElement AuthorAvatarFrame;
	
	
	@FindBy(xpath = ("(//div[@class='views-row'])[1]"))
	WebElement imageSelect;
	
	
	@FindBy(xpath = "//input[@id='edit-submit']")
	WebElement imageSelectbutton;
	

	@FindBy(xpath = "//*[@id='edit-body-wrapper']/div/div[2]/label/span/button")  
	WebElement summary;
	
	
	@FindBy(xpath = "//*[@id='edit-body-0-summary']") 
	WebElement entersummary;
	
	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")  
	WebElement bioframe;
	
	@FindBy(xpath = "//body//p")
	WebElement enterbiobody;
	
	@FindBy(xpath = "//*[@id='edit-status-value']")  
	WebElement publish;
	
	@FindBy(xpath = "//input[@name='op']")
	WebElement save;
	
	public ContentAuthorPage() {
		PageFactory.initElements(driver, this); 
	}
	
	
	public void reachToAuthorPage() throws InterruptedException {
				
		util.action(Content);
		util.action(AddContent);
		Author.click();
 		
	}
	
	public String validateWindowTabTitle() {
		return driver.getTitle();
	}
	
	public String validateHeaderTitle() {
		return header.getText();
	}
	
	

	public void enterFullName(String fn) {
		FullName.sendKeys(fn);
	}
	
	public void uploadImage() throws InterruptedException {
		Avatar.click();
		selcetimagebutton.click();
		util.switchFrameByWebElement(AuthorAvatarFrame);
		System.out.println("In frame");
		imageSelect.click();		
		imageSelectbutton.click();
		util.switchBackToWindow();
		System.out.println("On default page");
	}
	
	public void summaryEntry(String sum) throws InterruptedException {
		
		util.windowScroller();
		summary.click();
		entersummary.sendKeys(sum);	
	}
	
	public void bioEntry(String bio) {
		util.switchFrameByWebElement(bioframe);
		System.out.println("In frame BIO");
		enterbiobody.sendKeys(bio);	
		util.switchBackToWindow();
		System.out.println("On default page");
	}
	
	public void unpublish() {
		publish.click();
	}
	
	public void saveContent() {
		save.click();
	}
	
		
	
	
}
