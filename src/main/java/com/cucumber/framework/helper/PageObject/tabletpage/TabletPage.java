/**
 * rsr 
 *
 *Aug 17, 2016
 */
package com.cucumber.framework.helper.PageObject.tabletpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;

/**
 * @author rsr
 *
 * Aug 17, 2016
 */
public class TabletPage extends HomePage {

	private WebDriver driver;
	
	public TabletPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH,using="//h1[text()='Tablets']")
	public WebElement title;

}
