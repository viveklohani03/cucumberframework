package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import utilities.commonmethods;

public class homepage {
	WebDriver driver;

	public homepage(WebDriver driver) {
		this.driver = driver;
	}

	By amazonlogo = By.id("nav-logo-sprites");
	By hemburgericon = By.id("nav-hamburger-menu");
	By menulist = By.tagName("li");


	public void openurl(String url) 
	{ driver.get(url); }

	public void closeurl() { driver.quit();

	}


	public void clickHemburgerIcon() {
		driver.findElement(hemburgericon).click();
	}

	public void selectMenuItem(String item) {
		commonmethods method = new commonmethods(driver);
		method.selectItem(item, menulist);
	}

	public void verifyhomepage() {
		boolean logoverify = driver.findElement(amazonlogo).isDisplayed();
		Assert.assertTrue(logoverify);	
		
		}
}