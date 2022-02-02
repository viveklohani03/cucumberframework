package pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.commonmethods;

public class addorbuycart{
	WebDriver driver;
	commonmethods method;
	String qty;
	int amt;
	public addorbuycart(WebDriver driver) {
		this.driver =driver;
	}
	By addCart = By.id("add-to-cart-button");
	By buyNow = By.id("buy-now-button");
	By gotocart = By.linkText("/gp/cart/view.html?ref_=sw_gtc");
	By carticon = By.id("nav-cart-count-container");
	By qtyicon = By.id("quantity");
	By sizedropdown = By.className("a-dropdown-container");
	By sizename = By.id("inline-twister-expander-header-size_name");
	By selectsize = By.xpath(".//div[@id='inline-twister-expander-content-size_name'/ul/li");
	By amount = By.xpath(".//span[@id='sc-subtotal-amount-activecart']/span");
	By delete = By.xpath(".//input[contains(@name,'submit.delete')]");
	By cart_header_error= By.xpath(".//h1[@class='a-spacing-mini a-spacing-top-base']");
	By save_for_later = By.xpath(".//input[contains(@name'submit.save-for-later')]");
	By saved_item = By.id("sc-saved-cart-list-caption-text");
	By select_size_cart = By.xpath(".//input[@name='dropdown_selected_size_name']/option");
	
	public void addCart() {
		method = new commonmethods(driver);
		method.switchWindow();
		Assert.assertTrue(driver.findElement(addCart).isDisplayed());
		driver.findElement(addCart).click();
	}
	public void buyNow() {
		method.switchWindow();
		Assert.assertTrue(driver.findElement(buyNow).isDisplayed());
		driver.findElement(buyNow).click();
	}

	public void clickgotocart() {
		driver.findElement(gotocart).click();
		String charamt = driver.findElement(amount).getText();
		method.removespecialchar(charamt);
		amt = (int)Double.parseDouble(charamt);
	}

	public void clickcarticon() {
		driver.findElement(carticon).click();
		String charamt = driver.findElement(amount).getText();
		charamt = method.removespecialchar(charamt);
		amt = (int)Double.parseDouble(charamt);
	}

	public void selectfromdropdown(String qty) {
		this.qty = qty;
		Select dropdown = new Select(driver.findElement(qtyicon));
		dropdown.selectByValue(qty);
	}

	public void sizedropdown(String size) {
		if(driver.findElement(sizedropdown).isDisplayed()) {
			Select dropdown = new Select(driver.findElement(sizedropdown));
	
			dropdown.selectByValue(size);
		} else if (driver.findElement(sizename).isDisplayed()) {
			List<WebElement> list = driver.findElements(selectsize);
			list.get(2).click();
		} 
	}
	
	public void verifyamount() throws InterruptedException {
		driver.navigate().refresh();
		String actupdatedcharamt= driver.findElement(amount).getText();
		actupdatedcharamt= method.removespecialchar(actupdatedcharamt);
		int actupdatedamt = (int)Double.parseDouble(actupdatedcharamt);
		int expupdatedamt = Integer.valueOf(qty)*amt;
		Assert.assertEquals(expupdatedamt, actupdatedamt);
	}
	public void verify_delete_item(String exptext) {
		driver.findElement(delete).click();
		String acttext= driver.findElement(cart_header_error).getText();
		Assert.assertEquals(exptext,acttext );
		
	}
	public void verify_save_later() {
		driver.findElement(save_for_later).click();
		Assert.assertTrue(driver.findElement(saved_item).isDisplayed());
		
	}
	
}