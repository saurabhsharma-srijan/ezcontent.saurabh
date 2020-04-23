package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	TestUtil testUtil;


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
	public void loginFunctionalityTest() {

		loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login to website successfully");
	}

	@Test(priority = 4)
	public void clickOnForgetLink() throws InterruptedException {

		loginpage.forgetPaswd();
		System.out.println("click on forget password link");
		testUtil = new TestUtil();
		testUtil.threadWait();	
		}

	@AfterClass
	public void closeBrowser() {
		TestBase.browserQuit();
	}

}
