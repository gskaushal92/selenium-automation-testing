package com.ness.scriptPackage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ness.generic.LoadWebDriver;

public class E03S01_MultipleWindow {

	public static void main(String[] args) throws InterruptedException {

		String fileName = "file:///D:/CTFS/poc/registerForm.html";
		WebDriver driver = LoadWebDriver.configureChromeBrowser(fileName);

		// Store and Print the name of the First window on the console
		String window = driver.getWindowHandle();
		System.out.println(window);
		
		// wait / timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// trigger event on keypress
		String ctrlEnter = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.linkText("Gmail")).sendKeys(ctrlEnter);

		// Store and Print the name of all the windows open
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);

		for (String window1 : windows) {
			System.out.println(window1);
			if (!window.equals(window1)) {
				driver.switchTo().window(window1);
			}
		}
	}
}
