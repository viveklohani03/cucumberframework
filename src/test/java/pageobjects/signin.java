package pageobjects;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import utilities.commonmethods;

public class signin {
	WebDriver driver;

	public signin(WebDriver driver) {
		this.driver = driver;
	}
	By username = By.name("email");
	By password = By.name("password");
	By changelink = By.id("ap_change_login_claim");
	By sigincontinue = By.id("continue");
	By siginbutton = By.id("signInSubmit");
	By usernameerror = By.id("auth-error-message-box");
	

	public void username(String usrname) {
		driver.findElement(username).sendKeys(usrname);	
		driver.findElement(sigincontinue).click();
	}
	public void password(String pwd) {
		Assert.assertTrue(driver.findElement(changelink).isDisplayed());
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(siginbutton).click();
	}
	public void verifyerrorsignin() {
		try {
			Assert.assertTrue(driver.findElement(usernameerror).isDisplayed());
		}catch(NoSuchElementException ne) {
			
		}
	}
	public void readdatafromexcel(String path,String sheetname,int i) throws IOException {
		commonmethods method = new commonmethods(driver);
		List<String> usrname = method.readExcelData(path, sheetname,i);
		for (int j=0;j<=usrname.size()-2;j++) {
		driver.findElement(username).sendKeys(usrname.get(j));
		driver.findElement(sigincontinue).click();
		driver.findElement(username).clear();
	}
	}
}
