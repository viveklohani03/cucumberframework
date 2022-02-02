package stepdefinition;

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
	@Then("Select shirtsize")
	public void select_shirt() throws InterruptedException {
		menshirt.verifyshirtpage();
		menshirt.shirtsize("32");
		menshirt.selectshirt(1);
	}
}
