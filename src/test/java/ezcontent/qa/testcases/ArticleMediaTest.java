package ezcontent.qa.testcases;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleMedia;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;

public class ArticleMediaTest extends TestBase{
	LoginPage loginpage = new LoginPage();
	TestUtil util = new TestUtil();
	
	ArticleMediaTest() {
		super(); // to call the super class(BaseClass) constructor to get prop value
	}
	
	@BeforeClass
	public void setup() {
		TestBase.browserLaunch();
	}
	@Test
	public void login() {
		LoginPage log = new LoginPage();
		log.validateLogin(prop.getProperty("username"), prop.getProperty("password"));


	}

}
