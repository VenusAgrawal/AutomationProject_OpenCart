package tutorialsninja.register;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import utils.CommonUtils;

public class TC_RF_010 extends Base{

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
	public void VerifyRegisterByInvalidEmailAddress () throws IOException, InterruptedException {
	
		//Fill all the fields
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("invalidEmail"));
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("Telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(5000);
		
		System.out.println(driver.findElement(By.id("input-email")).getDomProperty("validatioMessage"));
		Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validatioMessage"), driver.findElement(By.xpath("//input[@id='input-email']")).getDomProperty("validatioMessage"));
		
		
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		/*
		//actual image
		BufferedImage actualBImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc_actual.png"));
		BufferedImage expectedBTmg = ImageIO.read(new File(System.getProperty("user.dir")+ "\\Screenshots\\sc_expected.png"));
		
		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(expectedBTmg, actualBImg);
		
		Assert.assertFalse(imgDifference.hasDiff());*/
	}

}
