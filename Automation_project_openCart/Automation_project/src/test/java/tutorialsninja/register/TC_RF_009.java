package tutorialsninja.register;

import java.time.Duration;
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

public class TC_RF_009 extends Base {

	WebDriver driver;
	Properties prop;

	@BeforeTest
	public void setUp() {
		
		driver = openBrowserAndApplication ();
		prop = CommonUtils.loadProperties();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@Test
	public void VerifyRegisterByExistingEmailAddress () {

		//Fill all the fields
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("existingEmail"));
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("Telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		//Verify warning message on the Register page 
		String actual_mssg_warning = "Warning: E-Mail Address is already registered!";
		String expected_mssg_warning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

		Assert.assertTrue(actual_mssg_warning.contains(expected_mssg_warning));

	}

}
