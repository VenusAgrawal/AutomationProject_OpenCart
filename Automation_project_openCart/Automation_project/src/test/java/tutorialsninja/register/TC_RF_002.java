package tutorialsninja.register;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import utils.CommonUtils;

public class TC_RF_002 extends Base {

	WebDriver driver;
	Properties prop;

	@BeforeMethod
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
	public void VerifyRegisterWithConfirmationEmail () {

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		String emailAddress = CommonUtils.emailGenerator();

		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("Telephone"));
		
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));

		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		//this is all dummy code, as the application doesn't send any confirmation email

		String email = emailAddress;
		String passCode = "abcd1234";
		String link = null;

		System.out.println("wait for 10 secs.");



		//Gmail Info
		String host = "imap.gmail.com";
		String port = "993";
		String username = email;
		String password = passCode;
		String expectedmssg = "TutorialsNinja- Welcome to your account";



	}


}
