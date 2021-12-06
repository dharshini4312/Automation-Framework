package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.BaseClass;


public class LoginTest extends BaseClass {
WebDriver driver;

Logger log;




@BeforeMethod
public void OpenApplication() throws IOException {
	log = LogManager.getLogger(LoginTest.class.getName());
	   driver= initializeDriver();
	   ConfigFileReader configFileReader=new ConfigFileReader();
		
		driver.get(configFileReader.getApplicationUrl());
		 log.debug("Navigated to application URL");
		 
		 //extentTest.info("Navigated to application URL");
}
	@Test(dataProvider="getlogindata")
	public void login(String email,String password,String expectedResult) throws IOException,InterruptedException  {
	
		
		log.debug("Test Execution Started");
		 
		 LandingPage landingPage= new LandingPage(driver);
		 landingPage.myAccountDropdown().click();
		 log.debug("Clicked on My Account dropdown");
		 landingPage.loginOption().click();		 
		 log.debug("Clicked on login option");
		 
		 LoginPage loginPage= new LoginPage(driver);
		 loginPage.emailAddressField().sendKeys(email);
		 loginPage.passwordField().sendKeys(password);
		 loginPage.loginButton().click();
		 Thread.sleep(5000);
			//extentTest.log(Status.PASS,"Test Passed");
		 //Assert.assertTrue(loginPage.EditYourAccountInfo().isDisplayed());
		
		 //System.out.println(loginPage.EditYourAccountInfo().isDisplayed());
		 String actualResult;
		 try {
			 loginPage.EditYourAccountInfo().isDisplayed();
			 actualResult="Successful"; 
			 log.info("Clicked on login option");
		 }
		  	catch(Exception e)
		 {
		  		actualResult="Failure";
		  		log.error("Error: We are in wrong page");
		 }
		Assert.assertEquals(actualResult, expectedResult);
		 Assert.assertTrue(false);
}
	@AfterMethod
	public void closure() {
		driver.close();
	}


@DataProvider
public Object[][] getlogindata() {
	Object[][] data= {{"dharshiniselvaraj23@gmail.com","Selvaraj23!","SuccessfulL"}}; 
	return data;
	
}
}