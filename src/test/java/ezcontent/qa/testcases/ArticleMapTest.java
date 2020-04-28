package ezcontent.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleMapPage;
import ezcontent.qa.pages.LoginPage;



public class ArticleMapTest extends TestBase{

	LoginPage loginpage;
	ArticleMapPage articlemapPage;
	
	public ArticleMapTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	@BeforeClass
	public void setup() throws IOException {
		
		
		initialization(); 
		
		
		loginpage = new LoginPage();
		
		
		articlemapPage = new ArticleMapPage();
		
	}
	
	@Test(priority=1)
	public void loginTest()
	{
	
		
		loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=2)
	public void verifyContent()
	{
		
	String contentTitle= articlemapPage.contentHeading();
	Assert.assertEquals(contentTitle, "Content");
	}
	
	
	
	@Test(priority=3)
	public void Content()
	{
		
	String content=articlemapPage.mousehoverOnContent();
	Assert.assertEquals(content, "Add content");
	}
	
	@Test(priority=4)
	
	public void addContent()
	{
		boolean addContent = articlemapPage.mousehoverOnAddContent();
		Assert.assertTrue(addContent);
	}
	
	@Test(priority=5)
	public void article()
	{
		String article = articlemapPage.mousehoverOnArticle();
		Assert.assertEquals(article, "Create Article");
	
		
	}
	
	@Test(priority = 6)
	public void verifySections()
	{
		List<String> mylist = articlemapPage.verifySubSections();
		System.out.println(mylist);	
	}

	
	
	@Test(priority =7)
	
	public void titleFieldLabel()
	{
		boolean title = articlemapPage.titleFieldLabel();
		Assert.assertTrue(title);
	}	
	
	
	
	@Test(priority = 8)
	public void titleFieldData()
	{
		articlemapPage.enterTitleFieldData();	
	}
	
	@Test(priority = 9)
	public void subTitleFieldLabel()
	{
		boolean subtitle = articlemapPage.subTitleFieldLabel();
		Assert.assertTrue(subtitle);
	}
	
	
	@Test(priority=10)
	public void subTitleFieldData()
	{
		articlemapPage.enterSubTitleFieldData();
	}
	
	@Test(priority = 11)
	public void subheadFieldLabel()
	{
		boolean subhead = articlemapPage.subheadFieldLabel();
		Assert.assertTrue(subhead);
	}
	
	
	@Test(priority=12)
	public void subheadFieldData()
	{
		articlemapPage.enterSubheadFieldData();
	}
	
	
	@Test(priority =13)
	public void authorLabel()
	{
		boolean author = articlemapPage.authorLabel();
		Assert.assertTrue(author);
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		browserQuit();
	}
	


}




 