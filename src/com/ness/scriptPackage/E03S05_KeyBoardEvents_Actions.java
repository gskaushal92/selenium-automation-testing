package com.ness.scriptPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ness.generic.ByElements;
import com.ness.generic.LoadWebDriver;
import com.ness.generic.Locators;
import com.ness.resource.RegisterPage;

public class E03S05_KeyBoardEvents_Actions {

	public static void main(String[] args) throws InterruptedException {
		String fileName = "file:///D:/CTFS/poc/registerForm.html";

		WebDriver driver = LoadWebDriver.configureChromeBrowser(fileName);

		RegisterPage rp = new RegisterPage();

		String fname = (String) rp.readProp().get("FNAME");

		WebElement element = Locators.getLocator(ByElements.getByName(fname), driver);
		
		Actions action = new Actions(driver);
		
		//action.click().keyDown(Keys.INSERT.ADD.)		.build().perform();
	}

}
