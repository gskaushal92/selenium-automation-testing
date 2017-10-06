package com.ness.scriptPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ness.generic.ByElements;
import com.ness.generic.LoadWebDriver;
import com.ness.generic.Locators;
import com.ness.resource.RegisterPage;

public class E02S02_TableElement {

	public static void main(String[] args) throws InterruptedException {
		// Initialize page
		String fileName = "file:///D:/CTFS/poc/tablePage.html";
		// configure browser load WebDriver with html page
		WebDriver driver = LoadWebDriver.SetWebDriver("Chrome", fileName);
		// read property file
		RegisterPage rp = new RegisterPage();
		// Assign property key value
		 String tableXpath = (String) rp.readProp().get("TABLEXPATH");

		List<WebElement> tableElements = Locators
				.getListLocators(ByElements.getByXPath(tableXpath), driver);

		System.out.println("No. of Rows in the WebTable: " + tableElements.size());
		// Now we will Iterate the Table and print the Values
		int RowIndex = 1;
		for (WebElement rowElement : tableElements) {
			// Get Table headers & print
			List<WebElement> ColumnHeaders = rowElement.findElements(ByElements.getByXPath("th"));
			int tabHeader = 1;
			for (WebElement colElement : ColumnHeaders) {
				System.out.println("Row " + RowIndex + " Column " + tabHeader + " Header : " + colElement.getText());
				tabHeader = tabHeader + 1;
			}
			// get Table data
			List<WebElement> TotalColumnCount = rowElement.findElements(ByElements.getByXPath("td"));
			int ColumnIndex = 1;
			for (WebElement colElement : TotalColumnCount) {
				System.out.println("Row " + RowIndex + " Column " + ColumnIndex + " Data : " + colElement.getText());
				ColumnIndex = ColumnIndex + 1;
			}
			RowIndex = RowIndex + 1;
		}
	}

}
