package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import utilities.ExtentTestManager;

public class VerificationHelper {
	private static final  Logger Log = LogManager.getLogger(VerificationHelper.class.getName());
	
	//Synchronized method is used to lock an object for any shared resource. When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the thread completes its task.
	//Returns boolean value for element display
	public static synchronized boolean verifyElementPresent( WebElement element) {
		boolean isDispalyed = false;
		try {
			 isDispalyed= element.isDisplayed();
			 Log.info(element.getText()+" is dispalyed");
		}
		catch(Exception ex) {
			Log.error("Element not found " + ex);
		}
		//ExtentTestManager.getTest().info("Element present");
		return isDispalyed;
	}
	
	//Returns boolean value for element not display
	public static synchronized boolean verifyElementNotPresent( WebElement element) {
		boolean isDispalyed = false;
		try {
			 element.isDisplayed();
			 Log.info(element.getText()+" is dispalyed");
		}
		catch(Exception ex) {
			Log.error("Element not found " + ex);
			isDispalyed = true;
		}
		
		return isDispalyed;
	}
	
	
	//Validating actual and expected texts
	public static synchronized boolean verifyTextEquals( WebElement element,String expectedText) {
		boolean flag = false;
		try {
			String actualText=element.getText();
			if(actualText.equals(expectedText)) {
				Log.info("actualText is :"+actualText+" expected text is: "+expectedText);
				ExtentTestManager.getTest().info("Actual text matches with expected text");
				return flag=true;
			}
			else {
				Log.error("actualText is :"+actualText+" expected text is: "+expectedText);
				ExtentTestManager.getTest().info("Actual text not matches with expected text");
				return flag;
			}
		}
		catch(Exception ex) {
			Log.error("actualText is :"+element.getText()+" expected text is: "+expectedText);
			Log.info("text not matching" + ex);
			return flag;
		}
	}
}
