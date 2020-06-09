package ezcontent.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import ezcontent.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static Select select;
	public static Actions action;
static String currentDir = System.getProperty("user.dir");

public static String TESTDATA_SHEET_PATH = currentDir+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator
+"ezcontent"+File.separator+"qa"+File.separator+"testdata"+File.separator+"EzcontentTestData.xlsx";

static Workbook book;
static Sheet sheet;
static JavascriptExecutor js;
 
	// Switch frame by Index
	public static void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

//Switch frame by name or Id
	public static void switchFrameByNameOrId(String NameOrId) {
		driver.switchTo().frame("String NameOrId");
	}

//Switch frame by WebElement
	public static void switchFrameByWebElement(WebElement iframeElement) {
		driver.switchTo().frame(iframeElement);
	}

//Switch back to the main window from iframe
	public static void switchBackToWindow() {
		driver.switchTo().defaultContent();
	}

// Select ByVisibleText method
	public static void selectByVisibleText(WebElement element, String visibleText) {
		Select oSelect = new Select(element);
		oSelect.selectByVisibleText("visibleText");
	}

// To scroll page or viewport the Webelement
	public static void viewportWebElement(WebElement element) {
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].scrollIntoView()", element);
	}

	//Navigate to any url
	public static void navigateToURL(String url) 
	{
		driver.navigate().to(url);
	}	

	// switch to simple alert
	public static void switchToSimpleAlert() {
	Alert simpleAlert = driver.switchTo().alert();
	 String alertText = simpleAlert.getText();
	 System.out.println("Alert text is " + alertText);
	 simpleAlert.accept();
	 }
	 
	 // Clear any field
     public static void clearField(WebElement element)
     {
         try {
             element.clear();
         } catch (Exception e) {
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
         }
        }
         
     public static void scrollToEndOfPage() {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
 		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
     }
   
     public static String timeStamp() {
    	 return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
     }
        
     //To capture screenshot
     public static void captureScreenshot() {    	 
    	 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 String fileWithPath = currentDir+File.separator+"test-output"+File.separator+timeStamp()+".png"; 
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

     public static void scrollToPixel() {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
 		js.executeScript("window.scrollTo(0, 500)");
     }

   //To tackle click intercepted issue
     public static void scrollToClickElement(WebElement elementName) {
    	 JavascriptExecutor jse = (JavascriptExecutor)driver;
 		jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", elementName);
     }
     
     // Click any element
     public static void onClick(WebElement element)
 	 {
 		element.click();
 	 }
 	
     //select value from drop-down by index
 	 public static void selectByIndex(WebElement element , int index)
 	 {
 		 new Select(element).selectByIndex(index);	
 	 }
 	
 	//select value from drop-down by value
 	 public static void selectByValue(WebElement element , String value)
 	 {
 		new Select(element).selectByValue(value);
 	}
 	
 	//select value from drop-down by visible text
 	 public static void selectByText(WebElement element,String Text) 
 	{
 		new Select(element).selectByVisibleText(Text);
 	}
 	
 	//Mouse Hover
 	 public static void mouseHover(WebElement element)
	 {
		new Actions(driver).moveToElement(element).perform();
	 }
	
 	//mouseClick
	public static void mouseClick(WebElement element)
    {
		new Actions(driver).click(element).perform();
	}
	
	// scroll down by pixel
	public static void scroll(int startdimension, int enddimension) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + String.valueOf(startdimension) + "," + String.valueOf(enddimension) + ")");
 }

	//get excel sheet test data
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum() + "-----" +
		 sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			    System.out.println(data[i][k]);
			}
		}
		return data;
	    }	
	
}
