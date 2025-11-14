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

public class TC_RF_003 extends Base {
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
	public void VerifyRegisterWithAllFields() {

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.emailGenerator());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("Telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		//Verify Page heading
		String actual_mssg = "Your Account Has Been Created!";
		String expected_mssg = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actual_mssg, expected_mssg);

		//Verify Logout is displayed in the right column
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

		//Verify All Proper messages are displayed
		String actual_propermssg1 = "Congratulations! Your new account has been successfully created!";
		String actual_propermssg2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actual_propermssg3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actual_propermssg4 = "contact us";

		String exp_propermssg = driver.findElement(By.xpath("//div[@id = 'content']")).getText();

		Assert.assertTrue(exp_propermssg.contains(actual_propermssg1));
		Assert.assertTrue(exp_propermssg.contains(actual_propermssg2));
		Assert.assertTrue(exp_propermssg.contains(actual_propermssg3));
		Assert.assertTrue(exp_propermssg.contains(actual_propermssg4));

		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}

}
