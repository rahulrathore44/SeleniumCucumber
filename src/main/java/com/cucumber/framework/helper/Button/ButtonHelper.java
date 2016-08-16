/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.cucumber.framework.helper.Button;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.interfaces.IwebComponent;



/**
 * @author rsr
 *
 * Aug 6, 2016
 */
public class ButtonHelper implements IwebComponent {
	
	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(ButtonHelper.class);
	
	public ButtonHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("Button Helper : " + this.driver.hashCode());
	}
	
	public void click(By locator) {
		click(driver.findElement(locator));
		oLog.info(locator);
	}
	
	public void click(WebElement element){
		element.click();
		oLog.info(element);
	}
}
