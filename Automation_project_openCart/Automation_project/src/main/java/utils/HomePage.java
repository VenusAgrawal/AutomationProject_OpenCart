package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//constructor
	public HomePage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[normalize-space()='My Account']")
	private WebElement MyAccountDropdownMenu;
	
	@FindBy (linkText = "Register")
	private WebElement registerOption;
	
	public void clickOnMyAccount () {
		MyAccountDropdownMenu.click();
	}
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		/*By clicking register option from the My Account drop down menu
		the user is navigated to the register page so this function will
		return */
		return new RegisterPage(driver);
	}
	
}
