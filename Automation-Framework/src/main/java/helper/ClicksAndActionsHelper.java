package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClicksAndActionsHelper {
	private WebDriver driver;
	Logger Log = LogManager.getLogger(WaitHelper.class.getName());

	// Click helper constrcutor
	public ClicksAndActionsHelper(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//Webdriver click
	public void clickOnElement(WebElement element) {
		element.click();
		//ExtentTestManager.getTest().info("Clicked on the element" +element);
		
	}
	
	
	//click to the element
		public void JSEClick(WebElement Element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Element);
		}
	//Moving to element
public void moveToElement(WebElement element) {
	Actions action = new Actions(driver);

	action.moveToElement(element).perform();
	//ExtentTestManager.getTest().info("Moved to the element" +element);
}
	
//hovering to element and selecting from options
public void clickUsingActionClass(WebElement hoveringelelement,WebElement clickingelement) {
		Actions action = new Actions(driver);

		action.moveToElement(hoveringelelement).perform();
		action.moveToElement(clickingelement).click().build().perform();
		//ExtentTestManager.getTest().info("Moved to the element" +hoveringelelement+ "and clicked" +clickingelement);
	}
	
	
	public void rightClick(WebElement element) {
	
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		//ExtentTestManager.getTest().info("Right clicked on the element" +element);
		
		
	}
	public void  doubleClick(WebElement element) {
	
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
		//ExtentTestManager.getTest().info("Double clicked on the element" +element);
	}
	
	//drag and drop
	public void DragAndDrop(WebElement DragElement, WebElement DropElement) {
	Actions actions = new Actions(driver);
	actions.dragAndDrop(DragElement, DropElement);
	//ExtentTestManager.getTest().info("Dragged and droped");
	}
}


