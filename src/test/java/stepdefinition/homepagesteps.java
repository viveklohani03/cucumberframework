
package stepdefinition;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.homepage;
import utilities.TestContext;

public class homepagesteps {
	TestContext testContext;
	homepage homepage;
	
	public homepagesteps(TestContext context) throws IOException {
		testContext = context;
		homepage = testContext.getPageObjectManager().gethomepage();
	}

	@Given("Verify user is on amazon.in home page")
	public void launch_browser() throws IOException {
		homepage.verifyhomepage();
	}
	@When("Click hemburgericon and select menuItem")
	public void launch_amazon_in() throws InterruptedException {
		homepage.clickHemburgerIcon();
		homepage.selectMenuItem("Men's Fashion");
		homepage.selectMenuItem("Shirts");

}
}