package ezcontent.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ezcontent.qa.base.TestBase;

public class TestUtil extends TestBase {

//	public static long PageLoadTimeout = 20;
//	public static long ImplicitWait = 10;
static String currentDirec= System.getProperty("user.dir");
 
	
	public void navigateToURL(String URL) {
		driver.navigate().to(URL);
	}	
	
	
	// Switch by Index

	public void switchFrameByIndex() {
		driver.switchTo().frame("indexValue");
	}

//Switch by frame name
	public void switchFrameByName() {
		driver.switchTo().frame("frameName");
	}

	// Switch by frame ID
	public void switchFrameById() {
		driver.switchTo().frame("frameId");
	}

//Switch by frame WebElement
	public void switchFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

//Switch back to the main window from iframe
	public void switchBackToFrame() {
		driver.switchTo().defaultContent();
	}

	// switch to simple alert
	public void switchToSimpleAlert() {
	Alert simpleAlert = driver.switchTo().alert();
	 String alertText = simpleAlert.getText();
	 System.out.println("Alert text is " + alertText);
	 simpleAlert.accept();
	 }
	 
     public void clearField(WebElement element) {
         try {
             element.clear();
         } catch (Exception e) {
             System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
         }
     }
     
     // For mouse hovering
     public static void mousehover(WebElement element) {
    	 
    	 Actions act = new Actions(driver);
    	 act.moveToElement(element).build().perform();
    	 
    	 
     }
     
   
     public static String timeStamp() {
    	 return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());


     }
     
     //To capture screenshot
     public static void captureScreenshot() {
    	 
    	 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 String fileWithPath = currentDirec+File.separator+"test-output"+File.separator+timeStamp()+".png"; 
    	 File DestFile=new File(fileWithPath); 
    	 try {
			FileUtils.copyFile(srcFile,DestFile );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	 
    	 
    	 
     }
     
     public static void jsExecuterClick(WebElement element) {
    	 JavascriptExecutor jse = (JavascriptExecutor)driver;
 		jse.executeScript("arguments[0].click();", element); 
    	 
     }

}

