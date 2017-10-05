package com.ness.generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

	public static WebElement getLocator(By byType, WebDriver driver) {
		return driver.findElement(byType);
	}
	
	public static List<WebElement> getListLocators(By byType, WebDriver driver) {
		return driver.findElements(byType);
	}

}
