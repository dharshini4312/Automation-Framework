package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import utilities.ExtentTestManager;

public class AlertHelper {
	private WebDriver driver;
	Logger log = LogManager.getLogger(AlertHelper.class.getName());

	// Alert constructor
	public AlertHelper(WebDriver driver) {
		this.driver = driver;

	}

	// Switching to alert
	public Alert getAlert() {

		//ExtentTestManager.getTest().info("Switched to alert");
		return driver.switchTo().alert();

	}

	// Accepting the alert
	public void AcceptAlert() {

		getAlert().accept();
		//ExtentTestManager.getTest().info("Accepeted the displayed alert");
	}

	// Dismissing the alert
	public void DismissAlert() {

		getAlert().dismiss();
		//ExtentTestManager.getTest().info("Displayed alert got dismissed");
	}

	// Getting the text from alert
	public String getAlertText() {
		String text = getAlert().getText();
		log.info(text);
		//ExtentTestManager.getTest().info("Text inside the alert :" + text);
		return text;
	}

	// Checking whether alert is present?
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("true");
			//ExtentTestManager.getTest().info("Alert Present");
			return true;
		} catch (NoAlertPresentException e) {
			// Ignore
			log.info("false");
			ExtentTestManager.getTest().info("No Alert Present");
			return false;
		}
	}

  //Accepting alert if present
	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		AcceptAlert();
		log.info("");
	}

	// Dismissing the alert if present
	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		DismissAlert();
		//ExtentTestManager.getTest().info("Displayed alert got dismissed");
		log.info("");
	}

	// Accepting the alert by gving prompt message
	public void AcceptPrompt(String text) {

		if (!isAlertPresent())
			return;

		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
		log.info(text);
		//ExtentTestManager.getTest().info("Accepeted the displayed alert by giving prompt message");
	}

}
