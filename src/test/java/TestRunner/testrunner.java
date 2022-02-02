package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/java/Features",glue={"stepdefinition"},tags="@FirstTest",monochrome= true,plugin= {"pretty","json:target/cucumber-report/cucumber.json",
        "html:target/cucumber-report/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class testrunner {
	

}
