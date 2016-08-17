/**
 * rsr 
 *
 *Aug 17, 2016
 */
package com.cucumber.framework.helper.PageObject.laptoppage;

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
public class LaptopPage extends HomePage {

	private WebDriver driver;
	
	public LaptopPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/** WebElements **/
	
	@FindBy(how=How.XPATH,using="//h1[text()='Laptops']")
	public WebElement title;

}
