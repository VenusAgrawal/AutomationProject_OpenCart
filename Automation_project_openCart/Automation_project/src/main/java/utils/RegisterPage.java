package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	//constructor
	public RegisterPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy (id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy (id = "input-email")
	private WebElement emailField;
	
	@FindBy (id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy (id = "input-password")
	private WebElement passwordField;
	
	@FindBy (id = "input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy (name = "agree")
	private WebElement privacyPolicyField;
	
	@FindBy (xpath = "//input[@value='Continue']")
	private WebElement continuButton;
	
	public void enterFirstName (String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName (String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	public void enterTelephoneField(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	public void enterPassword(String passworText) {
		passwordField.sendKeys(passworText);
	}
	public void enterConfirmPassword(String passworConfirmText) {
		passwordConfirmField.sendKeys(passworConfirmText);
	}
	public void selectPrivacyPolicy() {
		privacyPolicyField.click();
	}
	public AccountSuccessPage clickOnContinueButton() {
		continuButton.click();
		return new AccountSuccessPage(driver);
	}
	

}
