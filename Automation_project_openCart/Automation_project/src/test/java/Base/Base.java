package Base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;

public class Base {

	WebDriver driver;
	//public Properties prop;
	
	public WebDriver openBrowserAndApplication () {

		Properties prop = CommonUtils.loadProperties();
		String browserName = prop.getProperty("browserName");
		
		//String browserName = "chrome";

		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();

		}

		//global wait for all the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("appURL"));
		
		return driver;

	}
}
