package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import utilities.ExtentTestManager;

public class GenericHelper {
	private static final Logger Log = LogManager.getLogger(GenericHelper.class.getName());

	
	//Reading the vaue from the element
	public String readValueFromElement(WebElement element) {

		if (null == element) {
			Log.info("weblement is null");
			ExtentTestManager.getTest().info("Element value is null");
			return null;
		}

		boolean displayed = false;
		try {
			displayed = isDisplayed(element);
		} catch (Exception e) {
			Log.error(e);
			Reporter.log(e.fillInStackTrace().toString());
			return null;
		}

		if (!displayed) {
			//ExtentTestManager.getTest().info("Element not displayed");
			return null;
		}
		String text = element.getText();
		Log.info("weblement valus is.." + text);
		//ExtentTestManager.getTest().info("Element value is " + text);
		return text;
	}

	
	//Reading the Value from particular attribute
	public String readValueFromInput(WebElement element) {
		if (null == element) {
			//ExtentTestManager.getTest().info("Element value is null");
			return null;
		}
		if (!isDisplayed(element)) {
			//ExtentTestManager.getTest().info("Element value is null");
			return null;
		}
		String value = element.getAttribute("value");
		Log.info("weblement valus is.." + value);
		//ExtentTestManager.getTest().info("Attribute  value is " + value);
		return value;
	}

	
	//Check the display of element
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			Log.info("element is displayed.." + element);
			//ExtentTestManager.getTest().info("Element displayed");
			return true;
		} catch (Exception e) {
			Log.info(e);
			Reporter.log(e.fillInStackTrace().toString());
			//ExtentTestManager.getTest().info("Element not displayed" + e.fillInStackTrace().toString());
			return false;
		}
	}
//Check for element not displayed
	protected boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			Log.info("element is displayed.." + element);
			//ExtentTestManager.getTest().info("Element not displayed");
			return false;
		} catch (Exception e) {
			Log.error(e);
			Reporter.log(e.fillInStackTrace().toString());
			//ExtentTestManager.getTest().info("Element  displayed" + e.fillInStackTrace().toString());
			return true;
		}
	}

	/*
	 * protected String getDisplayText(WebElement element) { if (null == element){
	 * return null; } if (!isDisplayed(element)){ return null; } return
	 * element.getText(); }
	 * 
	 * 
	 * public static synchronized String getElementText( WebElement element) { if
	 * (null == element) { Log.info("weblement is null"); return null; } String
	 * elementText = null; try { elementText = element.getText(); } catch (Exception
	 * ex) { Log.info("Element not found " + ex);
	 * Reporter.log(ex.fillInStackTrace().toString()); } return elementText; }
	 */
}
