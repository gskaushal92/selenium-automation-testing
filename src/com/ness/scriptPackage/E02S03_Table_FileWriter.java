package com.ness.scriptPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ness.generic.ByElements;
import com.ness.generic.LoadWebDriver;
import com.ness.generic.Locators;
import com.ness.resource.RegisterPage;

public class E02S03_Table_FileWriter {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Initialize page
		String fileName = "file:///D:/CTFS/poc/tablePage.html";
		// configure browser load WebDriver with html page
		WebDriver driver = LoadWebDriver.configureChromeBrowser(fileName);

		// Create File In D: Driver.
		String TestFile = "D:\\temp.txt";
		File FC = new File(TestFile);// Created object of java File class.
		FC.createNewFile();// Create file.

		// Writing In to file.
		// Create Object of java FileWriter and BufferedWriter class.
		FileWriter FW = new FileWriter(TestFile);
		BufferedWriter BW = new BufferedWriter(FW);
		// read property file
		RegisterPage rp = new RegisterPage();
		// Assign property key value
		String tableXpath = (String) rp.readProp().get("TABLEXPATH");

		List<WebElement> tableElements = Locators.getListLocators(ByElements.getByXPath(tableXpath), driver);

		System.out.println("No. of Rows in the WebTable: " + tableElements.size());
		BW.write("No. of Rows in the WebTable: " + tableElements.size());
		BW.newLine();
		// Now we will Iterate the Table and print the Values
		int RowIndex = 1;
		for (WebElement rowElement : tableElements) {
			// Get Table headers & print
			List<WebElement> ColumnHeaders = rowElement.findElements(ByElements.getByXPath("th"));
			int tabHeader = 1;
			for (WebElement colElement : ColumnHeaders) {
				System.out.println("Row " + RowIndex + " Column " + tabHeader + " Header : " + colElement.getText());
				BW.write("Row " + RowIndex + " Column " + tabHeader + " Header : " + colElement.getText());
				BW.newLine();
				tabHeader = tabHeader + 1;
			}
			// get Table data
			List<WebElement> TotalColumnCount = rowElement.findElements(ByElements.getByXPath("td"));
			int ColumnIndex = 1;
			for (WebElement colElement : TotalColumnCount) {
				System.out.println("Row " + RowIndex + " Column " + ColumnIndex + " Data : " + colElement.getText());
				BW.write("Row " + RowIndex + " Column " + ColumnIndex + " Data : " + colElement.getText());
				BW.newLine();
				ColumnIndex = ColumnIndex + 1;
			}
			RowIndex = RowIndex + 1;
		}
		BW.close();
	}

}
