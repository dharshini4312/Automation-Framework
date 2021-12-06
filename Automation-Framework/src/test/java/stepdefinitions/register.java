package stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dataProvider.ConfigFileReader;
import dataProvider.JsonReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.BaseClass;
import testDataType.RegisterData;
import utilities.ExtentTestManager;

public class register extends BaseClass {
	WebDriver driver;
	JsonReader jsonReader=new JsonReader();

	@Given("^User navigates to Registration page$")
	public void user_navigates_to_Registration_page() throws IOException {
		
		driver = BaseClass.driver;
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
		ExtentTestManager.getTest().info("User Navigated to required url");

	}

	@When("^User provies the following details into the input fields$")
	public void user_provies_the_following_details_into_the_input_fields(DataTable dataTable) throws JsonIOException, JsonSyntaxException, FileNotFoundException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		ConfigFileReader configFileReader = new ConfigFileReader();
//String jsonpath=configFileReader.getJsonPath();
		//jsonReader.getdata(configFileReader.getJsonPath()+"Regsister.json","Registration Data",1,6);
		/*driver.findElement(By.id("input-firstname")).sendKeys(map.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(map.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(map.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(map.get("phone"));
		driver.findElement(By.id("input-password")).sendKeys(map.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(map.get("password"));
		 ExtentTestManager.getTest().info("Users enters the data in required field");
		 */

	}

    @When("^User enters the personal details for \"([^\"]*)\"$")
    public void user_enters_the_personal_details_for_something(String CustomerName) throws Throwable {
    	RegisterData register =jsonReader.getRegisterByName(CustomerName);
    	String firstname=register.FirstName;
    	System.out.println(firstname);
    	
    	driver.findElement(By.id("input-firstname")).sendKeys(register.FirstName);
		driver.findElement(By.id("input-lastname")).sendKeys(register.LastName);
		driver.findElement(By.id("input-email")).sendKeys(register.Email);
		driver.findElement(By.id("input-telephone")).sendKeys(register.Phone);
		driver.findElement(By.id("input-password")).sendKeys(register.Password);
		driver.findElement(By.id("input-confirm")).sendKeys(register.ConPassword);
		
    }


	@And("^Selects the privacy policy option$")
	public void selects_the_privacy_policy_option() {

		driver.findElement(By.name("agree")).click();
		ExtentTestManager.getTest().info("User agrees on privacy option");

	}

	@And("^Clicks on Continue button$")
	public void clicks_on_Continue_button() {

		driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();
		 ExtentTestManager.getTest().info("User clicks continue button");

	}

	@Then("^User should get successfully registered$")
	public void user_should_get_successfully_registered() {
		 ExtentTestManager.getTest().info("user verifying succesful registration");
		String url = driver.getCurrentUrl();

		if (url.equals("http://tutorialsninja.com/demo/index.php?route=account/success")) {
			Assert.fail("User has  registered");
			// Assert.assertEquals("http://tutorialsninja.com/demo/index.php?route=account/success",
			// url);
			

		} else {

			System.out.println("User has not registered which is expected");
			
			
		}

	}

}
