package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleQuotePage;
import ezcontent.qa.pages.DashboardPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.pages.SmartArticlePage;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class SmartArticlePageTest extends TestBase {

	private static final Logger LOG = Logger.getLogger(SmartArticlePageTest.class);
	LoginPage loginPage;
	DashboardPage dashboardPage;
	SmartArticlePage smartArticlePage;
	ArticleQuotePage articleQuotePage;
	TestUtil testUtil;
	String sheetName = "SmartArticle";

	public SmartArticlePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
	
	try { TestBase.browserLaunch();
	loginPage = new LoginPage();
	Wait.implicitWait(3000);
	loginPage.validateLogin();
	smartArticlePage = new SmartArticlePage();
	articleQuotePage = new ArticleQuotePage();
	testUtil = new TestUtil();
	dashboardPage = new DashboardPage();
	dashboardPage.clickSmartArticleLink();
		
	} catch (Exception e) {
		Assert.fail(e.getMessage());
		e.printStackTrace();
		LOG.info(e);
	}		
	}
		
	@DataProvider
	public Object[][] getExcelTestData() {
		Object data[][]  = TestUtil.getTestData(sheetName);
		return data;
	}
		
	@Test(priority = 0, dataProvider= "getExcelTestData")
	public void createSmartArticle(String title, String autoGeneratedcontent, String articlebody, String summarytext) {
try { 
 smartArticlePage.createSmartArticle(title, autoGeneratedcontent, articlebody, summarytext);
 articleQuotePage.deleteArticle(); 
}
	catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
			LOG.info(e);
		}
	}

	@AfterMethod
	public void closeBrowser() {
		TestBase.browserQuit();
	}
}
