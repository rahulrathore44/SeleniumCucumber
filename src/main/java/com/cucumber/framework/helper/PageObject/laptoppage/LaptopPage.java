/**
 * rsr 
 *
 *Aug 17, 2016
 */
package com.cucumber.framework.helper.PageObject.laptoppage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.settings.ObjectRepo;

/**
 * @author rsr
 *
 * Aug 17, 2016
 */
public class LaptopPage extends HomePage {

	private WebDriver driver;
	
	public LaptopPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/** WebElements **/
	
	@FindBy(how=How.XPATH,using="//h1[text()='Laptops']")
	public WebElement title;
	
	
	
	/** Internal Method **/
	
	String getBrandXpath(String name){
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}
	
	String getPriceXpath(String price){
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + price + "')]";
	}
	
	String getItemXapth(String itemName,String shortDesp){
		return "//div[normalize-space()='" + shortDesp + "']/parent::*/parent::*//a[text()='" + itemName + "']";
	}
	
	public void selectItem(String itemName,String shortDesp) {
		driver.findElement(By.xpath(getItemXapth(itemName, shortDesp))).click();
		waitForElement(reserve, ObjectRepo.reader.getExplicitWait());
		reserve.click();
	}

}
