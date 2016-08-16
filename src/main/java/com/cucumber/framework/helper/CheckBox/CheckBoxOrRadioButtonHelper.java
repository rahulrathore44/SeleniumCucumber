/**
 * @author rahul.rathore
 *	
 *	06-Aug-2016
 */
package com.cucumber.framework.helper.CheckBox;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.interfaces.IwebComponent;


/**
 * @author rahul.rathore
 *
 *         06-Aug-2016
 *
 */
public class CheckBoxOrRadioButtonHelper implements IwebComponent {
	
	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(CheckBoxOrRadioButtonHelper.class);

	public CheckBoxOrRadioButtonHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("CheckBoxOrRadioButtonHelper : " + this.driver.hashCode());
	}
	
	public void selectCheckBox(By locator) {
		oLog.info(locator);
		selectCheckBox(driver.findElement(locator));
	}
	
	public void unSelectCheckBox(By locator) {
		oLog.info(locator);
		unSelectCheckBox(driver.findElement(locator));
	}
	
	public boolean isIselected(By locator) {
		oLog.info(locator);
		return isIselected(driver.findElement(locator));
	}
	
	public boolean isIselected(WebElement element) {
		boolean flag = element.isSelected();
		oLog.info(flag);
		return flag;
	}
	
	public void selectCheckBox(WebElement element) {
		if(!isIselected(element))
			element.click();
		oLog.info(element);
	}
	
	public void unSelectCheckBox(WebElement element) {
		if(isIselected(element))
			element.click();
		oLog.info(element);
	}
}
