package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.commonmethods;

public class menshirts{
	WebDriver driver;
    public menshirts (WebDriver driver) {
    	this.driver = driver;
    }
    By shirtsizesection = By.xpath("//ul[@class='a-unordered-list a-nostyle a-horizontal a-spacing-medium']/li");
    By selectshirt = By.xpath(".//div[@class='s-main-slot s-result-list s-search-results sg-row']/div");
	
    public void verifyshirtpage() {
    	String url = driver.getCurrentUrl();
    	Assert.assertTrue(url.contains("shirts"));
    }
    public void shirtsize(String size) {
    	commonmethods method = new commonmethods(driver);
		method.selectItem(size, shirtsizesection);
	}
    
    public void selectshirt(int i) {
    	driver.findElements(selectshirt).get(i).click();
    }
}


