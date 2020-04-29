package ezcontent.qa.pages;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;



public class ArticleMapPage extends TestBase{



@FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-system-admin-content']")
WebElement content;

@FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-admin-toolbar-tools-add-content']")
WebElement addContent;

@FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-node-add-article']")
WebElement article;

@FindBy(xpath="//h1[@class='js-quickedit-page-title page-title']")
WebElement createArticle;

@FindBy(className = "fieldset__label")
List <WebElement> subSections;


@FindBy(xpath="//label[@class='form-item__label js-form-required form-required']")
WebElement titleFieldLabel;

@FindBy(xpath="//input[@id='edit-title-0-value']")
WebElement titleField;


@FindBy(xpath="//label[@for='edit-field-short-title-0-value']")
WebElement subTitleFieldLabel;


@FindBy(xpath="//input[@id='edit-field-short-title-0-value']")
WebElement subTitleField;

@FindBy(xpath="//label[@for='edit-field-subhead-0-value']")
WebElement subheadLabel;

@FindBy(xpath="//input[@id='edit-field-subhead-0-value']")
WebElement subheadField;

@FindBy(xpath="//label[@for='edit-field-author-target-id']")
WebElement authorLabel;

public ArticleMapPage() throws IOException 
{

	PageFactory.initElements(driver, this); 
}



public String contentHeading()
{
TestUtil.mouseHover(content);
return content.getText();
}


public String mousehoverOnContent()

{
	TestUtil.mouseHover(content);
	
return addContent.getText();
	}



public boolean mousehoverOnAddContent()

{
	TestUtil.mouseHover(addContent);
//return article.isDisplayed();
	return true;
	}


public String mousehoverOnArticle()

{
	TestUtil.mouseClick(article);
return createArticle.getText();
	}

	
	public List<String> verifySubSections()
	{ 
		List<String> options = new ArrayList<String>();
	  for (WebElement webElement : subSections) // for(type var : array)
	  {
		 
		 options.add(webElement.getText());
		  
	  }
	  
	  return options;
	
	}
       
	public boolean titleFieldLabel()
	{
		return titleFieldLabel.isDisplayed();
	}

	public void enterTitleFieldData() {
		titleField.sendKeys("This is the Title field");
		
	}    
	
	public boolean subTitleFieldLabel()
	{
		return subTitleFieldLabel.isDisplayed();
	}
	
	
	public void enterSubTitleFieldData()
	{
		subTitleField.sendKeys("This is the sub title field");
	}
        

        		
    public boolean  subheadFieldLabel()   		
    {
        
      return subheadLabel.isDisplayed();

    }

    public void enterSubheadFieldData()
    {
    	subheadField.sendKeys("This is the sub head field");
    }
    
    
    public boolean authorLabel()
    {
    	return authorLabel.isDisplayed();
    }
    
}

