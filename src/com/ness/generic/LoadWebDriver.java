package com.ness.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoadWebDriver {
	// setting  webdriver
	public   static WebDriver  SetWebDriver(String driverType, String fileName)  throws InterruptedException{
		switch(driverType){    
		case "Chrome":    
			//set system property to use chrome driver
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium\\ChromeDriver\\chromedriver.exe");			
			WebDriver chrmDriver= new ChromeDriver();
			LoadDriver(chrmDriver, fileName);
			return chrmDriver;		    
		default:   
			WebDriver frfxdriver= new FirefoxDriver();
			LoadDriver(frfxdriver, fileName);
			return frfxdriver;
		}
	}
	
	// Loading driver and printing current url and title
	public static void LoadDriver (WebDriver driver,String fileName) throws InterruptedException{
		driver.get(fileName);

		System.out.println("Successfully opened");

		Thread.sleep(2000);

		String pageURL = driver.getCurrentUrl();
		String pageTitle = driver.getTitle();

		System.out.println("Page URL: " + pageURL);
		System.out.println("Page Title: " + pageTitle);
	}
	
}
