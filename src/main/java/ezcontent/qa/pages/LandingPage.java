package ezcontent.qa.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;


public class LandingPage extends TestBase {
	
	LoginPage loginpage;
	TestUtil testutil = new TestUtil();
	
	@FindBy(xpath="//nav[@id='toolbar-bar']/div[2]/a")
	WebElement manage;
	
	@FindBy(xpath="//a[text()='Content']")
	WebElement content;
	
	@FindBy(xpath="//a[text()=\"Add content\"]")
	WebElement addcontent;
	
	@FindBy(xpath="//a[text()=\"Landing page\"]")
	WebElement landingPageContent;
	
	@FindBy(id="edit-title-0-value")
	WebElement titlefield;
	
	@FindBy(xpath="//label[text()='Title']")
	WebElement titlefieldlabel;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, Body field']")
	WebElement bodyFrame;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	WebElement bodyfield;
	
	@FindBy(xpath="//label[text()='Body']")
	WebElement bodyfieldlabel;
	
	
	@FindBy(id="edit-submit")
	WebElement savebtn;
	
	@FindBy(xpath="//textarea[@id='edit-revision-log-0-value']")
	WebElement revisionlogmsg;
	
	@FindBy(xpath="//div[@class='alert alert-dismissible fade show col-12 alert-success']")
	WebElement savestatusmsg;
	
	@FindBy(xpath="//button[@class='close']/span")
	WebElement cross;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs primary']//li[4]")
	WebElement layout;
	
	@FindBy(xpath="//div[@class='alert alert-dismissible fade show col-12 alert-success']")
	WebElement layoutStatusMsg;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[1]/a")
	WebElement addSection;
	
	@FindBy(xpath="//span[@id='ui-id-3']")
	WebElement sectiontitle;
	
	@FindBy(xpath="//div[@id='drupal-off-canvas']//ul[@class='layout-selection list-group']")
	WebElement section;
	
	@FindBy(xpath="//form[@class='layout-builder-configure-section']/fieldset/input[1]")
	WebElement sectionName;
	
	@FindBy(xpath="//form[@class='layout-builder-configure-section']/input[1]")
	WebElement addSectionBtn;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[2]//div[2]/a")
	WebElement addBlock;
	
	@FindBy(xpath="//div[@id='drupal-off-canvas']/div/a")
	WebElement createCustomBlockLink;
	
	@FindBy(xpath="//div[@id='drupal-off-canvas']//ul[@class='inline-block-list']")
	WebElement inlineBlockList;
	
	@FindBy(xpath="//input[@class='form-text required form-control']")
	WebElement configureBlockTitleField;
	
	@FindBy(xpath="//input[@class='js-text-full text-full form-text required form-control']")
	WebElement heroCardTitleField;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_card][0][subform][field_short_title][0][value]']")
	WebElement heroCardShortTitle;
	
	@FindBy(xpath="//input[@class='button js-form-submit form-submit btn btn-primary form-control entity-browser-processed']")
	WebElement selectImageBtn;
	
	@FindBy(xpath="//iframe[@class='entity-browser-modal-iframe']")
	WebElement entityBrowser;
	
	@FindBy(xpath="//div[@class='views-field views-field-thumbnail__target-id']")
	WebElement image;
	
	@FindBy(xpath="//input[@class='is-entity-browser-submit button button--primary js-form-submit form-submit']")
	WebElement selectBtn;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_card][0][subform][field_subhead][0][value]']")
	WebElement heroCardSubhead;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, Summary field']")
	WebElement summaryFrame;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	WebElement summaryText;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_card][0][subform][field_link][0][uri]']")
	WebElement linkUrl;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_card][0][subform][field_link][0][title]']")
	WebElement linkText;
	
	@FindBy(xpath="//select[@name='settings[block_form][field_card][0][subform][layout_selection]']")
	WebElement layoutSelection;
	
	@FindBy(xpath="//input[@name='settings_block_form_field_card_card_add_more']")
	WebElement addMoreBtn;
	
	@FindBy(xpath="//input[@value='Add block']")
	WebElement addBlockBtn;
	
	@FindBy(xpath="//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
	WebElement crossConfigureBlock;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[4]/a")
	WebElement addSecondSection;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[5]/div/div[1]/div[2]/a")
	WebElement addSecondBlock;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[6]/a")
	WebElement addThirdSection;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[7]/div/div/div[2]/a")
	WebElement addThirdBlock;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement saveLayoutBtn;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_author][target_id]']")
	WebElement authorField;
	
	@FindBy(xpath="//li[@class='ui-menu-item']/a[@id='ui-id-13']")
	WebElement author;
	
	@FindBy(xpath="//ul[@id='ui-id-84']")
	WebElement autoOptions;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_author][target_id]']")
	WebElement tagField;
	
	@FindBy(xpath="//a[@id='ui-id-16']")
	WebElement tag;
	
	@FindBy(xpath="//input[@name='reusable']")
	WebElement reusableLink;
	
	@FindBy(xpath="//input[@name='info']")
	WebElement adminTitle;
	
	@FindBy(xpath="//textarea[@name='settings[block_form][field_script][0][value]']")
	WebElement scriptText;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[8]/a")
	WebElement addFourthSection;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[9]/div/div[1]/div[2]/a")
	WebElement addFourthBlock;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[9]/a")
	WebElement addFifthSection;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[11]/div/div/div[2]/a")
	WebElement addFifthBlock;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_short_title][0][value]']")
	WebElement shortTitle;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_map][0][value]']")
	WebElement googleMap;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, Body field']")
	WebElement bodyIframe;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_link][0][uri]']")
	WebElement link;
	
	@FindBy(xpath="//input[@name='settings[block_form][field_link][0][uri]']")
	WebElement textForLink;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[12]/a")
	WebElement addSixthSection;
	
	@FindBy(xpath="//div[@id='layout-builder']/div[13]/div/div[1]/div[2]/a")
	WebElement addSixthBlock;
	
	@FindBy(xpath="//input[@name='button_add_modal']")
	WebElement addParagraphBtn;
	
	@FindBy(xpath="//div[@id='ui-id-36']/ul")
	WebElement ParagraphList;
	
	// to initialize the page objects
		public LandingPage() {
			PageFactory.initElements(driver, this); // this refer to current class objects
		}
	
	
	public void redirectiontolandingpage() {
		
		
		TestUtil.mouseHover(content);
		TestUtil.mouseHover(addcontent);
		landingPageContent.click();
		
		
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterInTitleField(String t) {
		Wait.pageLoad(20);
		titlefield.sendKeys(t);
		
		
	}
	
	public String getTitleFieldlabel() {
		return titlefieldlabel.getText();
		
	}
	
	public void enterRevisionLogMessage(String logmsg) {
		revisionlogmsg.sendKeys(logmsg);
		
	}
	
	
	public void enterInBodyField(String bodytext) throws InterruptedException {
		
		Wait.Pause(5000);
		TestUtil.switchFrameByWebElement(bodyFrame);
		bodyfield.sendKeys(bodytext);
		TestUtil.switchBackToWindow();
			
	}
	
	public String clickOnSave() {
		savebtn.click();
		return savestatusmsg.getText();
	}
	
	public void closeStatusMsg() {
	
		cross.click();
	}
	
	public String clickOnLayout() {
		
		
		layout.click();
		addSection.click();
		return layoutStatusMsg.getText();
		
	}
	
	public void getNumberOfSection(String column, String sName) throws InterruptedException {
			
		Wait.Pause(5000);
        List<WebElement> li_All = section.findElements(By.tagName("li"));
        
        for (WebElement element: li_All) {
        	if(element.getText().equalsIgnoreCase(column)) {
        		element.click();
        		break;
        		
        		
        	}
        	
        }
        	
        sectionName.sendKeys(sName);
		addSectionBtn.click();
	}
	
		public void addFirstBlockInLayout() {

			TestUtil.jsExecuterClick(addBlock);
			
	
		}
	
		public void goToCustomBlock(String customBlockType) {
		
		Wait.elementClickable(2000,createCustomBlockLink);

		createCustomBlockLink.click();
		
		try {
			Wait.Pause(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> li_All = inlineBlockList.findElements(By.tagName("li"));
        
        for (WebElement element: li_All) {
        	if(element.getText().equalsIgnoreCase(customBlockType)) {
        		element.click();
        		break;
        		
        		
        	}
        	
        }
		
	}
	
	public void configureBlock() throws InterruptedException {
		
		Wait.visibiltyOfElement(5000, configureBlockTitleField);
	
		configureBlockTitleField.sendKeys("Configure Block title ");
		heroCardTitleField.sendKeys("This is Hero card Title");
		
		heroCardShortTitle.sendKeys("This is Hero card short title");
		Wait.elementClickable(5000,selectImageBtn);
		selectImageBtn.click();
		
		TestUtil.switchFrameByWebElement(entityBrowser);
		TestUtil.jsExecuterClick(image);
		TestUtil.jsExecuterClick(selectBtn);
		
		heroCardSubhead.sendKeys("This is subhead");
		TestUtil.switchFrameByWebElement(summaryFrame);
		Wait.elementClickable(5000,summaryText);
		summaryText.sendKeys("This is Summary text");
		
		TestUtil.switchBackToWindow();
		
		Wait.elementClickable(10000,linkUrl);
		linkUrl.sendKeys(prop.getProperty("googleUrl"));
		
		Wait.Pause(3000);
		linkText.sendKeys("Google");
		
//		Select select = new Select(layoutSelection);
//		select.selectByVisibleText(layout);
		
//		reusableLink.click();
//		adminTitle.sendKeys("This is Admin title");
//		
//		Wait.elementClickable(driver, 5000,addBlockBtn);
//		addBlockBtn.click();
//		Wait.elementClickable(driver, 5000,crossConfigureBlock);
//		TestUtil.jsExecuterClick(crossConfigureBlock);	
		
		
	}
	
	public void reusableAddBlock() {	
		
		reusableLink.click();
		adminTitle.sendKeys("This is Admin title");
		addBlockBtn.click();	
		}
	
	public void secondSection() throws InterruptedException {
		
		Wait.elementClickable(5000,addSecondSection);
		TestUtil.jsExecuterClick(addSecondSection);
		getNumberOfSection("Two column" ,"Test Section 2");
		
		TestUtil.jsExecuterClick(addSecondBlock);
		goToCustomBlock("Content Listing Component");
		
		Wait.visibiltyOfElement(5000, configureBlockTitleField);
		configureBlockTitleField.sendKeys("Configure Block title ");
	
//		authorField.sendKeys("Fe");
//		Thread.sleep(3000);
//		//TestUtil.mousehover(authorField);
//		//Wait.elementClickable(driver, 5000,author);
//		author.sendKeys(Keys.ENTER);
//		
//		tagField.sendKeys("dru");
//		Thread.sleep(5000);
//		TestUtil.mousehover(tagField);
		tag.sendKeys(Keys.ENTER);
		
		reusableAddBlock();
	}
	
		
	
	public void thirdSection() throws InterruptedException {
		
		Wait.elementClickable(5000,addSecondSection);
		TestUtil.jsExecuterClick(addThirdSection);
		getNumberOfSection("Three column" ,"Test Section 3");
		
		TestUtil.jsExecuterClick(addThirdBlock);
		goToCustomBlock("Embed Block");
		
		Wait.visibiltyOfElement(5000, configureBlockTitleField);
		configureBlockTitleField.sendKeys("Configure Block title ");
		scriptText.sendKeys("This is script text");
		
		reusableAddBlock();	
		
		//TestUtil.jsExecuterClick(saveLayoutBtn);
	}
	
	public void fourthSection() throws InterruptedException {
		
		Wait.elementClickable(5000,addFourthSection);
		TestUtil.jsExecuterClick(addFourthSection);
		getNumberOfSection("Four column" ,"Test Section 4");
		
		TestUtil.jsExecuterClick(addFourthBlock);
		goToCustomBlock("Hero Media Block");
		
		Wait.visibiltyOfElement(5000, configureBlockTitleField);
		
		configureBlock();
		reusableAddBlock();

		//TestUtil.jsExecuterClick(saveLayoutBtn);
	}

	public void fifthSection() throws InterruptedException {
		
		Wait.elementClickable(5000,addFifthSection);
		TestUtil.jsExecuterClick(addFifthSection);
		getNumberOfSection("One column" ,"Test Section 5");
		
		TestUtil.jsExecuterClick(addFifthBlock);
		goToCustomBlock("Map Block");
		
		Wait.visibiltyOfElement(5000, configureBlockTitleField);
		configureBlockTitleField.sendKeys("Configure fifth Block title ");
		
		shortTitle.sendKeys("This is short title");
		googleMap.sendKeys(prop.getProperty("googleMapUrl"));
		
		testutil.switchFrameByWebElement(bodyIframe);
		Wait.elementClickable(5000,summaryText);
		summaryText.sendKeys("This is Summary text");
		
		link.sendKeys(prop.getProperty("googleUrl"));
		textForLink.sendKeys("Google");
		
		reusableAddBlock();

		//TestUtil.jsExecuterClick(saveLayoutBtn);
	}

public void sixthSection() throws InterruptedException {
		
		Wait.elementClickable(5000,addFifthSection);
		TestUtil.jsExecuterClick(addSixthSection);
		getNumberOfSection("Two column" ,"Test Section 5");
		
		TestUtil.jsExecuterClick(addSixthBlock);
		goToCustomBlock("Paragraph Content");
		
		Wait.visibiltyOfElement(5000, configureBlockTitleField);
		configureBlockTitleField.sendKeys("Configure sixth Block title ");
		addParagraphBtn.click();
		
		
		List<WebElement> li_All = ParagraphList.findElements(By.tagName("li"));
        
        for (WebElement element: li_All) {
        	if(element.getText().equalsIgnoreCase("Text")) {
        		element.click();
        		break;
        			
        	}
        	
        	testutil.switchFrameByWebElement(bodyIframe);
    		Wait.elementClickable(5000,summaryText);
    		summaryText.sendKeys("This is Summary text");
    		reusableAddBlock();
		
}
	
}
}

