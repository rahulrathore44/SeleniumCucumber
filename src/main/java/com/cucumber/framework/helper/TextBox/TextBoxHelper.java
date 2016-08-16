/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 */
package com.cucumber.framework.helper.TextBox;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.framework.helper.Generic.GenericHelper;
import com.cucumber.framework.helper.Logger.LoggerHelper;


/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 *
 */
public class TextBoxHelper extends GenericHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(TextBoxHelper.class);
	
	public TextBoxHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		oLog.debug("TextBoxHelper : " + this.driver.hashCode());
	}
	
	public void sendKeys(By locator,String value) {
		oLog.info("Locator : " + locator + " Value : " + value);
		getElement(locator).sendKeys(value);
	}
	
	public void clear(By locator) {
		oLog.info("Locator : " + locator);
		getElement(locator).clear();
	}
	
	public String getText(By locator) {
		oLog.info("Locator : " + locator);
		return getElement(locator).getText();
	}
	
	public void clearAndSendKeys(By locator,String value) {
		WebElement element =  getElement(locator);
		element.clear();
		element.sendKeys(value);
		oLog.info("Locator : " + locator + " Value : " + value);
	}

}
