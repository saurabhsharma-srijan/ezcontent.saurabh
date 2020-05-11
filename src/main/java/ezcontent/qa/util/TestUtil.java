package ezcontent.qa.util;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ezcontent.qa.base.TestBase;

public class TestUtil extends TestBase {

//	public static long PageLoadTimeout = 20;
//	public static long ImplicitWait = 10;

	// Switch by Index
	public static void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

//Switch by frame name or Id
	public static void switchFrameByNameOrId(String NameOrId) {
		driver.switchTo().frame("String NameOrId");
	}

//Switch by frame WebElement
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

// To scroll down the page by pixel
	public static void scrollDownByPixel(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,pixel)");
	}

}
