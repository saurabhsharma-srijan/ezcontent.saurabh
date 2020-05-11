package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.DashboardPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	DashboardPage dashboardPage;

	public LoginPageTest() {
		super(); // to call the super class(BaseClass) constructor to get prop value
	}

	@BeforeClass
	public void setup() {
		TestBase.initialization();     // launch browser with url
		loginpage = new LoginPage();  // create instance of LoginPage class			
	}

	@Test(priority = 0)
	public void loginPageTitleTest() {
		
	   String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Log in | EZContent");
		System.out.println("Login Page title is :" + title);
	}

	@Test(priority = 1)
	public void logoImageTest() {
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);		
		System.out.println("Login page logo is displayed");
}

	@Test(priority = 2)
	public void loginFunctionalityTest() {
		loginpage.validateLogin();		
		System.out.println("Login to website successfully");
	}
	
	@Test(priority = 3)
	public void DashboardPageTitleTest() {
		dashboardPage = new DashboardPage();
		String titleDash = dashboardPage.validateDashboardTitle();
		Assert.assertEquals(titleDash, "Moderation Dashboard | EZContent");
		System.out.println("Dashboard Page title is :" + titleDash);
	}

/*	@Test(priority = 4)
	public void clickOnForgetLink() throws InterruptedException {

		loginpage.forgetPaswd();
		System.out.println("click on forget password link");	
		}
	*/

	@AfterClass
	public void closeBrowser() {
		TestBase.browserQuit();
	}

}
