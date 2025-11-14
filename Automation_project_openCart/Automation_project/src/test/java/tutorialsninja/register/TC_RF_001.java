package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import utils.AccountPage;
import utils.AccountSuccessPage;
import utils.CommonUtils;
import utils.HomePage;
import utils.RegisterPage;

public class TC_RF_001 extends Base {

	WebDriver driver;
	Properties prop;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;

	@BeforeMethod
	public void setUp() {

		driver = openBrowserAndApplication ();
		prop = CommonUtils.loadProperties();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		registerPage = homePage.selectRegisterOption();
		//driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

	@Test
	public void VerifyRegisterWithMandatoryFields () {
		
		registerPage.enterFirstName(prop.getProperty("firstName"));
		//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Ven");
		
		registerPage.enterLastName(prop.getProperty("lastName"));
		//driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		//driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Agr");
		
		registerPage.enterEmail(CommonUtils.emailGenerator());
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.emailGenerator());
		
		registerPage.enterTelephoneField(prop.getProperty("Telephone"));
		//driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("Telephone"));
		//driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("123456789");
		
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
		
		registerPage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234");

		registerPage.selectPrivacyPolicy();
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		accountSuccessPage = registerPage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actual_mssg = accountSuccessPage.getPageHeading();
		//String actual_mssg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();

		System.out.println(actual_mssg);

		//Verify that the Logout is displayed on right side column of the Account success page.
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		//Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

		//Verify that the heading message is displayed after registration on account success page.
		String expected_mssg = "Your Account Has Been Created!";
		Assert.assertEquals(actual_mssg, expected_mssg);

		//Verify proper messages are displayed after registration.
		String expected_proper_mssg1 = "Congratulations! Your new account has been successfully created!";
		String expected_proper_mssg2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expected_proper_mssg3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expected_proper_mssg4 = "contact us";

		String actual_proper_mssg = accountSuccessPage.getPageContent();
		//String actual_proper_mssg = driver.findElement(By.id("content")).getText();

		Assert.assertTrue(actual_proper_mssg.contains(expected_proper_mssg1));
		Assert.assertTrue(actual_proper_mssg.contains(expected_proper_mssg2));
		Assert.assertTrue(actual_proper_mssg.contains(expected_proper_mssg3));
		Assert.assertTrue(actual_proper_mssg.contains(expected_proper_mssg4));
		
		accountPage = accountSuccessPage.clickOnContinueButton();
		//driver.findElement(By.xpath("//a[text() = 'Continue']")).click();

		Assert.assertTrue(accountPage.UserNavigatedToAccountPaged());
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
/*
	public String generateNewEmail()
	{
		
		Date date = new Date();

		//convert date to string
		String dateString = date.toString();

		//remove spaces from string
		String NoSpaceDateString = dateString.replaceAll(" ", "");
		//String NoSpaceDateString = dateString.replaceAll("//s", ""); can also be used //s is for space

		//remove :
		String NoSpaceColondateString = NoSpaceDateString.replaceAll(":", "");
		//String NoSpaceColondateString = NoSpaceDateString.replaceAll("//:", ""); alternate method

		//append with @gmail.com to generate different emails by timestamp
		String emailWithTimeStamp = NoSpaceColondateString + "@gmail.com";
		return (emailWithTimeStamp);
		

		// above code will do the same by using method chaining in next line code

		//return new Date().toString().replaceAll(" ", "").replaceAll(":", "") + "@gmail.com" ;


	} */

}
