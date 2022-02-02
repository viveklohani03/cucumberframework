package stepdefinition;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.addorbuycart;
import utilities.TestContext;

public class addorbuycartstep {
	TestContext testContext;
	addorbuycart cart;

	public addorbuycartstep(TestContext context) {
		testContext = context;
		cart = testContext.getPageObjectManager().getcart();
	}

	@And("Add shirt in cart")
	public void add_shirt() {
		cart.addCart();
		cart.clickcarticon();
		
	}
	@And("Select quantity from shirt dropdown")
	public void select_qty() {
		cart.selectfromdropdown("2");
	}
	@Then("Verify two shirt is added with correct price")
	public void verify_shirt_add() throws InterruptedException {
		cart.verifyamount();
		System.out.println("Shirt added successfully");
	}
	@Then("Click delete link and verify that cart is empty")
	public void verify_deleted_cart() throws IOException {
		cart.verify_delete_item(testContext.getConfigManager().readPropertiesFile().getProperty("cart_empty_message"));
	}
	@Then("Click save-for-later and verify the page")
	public void verify_save_later() {
		cart.verify_save_later();
	}
}