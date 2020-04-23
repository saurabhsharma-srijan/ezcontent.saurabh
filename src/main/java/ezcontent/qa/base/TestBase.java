package ezcontent.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ezcontent.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		
	try {
			prop = new Properties();
	FileInputStream ip = new FileInputStream("C:/Selenium_Folder/Selenium_MavenProject/Ezcontent.Srijan/src/main/java/ezcontent/qa/config/config.properties");
	prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(IOException e)	{
			e.printStackTrace();	
		}		
	}

public static void initialization() {
	
	String browserName = prop.getProperty("browser");
	if (browserName.equals("chrome")) {
		
System.setProperty("webdriver.chrome.driver", "C:/Selenium_Folder/Selenium_MavenProject/Ezcontent.Srijan/driver/chromedriver.exe");

 driver = new ChromeDriver();

	}  else if  (browserName.equals("FF")) {
		
System.setProperty("webdriver.gecko.driver", "C:/Selenium_Folder/Selenium_MavenProject/Ezcontent.Srijan/driver/geckodriver.exe");

 driver = new FirefoxDriver();	
}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	}	

public static void browserQuit() {
	
	driver.quit(); 
	
}
	
}
