package ezcontent.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.LoginPage;

import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;


	public LoginPageTest() {
		super(); // to call the super class(BaseClass) constructor to get prop value
	}

	@BeforeClass
	public void setup() {
		TestBase.initialization();     // launch browser with url
		loginpage = new LoginPage();  // create instance of LoginPage class			
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		
	   String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Log in | EZContent");
		System.out.println("Login Page title is :" + title);
	}

	@Test(priority = 2)
	public void logoImageTest() {
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
		System.out.println("Login page logo is displayed");
}

	@Test(priority = 3)
	public void loginFunctionalityTest() throws IOException {

		loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login to website successfully");
		
	}

	@Test(priority = 4)
	public void clickOnForgetLink() throws InterruptedException, IOException {

		loginpage.forgetPaswd();
		System.out.println("click on forget password link");	
		Wait.Pause(5000);
	
		}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
	    if (testResult.getStatus() == ITestResult.FAILURE) { 
	        TestUtil.captureScreenshot();
	    } 
	}

	@AfterClass
	public void closeBrowser() {
		TestBase.browserQuit();
	}

}
