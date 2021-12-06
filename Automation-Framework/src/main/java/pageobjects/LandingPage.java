package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement drpdwn_myAccountDropdown;

	@FindBy(linkText = "Login")
	private WebElement btn_loginOption;

	public WebElement myAccountDropdown() {
		return drpdwn_myAccountDropdown;

	}

	public WebElement loginOption() {
		return btn_loginOption;

	}

}
