package stepdefinitions;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import helper.ScreenshotHelper;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import resources.BaseClass;
import utilities.ExtentTestManager;



public class HooksClass extends BaseClass {
	WebDriver driver;

	ScreenshotHelper screenshotHelper = new ScreenshotHelper(driver);

	@Before
	public void browserSetup(Scenario scenario) throws IOException {
		driver = initializeDriver();
		System.out.println("Driver Initiated");
		String name=scenario.getName();
		System.out.println("Scenario : **"+ name + "** Started executing");
		ExtentTestManager.startTest(name);
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		driver = BaseClass.driver;
		java.io.File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		scenario.attach(fileContent, "image/png", "screenshot");
		
	}

	@SuppressWarnings("unlikely-arg-type")
	@After
	public void TearDown(Scenario scenario) throws IOException {
		driver = BaseClass.driver;
		driver.close();
		System.out.println("Browser closed");
		String name=scenario.getName();
		System.out.println("Scenario : **"+ name + "** Stopped executing");
		 io.cucumber.java.Status status=scenario.getStatus();
		 System.out.println(status);
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		if (status.equals("FAILED")) {
			
				System.out.println("ENTERRED");
				String screenshotPath = screenshotHelper.takeScreenshotForFailureReport(name, BaseClass.driver);
				ExtentTestManager.getTest().log(Status.FAIL, "Screenshot: ",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				System.out.println(screenshotPath);
			
		}
	}
			
}
