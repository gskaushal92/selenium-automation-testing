package com.ness.scriptPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ness.generic.ByElements;
import com.ness.generic.LoadWebDriver;
import com.ness.generic.Locators;
import com.ness.resource.RegisterPage;

public class E02S01_Alert {

	public static void main(String[] args) throws InterruptedException {

		String fileName = "file:///D:/CTFS/poc/alertPage.html";

		WebDriver driver = LoadWebDriver.configureChromeBrowser(fileName);

		RegisterPage rp = new RegisterPage();

		// String alertId = (String) rp.readProp().get("ALERTID");
		String btnAlertId = (String) rp.readProp().get("BTNALERT");

		Locators.getLocator(ByElements.getById(btnAlertId), driver).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println("Alert Text: " + alertText);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Alert closed");
		Thread.sleep(2000);
		// driver.close();

		// Case 2 - Show Alert & Use timeout instead of Thread.wait

		Locators.getLocator(ByElements.getById(btnAlertId), driver).click();

		// Create new WebDriver wait

		WebDriverWait wait = new WebDriverWait(driver, 100);

		wait.withTimeout(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();

		System.out.println("Alert Accepted");

		// Close the main window

		// driver.close();

	}

}
