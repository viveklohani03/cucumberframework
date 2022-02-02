package utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	WebDriver driver;
	ConfigManager prop = new ConfigManager();
	public WebDriver init_driver(String browser) throws IOException {
		System.out.println("Browser used to execute tests" +browser);
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.readPropertiesFile().getProperty("driverpathchrome"));
			driver =new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",prop.readPropertiesFile().getProperty("driverpathgecko"));
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(prop.readPropertiesFile().getProperty("implicitwait"))));
		return driver;
		
		
	}
	
	

}
