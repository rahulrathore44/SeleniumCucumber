/**
 * @author rahul.rathore
 *	
 *	29-Jul-2016
 */
package com.cucumber.framework.helper.PageObject.BugzilaPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cucumber.framework.helper.PageObject.PageBase;



/**
 * @author rahul.rathore
 *	
 *	29-Jul-2016
 *
 */
public class HomePage extends PageBase {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log.info(driver);
	}
	
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="File a Bug")
	private WebElement NewBug;
	
	@FindBy(how=How.ID,using="find")
	public WebElement QuickSearch;
	
	public LoginPage clickNewBug() {
		log.info("");
		NewBug.click();
		return new LoginPage(driver);
	}
	
	public By get(String name) throws SecurityException, NoSuchFieldException {
		return getElemetLocator(this, "NewBug");
	}

}
