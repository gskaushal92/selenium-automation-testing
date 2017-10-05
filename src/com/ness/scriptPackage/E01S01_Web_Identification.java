package com.ness.scriptPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ness.generic.ByElements;
import com.ness.generic.LoadWebDriver;
import com.ness.generic.Locators;
import com.ness.resource.RegisterPage;

public class E01S01_Web_Identification {
	
	public static void main(String[] args) throws InterruptedException {
		
		String fileName = "file:///D:/CTFS/poc/registerForm.html";

		WebDriver driver = LoadWebDriver.configureChromeBrowser(fileName);

		RegisterPage rp = new RegisterPage();

		String fname = (String) rp.readProp().get("FNAME");

		// form fill up
		Locators.getLocator(ByElements.getByName(fname), driver).sendKeys("ROHIT");
		// driver.findElement(ById.id("fname")).sendKeys("ROHIT");
		Locators.getLocator(ByElements.getByXPath(".//*[@id='lname']"), driver).sendKeys("Singh");
		driver.findElement(By.className("emailClass")).sendKeys("test@test.com");
		driver.findElement(By.name("pwd")).sendKeys("passw0rd");
		driver.findElement(By.cssSelector("input[value='male']")).click();
		// handle check box
		List<WebElement> listItems = driver.findElements(By.name("dept"));
		System.out.println("No of checkboxes: " + listItems.size());
		for (WebElement item : listItems) {
			item.click();
			String itemValue = item.getAttribute("value");
			if (itemValue.equals("hr")) {
				item.click();
			}
		}
		// Select options
		Select selectOpts = new Select(driver.findElement(ById.id("course")));
		selectOpts.selectByValue("MCA");
		
		// click & navigate on href
		//String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		//driver.findElement(By.linkText("Gmail")).sendKeys(selectLinkOpeninNewTab);
		driver.get("https://accounts.google.com/signin");
		//driver.findElement(By.linkText("Gmail")).click(); // links are case sensitive
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    
		Thread.sleep(5000);
		//driver.close();
	    //driver.switchTo().window(tabs2.get(1));
		//driver.navigate().back();
		//driver.switchTo().parentFrame();
		
		/*driver.findElement(By.partialLinkText("Hot")).click(); // links are case sensitive
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(2000);*/

		driver.findElement(By.tagName("button")).submit();
		Thread.sleep(2000);
		driver.navigate().back();
		//driver.switchTo().parentFrame();

		// uncheck radio button
		List<WebElement> genderOpts = driver.findElements(By.name("gender"));
		if (genderOpts.get(0).isSelected()) {
			genderOpts.get(1).click();
		} else {
			genderOpts.get(0).click();
		}

		// change select option - on page load
		Select selectOpt = new Select(driver.findElement(ById.name("course")));
		selectOpt.selectByValue("MBA");

		// Find all elements & reset
		List<WebElement> allFormChildElements = driver.findElements(By.xpath("//form[@name='demoForm']//input"));
		System.out.println("No of input tags: " + allFormChildElements.size());

		for (WebElement item : allFormChildElements) {

			if (item.getTagName().equals("input")) {
				switch (item.getAttribute("type")) {
				case "text":
				case "email":
					System.out.println("Text box Name: " + item.getAttribute("name"));
					item.clear();
					break;
				case "checkbox":
					System.out.println("Check box Name: " + item.getAttribute("value"));
					if (item.isSelected())
						item.click();
					break;
				case "radio":
					System.out.println("Radio Name: " + item.getAttribute("value"));
					break;
				}
			}
		}

		// list all available links
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		for (WebElement link : allLinks) {
			System.out.println("link Name: " + link.getText() + "- " + link.getAttribute("href"));
		}

		selectOpt.selectByIndex(0);
		// driver.quit();
	}

}
