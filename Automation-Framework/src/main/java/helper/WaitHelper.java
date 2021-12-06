package helper;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	private WebDriver driver;
	Logger Log = LogManager.getLogger(WaitHelper.class.getName());

	// wait helper constrcutor
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		
	}

	// setImplicitWait 
	public void setImplicitWait(long timeout) {
		Log.info(timeout);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		//driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
		//ExtentTestManager.getTest().info("Setted implicit wait for this element");
	}
      
	// setPageLoadTimeout wait
	public void setPageLoadTimeout(long timeout, TimeUnit unit) {
		Log.info(timeout);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit == null ? TimeUnit.SECONDS : unit);
		//WebDriver.Timeouts pageLoadTimeout(long timeout1,java.util.concurrent.TimeUnit unit)
		//ExtentTestManager.getTest().info("Setting wait for page load");
	}

	// set explicit wait
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		Log.debug("");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		// wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		//ExtentTestManager.getTest().info("Setted explicit wait for this element");
		return wait;
	}

	// waitForElementVisible
	public void waitForElementVisible(WebElement locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
		Log.info(locator);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(locator));
		//ExtentTestManager.getTest().info("Setted wait untill the element is visible");
	}

	// wait for one element
	public void waitForElement(WebDriver driver, WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
		Log.info("element found..." + element.getText());
		//ExtentTestManager.getTest().info("Setted wait untill the element is visible");
	}

	// wait for element to be clickable

	public WebElement waitForElement(WebDriver driver, long time, WebElement element) {
		
		//WebDriverWait wait = new WebDriverWait(driver, time);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		//ExtentTestManager.getTest().info("Setted wait untill the element is clickable");
		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
