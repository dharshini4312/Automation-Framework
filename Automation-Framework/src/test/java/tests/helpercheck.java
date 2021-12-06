package tests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import helper.AlertHelper;
import helper.DropDownHelper;
import helper.GenericHelper;
import resources.BaseClass;

public class helpercheck extends BaseClass { 
		
	WebDriver driver;
	DropDownHelper dropDownHelper= new DropDownHelper(driver);
	GenericHelper genericHelper=new GenericHelper();
	AlertHelper alertHelper=new AlertHelper(driver);
	
	@Test
	public void OpenApplication() throws IOException, InterruptedException {
		
		    driver=initializeDriver();
		    driver.get("http://omayo.blogspot.com/");
			driver.manage().window().maximize();
			
			
		
			////****Dropdown helper checking
			WebElement dropdown=driver.findElement(By.id("drop1"));
			dropDownHelper.SelectUsingVisibleText(dropdown,"doc 3");
			/*
			////****Generic helper checking
			WebElement element=driver.findElement(By.linkText("Page One"));
			 String value=genericHelper.readValueFromElement(element);
			 System.out.println(value);
		
			
			//******Alert helper checking
			driver.findElement(By.id("alert1")).click();
			alertHelper.AcceptAlert();
			
			*/
			
			Thread.sleep(5000);
			 
	}
}

