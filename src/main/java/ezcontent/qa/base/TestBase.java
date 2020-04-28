package ezcontent.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	static String currentDir = System.getProperty("user.dir");
	String configFilePath = currentDir+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator
			+"ezcontent"+File.separator+"qa"+File.separator+"config"+File.separator+"config.properties";
	
	static String chromeDriverPath = currentDir+File.separator+"driver"+File.separator+"chromedriver.exe" ;
	static String fireFoxDriverPath = currentDir+File.separator+"driver"+File.separator+"geckodriver.exe" ;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(configFilePath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void browserLaunch() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {


//			WebDriverManager.chromedriver().setup();
//
//			
//			driver = new ChromeDriver();
//
//			ChromeOptions chromeOptions = new ChromeOptions();
//			//chromeOptions.addArguments("headless");
//			driver = new ChromeDriver(chromeOptions);

//			WebDriverManager.chromedriver().setup(); 
//			 driver = new ChromeDriver();


			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.addArguments("headless");
			//driver = new ChromeDriver(chromeOptions);

		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

	public static void browserQuit() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
