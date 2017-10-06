package com.ness.company;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ness.generic.ByElements;
import com.ness.generic.LoadWebDriver;
import com.ness.generic.Locators;
import com.ness.resource.Load_Data;

public class Add_Company {

	public static void main(String[] args) throws InterruptedException {
		
		Load_Data data = new Load_Data();
		Properties prop = new Properties();
		String fileName = "http://localhost:8000";
		// Load Web Driver
		WebDriver driver = LoadWebDriver.SetWebDriver("Chrome", fileName);		
		
		// read all the properties from property file
		prop = data.readProp("company.properties");
		// get add company button id
		String addbtn = (String) prop.get("ADD_CLICK_ID"); 
		// Add Company Button click
		Locators.getLocator(ByElements.getById(addbtn), driver).click();
		// get all the properties from property file
		
		Thread.sleep(2000);
		String duns_id = (String) prop.get("DUNS_ID");
		String companyName_id = (String) prop.get("COMPANYNAME_ID");
		String email_id = (String) prop.get("EMAIL_ID");
		String phone_id = (String) prop.get("PHONE_ID");
		String subsidiary_id = (String) prop.get("SUBSIDIARY_ID");
		String it_id = (String) prop.get("ITCATEGORY_ID");
		//String nonIt_id = (String) prop.get("NONITCATEGORY_ID");
		String address_id = (String) prop.get("ADDRESS_ID");
		String country_id = (String) prop.get("COUNTRY_ID");
		String zip_id = (String) prop.get("ZIP_ID");
		String btnSubmit_id = (String) prop.get("SUBMIT_BTN_ID");
		
		
		// locate all the elements
		WebElement duns =Locators.getLocator(ByElements.getById(duns_id), driver);
		WebElement companyName =Locators.getLocator(ByElements.getById(companyName_id), driver);
		WebElement email =Locators.getLocator(ByElements.getById(email_id), driver);
		WebElement phone =Locators.getLocator(ByElements.getById(phone_id), driver);
		WebElement subsidiary =Locators.getLocator(ByElements.getById(subsidiary_id), driver);
		WebElement it =Locators.getLocator(ByElements.getById(it_id), driver);
		//WebElement nonIt =Locators.getLocator(ByElements.getById(nonIt_id), driver);
		WebElement address =Locators.getLocator(ByElements.getById(address_id), driver);
		WebElement country =Locators.getLocator(ByElements.getById(country_id), driver);
		WebElement zip =Locators.getLocator(ByElements.getById(zip_id), driver);
		WebElement btnSubmit =Locators.getLocator(ByElements.getById(btnSubmit_id), driver);
		
		// add data in all the fields
		if(duns!= null){
			duns.sendKeys("1234");
		}
		if(companyName!= null){
			companyName.sendKeys("Test");
		}
		if(email!= null){
			email.sendKeys("test@test.com");
		}
		if(phone!= null){
			phone.sendKeys("1234567890");
		}
		if(subsidiary!= null){
			subsidiary.click();
		}
		if(it!= null){
			it.click();
		}
		if(address!= null){
			address.sendKeys("Test");
		}
		if(country!= null){
			country.sendKeys("India");
		}
		if(zip!= null){
			zip.sendKeys("143505");
		}
		// Add company on submit click
		if(btnSubmit!=null){
			btnSubmit.click();
		}
		
		
		Thread.sleep(2000);
		
		ViewCompanies.getCompanies(driver, prop);
		
		driver.close();
	}
}
