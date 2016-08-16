/**
 * @author rahul.rathore
 *	
 *	29-Jul-2016
 */
package com.cucumber.framework.helper.PageObject.BugzilaPage;

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
public class LoginPage extends PageBase {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log.info(driver);
	}
	
	@FindBy(how=How.ID,using="Bugzilla_login")
	public WebElement LoginTxtBx;
	
	@FindBy(how=How.ID,using="Bugzilla_password")
	public WebElement PassTxtBx;
	
	@FindBy(how=How.ID,using="Bugzilla_restrictlogin")
	public WebElement RestricChk;
	
	@FindBy(how=How.ID,using="log_in")
	private WebElement LoginBtn;
	
	public DetailPage clickLogin(final String username,final String password,boolean restrict) {
		log.info("username : " + username + " password : " + password);
		LoginTxtBx.sendKeys(username);
		PassTxtBx.sendKeys(password);
		if (restrict)
			RestricChk.click();
		LoginBtn.click();
		return new DetailPage(driver);
	}
}
