package ezcontent.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;

public class ArticleMedia extends TestBase{
	LoginPage loginpage = new LoginPage();
	
	
	// Page Factory = Object Repository:
	
	@FindBy(xpath =".//li[@class='menu-item menu-item--expanded hover-intent']")
	WebElement content;
	
	@FindBy(xpath = ".//a[@class='toolbar-icon toolbar-icon-admin-toolbar-tools-add-content is-active']")
	WebElement addContent;
	
	@FindBy(xpath = ".//*[@class='admin-item']//a[@href='/node/add/article']")
	WebElement article;
	
	@FindBy(xpath = "//*[@class=\"page-logo-with-title\"]/a/img")
	WebElement logo;
	
	@FindBy(id = "edit-title-0-value")
	WebElement title;
	
	@FindBy(id = "edit-field-short-title-0-value")
	WebElement shortTitle;
	
	@FindBy(id = "edit-field-short-title-0-value--description")
	WebElement shortTitleHelpText;
	
	@FindBy(id = "edit-field-subhead-0-value")
	WebElement shortHead;
	
	@FindBy(id = "autocomplete-deluxe-input")
	WebElement author;
	
	@FindBy(id = "edit-field-summary-0-value")
	WebElement summary;
	
	@FindBy(id = "edit-field-thumbnail-entity-browser-entity-browser-open-modal")
	WebElement selectImage;
	
	@FindBy(xpath = "//*[@id=\"entity-browser-image-browser-form\"]/div[1]/div[2]/div[1]")
	WebElement thumbnailImage;
	
	@FindBy(id = "edit-submit")
	WebElement imageSelect;
	
	@FindBy(name = "button_add_modal")
	WebElement addParagraph;
	
	@FindBy(id = "field-content-assets-add-more")
	WebElement media;
	
	@FindBy(xpath = "//*[@id=\"node-article-form\"]/div/div[1]/details")
	WebElement taxonomy;
	
	@FindBy(xpath = "//*[@class=\"autocomplete-deluxe-container ui-sortable autocomplete-deluxe-multiple\"]")
	WebElement tags;
	
	@FindBy(id = "edit-field-yoast-seo-0-yoast-seo-focus-keyword")
	WebElement focusKeyword;
	
	@FindBy(id = "edit-submit")
	WebElement save;
	
	//To initialize the page objects
	
	    ArticleMedia() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public String validateArticlePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	
	public void createArticle() {
		content.click();
		addContent.click();
		article.click();
		title.sendKeys("test");
		
	}
		
	}
	
	

