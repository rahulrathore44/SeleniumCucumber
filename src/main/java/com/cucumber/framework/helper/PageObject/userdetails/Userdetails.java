/**
 * @author rahul.rathore
 *	
 *	21-Aug-2016
 */
package com.cucumber.framework.helper.PageObject.userdetails;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cucumber.framework.helper.DropDown.DropDownHelper;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.PageObject.homepage.HomePage;

/**
 * @author rahul.rathore
 *	
 *	21-Aug-2016
 *
 */
public class Userdetails extends HomePage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(Userdetails.class);
	
	public Userdetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/** Region Webelement **/
	
	@FindBy(how=How.ID,using="reservationDestination")
	public WebElement reservationDestination;
	
	@FindBy(how=How.ID,using="reservationAirline")
	public WebElement reservationAirline;
	
	@FindBy(how=How.ID,using="reservationFlightNumber")
	public WebElement flightNumber;
	
	@FindBy(how=How.ID,using="reservationFlightDateTextbox")
	public WebElement flightDate;
	
	@FindBy(how=How.NAME,using="reservationFlightTime")
	public WebElement flightTime;
	
	@FindBy(how=How.ID,using="reservationTerminal")
	public WebElement reservationTerminal;
	
	@FindBy(how=How.NAME,using="reservationFirstName")
	public WebElement firstName;
	
	@FindBy(how=How.NAME,using="reservationLastName")
	public WebElement lastName;
	
	@FindBy(how=How.ID,using="reservationEmailAddress")
	public WebElement emil;
	
	@FindBy(how=How.ID,using="reservationMobilePhone")
	public WebElement phone;
	
	@FindBy(how=How.ID,using="submitReservationButton")
	public WebElement submitReservationButton;
	
	@FindBy(how=How.ID,using="reserveTermsConditions")
	public WebElement reserveTermsConditions;
	
	
	/** Region Public **/
	
	public void journeyDetails(String dest,String airlines,String fNo,String ftime,String fDate,String terminal){
		reservationDestination.sendKeys(dest);
		reservationAirline.sendKeys(airlines);
		flightNumber.sendKeys(fNo);
		flightDate.sendKeys(fDate);
		new DropDownHelper(driver).SelectUsingVisibleValue(flightTime, ftime);
		new DropDownHelper(driver).SelectUsingVisibleValue(reservationTerminal, terminal);
		log.info("");
	}
	
	
	public void personalDetails(String fName,String lName,String email,String phone) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		emil.sendKeys(email);
		this.phone.sendKeys(phone);
		log.info("");
	}


}
