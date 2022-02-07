package stepdefinition;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.menshirts;
import utilities.TestContext;

public class menshirtsstep {
	TestContext testContext;
	menshirts menshirt;
	
	public menshirtsstep(TestContext context) {
		testContext = context;
		menshirt = testContext.getPageObjectManager().getshirt();
	}
	@Then("Select shirt having quantity more than two")
	public void select_shirt() throws InterruptedException, IOException {
		menshirt.shirtsize("32");
		menshirt.selectshirtwithasin(testContext.getConfigManager().readPropertiesFile().getProperty("shirt_more_2"));
	}
	@Then("Select shirt with only quantity one")
	public void select_shirt_one() throws InterruptedException, IOException {
		menshirt.shirtsize("32");
		menshirt.selectshirtwithasin(testContext.getConfigManager().readPropertiesFile().getProperty("shirt_only_1"));
	}
	@And("Verify user navigated to shirt page")
	public void verify_shirt_page() {
		menshirt.verifyshirtpage();
	}
}
