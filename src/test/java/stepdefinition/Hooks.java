package stepdefinition;

import java.io.IOException;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.TestContext;


public class Hooks{
	TestContext testContext;
	public Hooks(TestContext context) throws IOException {
		testContext = context;
	}

	@Before(order = 0)
	public void launchBrowser() throws IOException{
       testContext.getPageObjectManager().gethomepage().openurl(testContext.getConfigManager().readPropertiesFile().getProperty("url"));

	}

	@After(order = 0)
	public void quitBrowser() {
		testContext.getPageObjectManager().gethomepage().closeurl();;
	}


}




