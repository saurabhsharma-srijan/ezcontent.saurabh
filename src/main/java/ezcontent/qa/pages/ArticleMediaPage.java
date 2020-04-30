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

	@FindBy(xpath = "//*[@class='views-row'][1]")
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

	public void dashBoardPage() throws InterruptedException {
		content.click();
		//Wait.Pause(2000);
		addContent.click();
		//Wait.Pause(2000);
		article.click();
		Wait.Pause(2000);
	}

	public void createArticle() throws InterruptedException {
		//Wait.pageLoad(10);
		title.sendKeys("Test Title");
		shortTitle.sendKeys("Short Title");
		subHead.sendKeys("Test subHead");
		author.sendKeys("Male User", Keys.TAB);
		summary.sendKeys("Test");
		util.scroll(0, 400);
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
		Wait.Pause(12000);
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
