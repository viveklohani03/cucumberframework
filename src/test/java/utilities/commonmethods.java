package utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Scenario;

public class commonmethods {
	WebDriver driver;
	
	public commonmethods(WebDriver driver) {
		this.driver = driver;
	}
	public void selectItem(String item,By element) {
		List<WebElement> options = driver.findElements(element);
		for (WebElement option : options)
		{
			if (option.getText().equals(item))
			{
				option.click(); // click the desired option
				break;
			}
		}
	}

	public void switchWindow() {
		String parentwindow = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> s1 = s.iterator();
		while(s1.hasNext())
		{ String childwindow =s1.next();
		if(!parentwindow.equals(childwindow)) {
			driver.switchTo().window(childwindow);
		}
		}

	}
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}

}
	public String removespecialchar(String s) {
		s = s.replaceAll("[^0-9\\.]", "");
		return s;
	}
}
