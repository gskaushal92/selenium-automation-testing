package com.ness.generic;

import org.openqa.selenium.By;

public class ByElements {

	public static By getById(String elementName) {
		return By.id(elementName);
	}

	public static By getByName(String elementName) {
		return By.name(elementName);
	}

	public static By getByClassName(String elementName) {
		return By.className(elementName);
	}

	public static By getByCssSelector(String elementName) {
		return By.cssSelector(elementName);
	}

	public static By getByLinkText(String elementName) {
		return By.linkText(elementName);
	}

	public static By getByPartialLinkText(String elementName) {
		return By.partialLinkText(elementName);
	}

	public static By getByTagName(String elementName) {
		return By.tagName(elementName);
	}

	public static By getByXPath(String elementName) {
		return By.xpath(elementName);
	}

}
