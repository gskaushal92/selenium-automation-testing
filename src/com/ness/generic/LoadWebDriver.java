package com.ness.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadWebDriver {

	public static WebDriver configureChromeBrowser(String fileName) throws InterruptedException {
		String exePath = "D:\\CTFS\\selenium\\ChromeDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		WebDriver driver = new ChromeDriver();

		driver.get(fileName);

		System.out.println("Successfully opened");

		Thread.sleep(2000);

		String pageURL = driver.getCurrentUrl();
		String pageTitle = driver.getTitle();

		System.out.println("Page URL: " + pageURL);
		System.out.println("Page Title: " + pageTitle);
		return driver;
	}
}
