package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {
	private WebDriver driver;
	Logger Log = LogManager.getLogger(JavascriptHelper.class.getName());


	public void JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
			}

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Log.info(script);
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Log.info(script);
		return exe.executeScript(script, args);
	}
	
	//click to the element
	public void JSEClick(WebElement Element) {
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", Element);
	}
//scrollToElemet
	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
		//ExtentTestManager.getTest().info("Cicked to the element");
		//ExtentTestManager.getTest().info("Scroll to element");
	}
//scrollToElemetAndClick
	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
	
		//ExtentTestManager.getTest().info("Scrolled to that element and clicked");
	}
//scrollIntoView
	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		Log.info(element);
		//ExtentTestManager.getTest().info("Scrolled to that view");
	}
//scrollIntoViewAndClick
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		Log.info(element);
		//ExtentTestManager.getTest().info("Scrooll to the view and clicked");
	}
//scrollDownVertically
	public void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//ExtentTestManager.getTest().info("scrollDownVertically");
	}
//scrollUpVertically
	public void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		//ExtentTestManager.getTest().info("scrollUpVertically");
	}
//scrollDownByPixel
	public void scrollDownByPixel() {
		executeScript("window.scrollBy(0,1500)");
		//ExtentTestManager.getTest().info("scrollDownByPixel");
	}
//scrollUpByPixel
	public void scrollUpByPixel() {
		executeScript("window.scrollBy(0,-1500)");
		//ExtentTestManager.getTest().info("ZoomInBypercentage");
	}
//ZoomInBypercentage
	public void ZoomInBypercentage() {
		executeScript("document.body.style.zoom='40%'");
		//ExtentTestManager.getTest().info("ZoomInBypercentage");
	}
//ZoomBy100percentage
	public void ZoomBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
		//ExtentTestManager.getTest().info("ZoomBy100percentage");
	}
}
