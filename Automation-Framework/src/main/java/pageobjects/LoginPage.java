package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement txtBox_emailAddressField;

	@FindBy(id = "input-password")
	private WebElement txtBox_passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement btn_loginButton;

	@FindBy(linkText = "Edit your account information")
	private WebElement txt_EditYourAccountInfo;

	public WebElement emailAddressField() {
		return txtBox_emailAddressField;

	}

	public WebElement passwordField() {
		return txtBox_passwordField;
	}

	public WebElement loginButton() {
		return btn_loginButton;
	}

	public WebElement EditYourAccountInfo() {
		return txt_EditYourAccountInfo;
	}

}
