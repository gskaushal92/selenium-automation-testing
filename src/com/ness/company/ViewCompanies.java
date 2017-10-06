/**
 * 
 */
package com.ness.company;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ness.generic.ByElements;
import com.ness.generic.Locators;

/**
 * @author P7111387
 *
 */
public class ViewCompanies {

	/**
	 * @param args
	 */
	public static void getCompanies(WebDriver driver, Properties prop){

		String thead_xpath = (String) prop.get("COMPANYTABLEHEADERXPATH");
		String tbody_xpath = (String) prop.get("COMPANYTABLEBODYXPATH");		

		List<WebElement> thead =Locators.getListLocators(ByElements.getByXPath(thead_xpath), driver);
		List<WebElement> tbody =Locators.getListLocators(ByElements.getByXPath(tbody_xpath), driver);		
		
		int hdrCount = thead.size();
		int rwCount =tbody.size();
		
		//print header text of each cell
		for(int iHeader=1 ; iHeader<=hdrCount;iHeader++){
			System.out.println("Header "+iHeader+": " + Locators.getLocator(ByElements.getByXPath(thead_xpath +"["+iHeader+"]"), driver).getText());
			
			//data.add("Header "+iHeader+": " + driver.findElement(By.xpath(headerXpath +"["+iHeader+"]")).getText());
		}
		
		for(int iRow=1 ; iRow<=rwCount;iRow++){
			for(int iCell=1;iCell<=hdrCount;iCell++){
				System.out.println("Row "+iRow+" Column "+iCell +": "+  Locators.getLocator(ByElements.getByXPath(tbody_xpath +"["+iRow+"]" +"/td["+iCell+"]"), driver).getText());			
			}
		}
		
		
	}

}
