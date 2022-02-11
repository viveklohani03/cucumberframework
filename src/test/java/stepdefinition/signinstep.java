package stepdefinition;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.signin;
import utilities.TestContext;
import utilities.commonmethods;

public class signinstep {

	TestContext testContext;
	signin sign;

	public signinstep(TestContext context) throws IOException {
		testContext = context;
		sign = testContext.getPageObjectManager().getsignin();
	}

	@Then("Enter {string} and click Continue")
	public void enterusername(String username) {
		sign.username(username);
	}
	@Then("Enter {string} and click signin")
	public void enterpwd(String password) {
		sign.password(password);
	}
	@And("Verify error on signin page")
	public void verifyerror() {
		sign.verifyerrorsignin();
	}
	@Then("Enter username from {string},{string} and {int}")
	public void enterusernamefromexcel(String path,String sheetname,int colnum) throws IOException {
	   sign.readdatafromexcel(path, sheetname, colnum);
	}

}
