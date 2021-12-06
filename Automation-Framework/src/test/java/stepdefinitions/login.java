package stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonReader;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.BaseClass;
import resources.ExcelReader;
import testDataType.Logindata;
import testDataType.RegisterData;
import utilities.ExtentTestManager;

public class login extends BaseClass {
	public Properties prop;
	WebDriver driver = BaseClass.driver;
	LandingPage landingPage;
	LoginPage loginPage;

	ExcelReader reader = new ExcelReader(System.getProperty("user.dir") + "\\Test-data\\TestData.xlsx");

	JsonReader jsonReader=new JsonReader();

	@And("^Navigate to Login page$")
	public void navigate_to_login_page() throws InterruptedException, IOException {
		ConfigFileReader configFileReader = new ConfigFileReader();

		driver.get(configFileReader.getApplicationUrl());
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		 ExtentTestManager.getTest().info("User clicks on my account dropdown");
		landingPage.loginOption().click();
		ExtentTestManager.getTest().info("User clicks on login option from");
		// dropdown");

	}

	@When("^User enters usernamea and password in their respective fields$")
	public void user_enters_usernamea_and_password_in_their_respective_fields() {
		loginPage = new LoginPage(driver);
		String Username="dharshini";
		//String email = reader.getCellData("Login", "Username", 2);
		//String password = reader.getCellData("Login", "Password", 2);
		 Logindata login =jsonReader.getLoginByName(Username);
		loginPage.emailAddressField().sendKeys(login.Email);
		ExtentTestManager.getTest().info("User Enters username");
		loginPage.passwordField().sendKeys(login.Password);
		 ExtentTestManager.getTest().info("User enters valid password");

		 
		
	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() throws InterruptedException {
		Thread.sleep(2000);
		loginPage.loginButton().click();
		 ExtentTestManager.getTest().info("User clicks login button after entering credentials");

	}

	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {

		Assert.assertTrue(loginPage.EditYourAccountInfo().isDisplayed());
		ExtentTestManager.getTest().info("User verifies the account page is displayed");

	}

}
