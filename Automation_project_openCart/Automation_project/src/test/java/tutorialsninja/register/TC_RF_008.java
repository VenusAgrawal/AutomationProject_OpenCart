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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import utils.CommonUtils;
import utils.HomePage;
import utils.RegisterPage;

public class TC_RF_008 extends Base{

	WebDriver driver;
	Properties prop;
	HomePage homePage;
	RegisterPage registerPage;

	@BeforeTest
	public void setUp() {
		
		driver = openBrowserAndApplication ();
		prop = CommonUtils.loadProperties();
		HomePage homePage = new HomePage(driver);
		
		
		homePage.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		RegisterPage registerPage = homePage.selectRegisterOption();
		//driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@Test
	public void VerifyEnteringDifferentPwdANdPwdConfirm() {

		//Fill all the fields
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.emailGenerator());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("Telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("mismatchPwd"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		//Verify the warning message displayed below 'Password confirm'
		String actual_mssg_pwdConfirm = "Password confirmation does not match password!";
		String expected_mssg_pwdConfirm = driver.findElement(By.xpath("//div[@class='text-danger']")).getText(); 
		Assert.assertEquals(actual_mssg_pwdConfirm, expected_mssg_pwdConfirm);

	}
}
