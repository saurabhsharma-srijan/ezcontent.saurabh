package ezcontent.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ForgetPasswordPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;

public class ForgetPasswordPageTest extends TestBase {

	ForgetPasswordPage forgetPswdPage;
	LoginPage loginpage;
	TestUtil testUtil;

	public ForgetPasswordPageTest() {
		super(); // to call the super class(BaseClass) constructor to get prop value
	}

	@BeforeClass
	public void setup() {
		TestBase.initialization(); // to launch browser and get url

		loginpage = new LoginPage();
		loginpage.forgetPaswd();       // click on forget password link

		forgetPswdPage = new ForgetPasswordPage(); 
	}

	@Test(priority = 1)
	public void forgetPaswdTitleTest() {
		String title = forgetPswdPage.validateForgetPaswdTitle();
		Assert.assertEquals(title, "Reset your password | EZContent");
		System.out.println("Forget Page title is :" + title);
	}

	@Test(priority = 2)
	public void logoImageTest() {
		boolean flag = forgetPswdPage.validateForgetPaswdLogo();
		Assert.assertTrue(flag);
		System.out.println("Forget page logo is displayed");
	}

	@Test(priority = 3)
	public void forgetPaswdSubmitTest() throws InterruptedException {
		forgetPswdPage.submitForgetPaswd(prop.getProperty("username"));
		testUtil = new TestUtil();
		testUtil.threadWait();
	}

	@Test(priority = 4)
	public void statusMessageTest() {
		String statusMessage = forgetPswdPage.validateStatusMessage();
		Assert.assertEquals(statusMessage, "Further instructions have been sent to your email address.");
		System.out.println("Status message after reset password is :" + statusMessage);
	}

	@AfterClass
	public void closeBrowser() {
		TestBase.browserQuit();
	}
}
