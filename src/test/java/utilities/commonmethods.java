package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Scenario;

public class commonmethods {
	WebDriver driver;
	String parentwindow;

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
		parentwindow = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> s1 = s.iterator();
		while(s1.hasNext())
		{ String childwindow =s1.next();
		if(!parentwindow.equals(childwindow)) {
			driver.switchTo().window(childwindow);
		}
		}
	}
	public void switchtoparentwindow() {
		driver.switchTo().window(parentwindow);
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

	public List<String> readExcelData(String path,String sheetName,int j) throws IOException {
		List<String> data ;
		try {
			FileInputStream fs = new FileInputStream(path);
			@SuppressWarnings("resource")
			Workbook wb = new XSSFWorkbook(fs);
			Sheet sheet1 = wb.getSheet(sheetName);
			int lastrow = sheet1.getPhysicalNumberOfRows();
			data = new ArrayList<String>();
			for(int i=1;i<lastrow;i++) {
				if(sheet1.getRow(i).getCell(j).getCellType()== CellType.STRING) {
					data.add(sheet1.getRow(i).getCell(j).getStringCellValue());
				}else if(sheet1.getRow(i).getCell(j).getCellType()== CellType.NUMERIC) {
					data.add(String.valueOf(sheet1.getRow(i).getCell(j).getNumericCellValue()));
				}
			}
		}catch(FileNotFoundException e) {
			throw e;
		}
		return data;
	}


}
