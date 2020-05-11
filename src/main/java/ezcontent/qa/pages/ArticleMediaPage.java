package ezcontent.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleMediaPage extends TestBase {
	LoginPage loginpage = new LoginPage();
	TestUtil util = new TestUtil();

	// Page Factory = Object Repository:

	@FindBy(xpath = "//li[@class='menu-item menu-item--expanded']/a[@href='/admin/content']")
	WebElement content;

	@FindBy(xpath = "//li[@class='local-actions__item']/a[@href='/node/add']")
	WebElement addContent;

	@FindBy(xpath = "//dt[@class='admin-item__title']/a[@href='/node/add/article']")
	WebElement article;

	@FindBy(xpath = "//*[@class=\"page-logo-with-title\"]/a/img")
	WebElement logo;

	@FindBy(id = "edit-title-0-value")
	WebElement title;
	
	@FindBy(id = "edit-revision-log-0-value")
	WebElement RivisionMessage;
	
	@FindBy(xpath = "//*[@id='edit-menu']//summary[text()='Menu settings']")
	WebElement menuSetting;
	
	@FindBy(xpath = "//*[@id='edit-field-meta-tags-0']//summary[text()='Meta Tags']")
	WebElement metaTags;
	
	@FindBy(xpath = "//*[@id='edit-simple-sitemap']//summary[text()='Simple XML Sitemap']")
	WebElement xmlSiteMap;
	
	@FindBy(xpath = "//*[@id='edit-scheduler-settings']//summary[text()='Scheduling options']")
	WebElement scheduling;
	
	@FindBy(xpath = "//*[@id='edit-path-0']//summary[text()='URL alias']")
	WebElement urlAlias;
	
	@FindBy(xpath = "//*[@id='edit-author']//summary[text()='Authoring information']")
	WebElement authoringinfo;
	
	@FindBy(xpath = "//*[@id='edit-options']//summary[text()='Promotion options']")
	WebElement promotionOption;
	

	@FindBy(id = "edit-field-short-title-0-value")
	WebElement shortTitle;

	@FindBy(id = "edit-field-short-title-0-value--description")
	WebElement shortTitleHelpText;

	@FindBy(id = "edit-field-subhead-0-value")
	WebElement subHead;

	@FindBy(id = "autocomplete-deluxe-input")
	WebElement author;

	@FindBy(id = "edit-field-summary-0-value")
	WebElement summary;

	@FindBy(id = "edit-field-thumbnail-entity-browser-entity-browser-open-modal")
	WebElement selectImage;

	@FindBys({ @FindBy(xpath = "//div[@class='views-row']") })
	List<WebElement> thumbnailImage;

	@FindBy(id = "edit-submit")
	WebElement imageSelect;

	@FindBy(xpath = "//input[@class='paragraph-type-add-modal-button js-show button js-form-submit form-submit']")
	WebElement addParagraph;

	@FindBy(xpath = "//*[@class='paragraphs-add-dialog js-hide ui-dialog-content ui-widget-content']//li[@class='paragraphs-add-dialog-row'][2]")
	WebElement media;

	@FindBy(xpath = "//details[@class='js-form-wrapper form-wrapper claro-details']//summary[text()='Media']")
	WebElement mediaType;

	@FindBy(name = "field_content_0_subform_field_media_entity_browser_entity_browser")
	WebElement selectMediaAsset;

	@FindBy(xpath = "//*[@class='views-row'][2]")
	WebElement mediaTypeImage;

	@FindBy(id = "entity_browser_iframe_asset_browser")
	WebElement mediaFrameId;

	@FindBy(id = "edit-submit")
	WebElement selectMediaImage;

	@FindBy(xpath = "//*[@class='required-fields field-group-details js-form-wrapper form-wrapper claro-details']")
	WebElement taxonomy;

	@FindBy(name = "field_tags[target_id][textfield]")
	WebElement tags;

	@FindBy(id = "edit-field-yoast-seo-0-yoast-seo-focus-keyword")
	WebElement focusKeyword;

	@FindBy(id = "edit-submit")
	WebElement save;

	@FindBy(id = "entity_browser_iframe_image_browser")
	WebElement frameId;

	@FindBy(xpath = "//*[@id=\"node-article-form\"]/div/div[1]/fieldset[3]/legend/span")
	WebElement contain;

	@FindBy(xpath = "//*[@class='js-quickedit-page-title title']/span[@class='field field--name-title field--type-string field--label-hidden quickedit-field']")
	WebElement successfullMessage;
	
	@FindBy(xpath = "//*[@id=\"node-article-edit-form\"]/div/div[1]/fieldset[3]/legend/span")
	WebElement content1;
	
	@FindBy(xpath = "//p[contains(text(),'You can select up to 1 media items (0 left).')]")
	WebElement mediaMessage;
	
	@FindBy(xpath = "//*[@id=\"edit-field-thumbnail\"]/summary")
	WebElement thumbnail;
	
	// To initialize the page objects

	public ArticleMediaPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions

	public String validateArticlePageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public boolean validateTitle() {
		return title.isDisplayed();
	}
	
	public boolean validateShortTitle() {
		return shortTitle.isDisplayed();
	}
	public boolean validateSubHead() {
		return subHead.isDisplayed();
	}
    public boolean author() {
    	return author.isDisplayed();	
    }
    
    public boolean summary() {
    	return summary.isDisplayed();
    }
    public boolean selectImageField() {
    	return selectImage.isDisplayed();
    }
    public boolean media() {
    	return contain.isDisplayed();
    }
    
    public boolean selectAsset() {
    	return taxonomy.isDisplayed();
    }
    
    public boolean addParagraph() {
    	return addParagraph.isDisplayed();
    }
    public boolean taxnomy() {
    	return taxonomy.isDisplayed();
    }
    
    public boolean menuSetting() {
    	return menuSetting.isDisplayed();  	
    }
    public boolean xmlSiteMap() {
    	return xmlSiteMap.isDisplayed(); 
    }
    public boolean scheduling() {
    	return scheduling.isDisplayed(); 
    }
    public boolean metaTags() {
    	return metaTags.isDisplayed(); 
    }
    public boolean urlAlias() {
    	return urlAlias.isDisplayed(); 
    }
    
    public boolean authoring() {
    	return authoringinfo.isDisplayed(); 
    }
    public boolean promotion() {
    	return promotionOption.isDisplayed(); 
    }
    
	public void dashBoardPage() throws InterruptedException {
		content.click();
		Wait.Pause(3000);
		//addContent.click();
		WebElement element = addContent;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Wait.Pause(3000);
		article.click();
		Wait.Pause(3000);
	}

	public void createArticle() throws InterruptedException {
		//Wait.implicitWait(25);
		title.sendKeys("Test Title");
		RivisionMessage.sendKeys("test");
		shortTitle.sendKeys("Short Title");
		subHead.sendKeys("Test subHead");
		author.sendKeys("Male User", Keys.TAB);
		summary.sendKeys("Test");
		Wait.Pause(4000);
		util.scroll(0, 300);
		selectImage.click();
		Wait.Pause(5000);
		driver.switchTo().frame(frameId);
		List<WebElement> elements = thumbnailImage;
		System.out.println(elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i).getText());

			if (elements.get(i).getText().equalsIgnoreCase("Image page_builder.png")) {
				elements.get(i).click();
				break;
			}

		}
		imageSelect.click();
		Wait.Pause(5000);
		String imgMediamessage = mediaMessage.getText();
		System.out.println("message is :" + imgMediamessage);
		System.out.println("content is display");
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].scrollIntoView()", contain);
		addParagraph.click();
		media.click();
		Wait.Pause(5000);
		mediaType.click();
		selectMediaAsset.click();
		Wait.Pause(6000);
		driver.switchTo().frame(mediaFrameId);
		Wait.Pause(2000);
		mediaTypeImage.click();
		selectMediaImage.click();
		util.scroll(0, 500);
		taxonomy.click();
		tags.sendKeys("Architecture", Keys.RETURN);
		focusKeyword.sendKeys("test");
		save.click();

	}


}
