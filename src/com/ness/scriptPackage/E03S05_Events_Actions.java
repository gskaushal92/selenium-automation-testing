package com.ness.scriptPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ness.generic.ByElements;
import com.ness.generic.LoadWebDriver;
import com.ness.generic.Locators;

public class E03S05_Events_Actions {

	public static void main(String[] args) throws InterruptedException {

		String fileName = "http://www.drikpanchang.com/panchang/hindu-panchangs.html";
		WebDriver driver = LoadWebDriver.SetWebDriver("Chrome", fileName);

		// wait / timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				
		WebElement element = Locators.getLocator(ByElements.getByLinkText("Calendars"), driver);
		
		Actions action = new Actions(driver);
		System.out.println("mouseOver on Calendars");
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		System.out.println("move to next page");
		Locators.getLocator(ByElements.getByLinkText("Indian Calendar"), driver).click();

	}

}
