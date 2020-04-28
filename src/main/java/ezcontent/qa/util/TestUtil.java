package ezcontent.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ezcontent.qa.base.TestBase;

public class TestUtil extends TestBase {

//	public static long PageLoadTimeout = 20;
//	public static long ImplicitWait = 10;

	
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
	public void switchFrameByWebElement() {
		driver.switchTo().frame("iframeElement");
	}

//Switch back to the main window from iframe
	public void switchBackToWindow() {
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
         }}
     
     //Mouse Hover
         public void mouseHover(WebElement element1){
         Actions action = new Actions(driver);
         action.moveToElement(element1).build().perform();
        	 
         }
     }
         
         
     



