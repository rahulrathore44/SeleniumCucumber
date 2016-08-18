package com.cucumber.framework.helper.PageObject.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cucumber.framework.helper.DropDown.DropDownHelper;
import com.cucumber.framework.helper.PageObject.PageBase;
import com.cucumber.framework.helper.PageObject.laptoppage.LaptopPage;
import com.cucumber.framework.helper.PageObject.tabletpage.TabletPage;
import com.cucumber.framework.helper.TextBox.TextBoxHelper;

public class HomePage extends PageBase {
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/** Web Elements */
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Laptops']")
	public WebElement laptops;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Tablets']")
	public WebElement tablets;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Cameras']")
	public WebElement cameras;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Mobile Phones']")
	public WebElement mobilePhones;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Speakers']")
	public WebElement speakers;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Headphones']")
	public WebElement headPhones;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='iPod']")
	public WebElement iPod;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Smart Devices']")
	public WebElement smartDevices;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='WHSmith']")
	public WebElement whSmith;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Books - Fiction']")
	public WebElement booksFiction;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Books - Non-Fiction']")
	public WebElement booksNonFiction;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='Books - Children']")
	public WebElement booksChildren;
	
	@FindBy(how=How.XPATH,using="//div[@id='main-nav']//a[text()='productSort']")
	public WebElement productSort;
	
	/** Default Methods **/
	
	String getMenuLocator(String name){
		return "//div[@id='main-nav']//a[text()='" + name + "']";
	}
	
	
	/** Public Methods  **/
	
	public void navigateTo(String name) {
		driver.findElement(By.xpath(getMenuLocator(name))).click();
	}
	
	public void selectProductOrder(String order){
		new DropDownHelper(driver).SelectUsingVisibleValue(productSort, order);
	}
	
	public String getItems(){
		return new TextBoxHelper(driver).getText(By.xpath("//span[@class='h4']"));
	}
	
	public LaptopPage navigateToLaptop(){
		laptops.click();
		LaptopPage lPage = new LaptopPage(driver);
		waitForElement(lPage.title, 60);
		log.info("");
		return lPage;
	}
	
	public TabletPage naviagteToTablet() {
		tablets.click();
		TabletPage tPage = new TabletPage(driver);
		waitForElement(tPage.title, 60);
		log.info("");
		return tPage;
	}

}
