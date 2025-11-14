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

public class TC_EF_004 extends Base {

	WebDriver driver;
	Properties prop;

	@BeforeTest
	public void setUp() {
		
		driver = openBrowserAndApplication ();
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
	public void VerifyRegisterWithoutFillingFields() {

		//No need to fill the fields
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		//Verify proper messages displayed below each text field
		String actual_proper_mssg_fistnm = "First Name must be between 1 and 32 characters!";
		String actual_proper_mssg_lastnm = "Last Name must be between 1 and 32 characters!";
		String actual_proper_mssg_email = "E-Mail Address does not appear to be valid!";
		String actual_proper_mssg_tele = "Telephone must be between 3 and 32 characters!";
		String actual_proper_mssg_pwd = "Password must be between 4 and 20 characters!";

		//Verify warning message
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(), actual_proper_mssg_fistnm );
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(), actual_proper_mssg_lastnm );
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText(), actual_proper_mssg_email );
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(), actual_proper_mssg_tele );
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText(), actual_proper_mssg_pwd );

	}

}
