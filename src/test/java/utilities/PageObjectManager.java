package utilities;

import org.openqa.selenium.WebDriver;

import pageobjects.addorbuycart;
import pageobjects.homepage;
import pageobjects.menshirts;

public class PageObjectManager {
	WebDriver driver;
	addorbuycart cart;
	homepage home;
	menshirts shirt;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
    
	public homepage gethomepage() {
		return (home == null) ? home = new homepage(driver) : home;
	}
	
	public addorbuycart getcart() {
		return (cart == null) ? cart = new addorbuycart(driver) : cart;
	}
	public menshirts getshirt() {
		return (shirt == null) ? shirt = new menshirts(driver) : shirt;
	}
}
