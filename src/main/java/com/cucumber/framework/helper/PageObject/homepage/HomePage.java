package com.cucumber.framework.helper.PageObject.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cucumber.framework.helper.DropDown.DropDownHelper;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.PageObject.PageBase;
import com.cucumber.framework.helper.PageObject.itemsbag.ItemsBag;
import com.cucumber.framework.helper.TextBox.TextBoxHelper;
import com.cucumber.framework.settings.ObjectRepo;

public class HomePage extends PageBase {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);

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
	
	@FindBy(how=How.ID,using="mini-cart")
	public WebElement shoppingCart;
	
	@FindBy(how=How.NAME,using="search")
	public WebElement searchTxtBox;
	
	@FindBy(how=How.XPATH,using="//form[@id='search-form']/div/span/button")
	public WebElement searchBtn;
	
	@FindBy(how=How.ID,using="add-to-basket")
	public WebElement reserve;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="Click here to view your shopping bag")
	public WebElement viewShoppingBag;
	
	/** Protected Methods **/
	
	/*protected String getBrandXpath(String name){
		log.debug(name);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + name + "')]";
	}*/
	
	protected String getPriceXpath(String price){
		log.debug(price);
		return "//div[@id='facetFilterOptions']//label[contains(.,'" + price + "')]";
	}
	
	protected String getItemXapth(String itemName,String shortDesp){
		log.debug("ItemName : " + itemName + " ShortDesp : " + shortDesp);
		return "//div[normalize-space()='" + shortDesp + "']/parent::*/parent::*//a[text()='" + itemName + "']";
	}
	
	protected String getBrandXpath(String bName){
		log.debug(bName);
		return "//div[@id='facets-nav']/div[2]//label[contains(normalize-space(),'" + bName + "')]";
	}
	
	/** Default Methods **/
	
	String getMenuLocator(String name){
		log.debug(name);
		return "//div[@id='main-nav']//a[text()='" + name + "']";
	}
	
	
	/** Public Methods  **/
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void selectItem(String itemName,String shortDesp) {
		driver.findElement(By.xpath(getItemXapth(itemName, shortDesp))).click();
		waitForElement(reserve, ObjectRepo.reader.getExplicitWait());
		reserve.click();
		log.info("");
	}
	
	public void search(String searchStr) {
		searchTxtBox.sendKeys(searchStr);
		searchBtn.click();
		log.info(searchStr);
	}
	
	public void navigateTo(String name) {
		driver.findElement(By.xpath(getMenuLocator(name))).click();
		log.info(name);
	}
	
	public void selectProductOrder(String order){
		new DropDownHelper(driver).SelectUsingVisibleValue(productSort, order);
		log.info(order);
	}
	
	public String getItems(){
		return new TextBoxHelper(driver).getText(By.xpath("//span[@class='h4']"));
	}
	
	public void selectBrands(String name) {
		log.info(name);
		driver.findElement(By.xpath(getBrandXpath(name))).click();
	}
	
	public void selectPrice(String price){
		log.info(price);
		driver.findElement(By.xpath(getBrandXpath(price))).click();
	}
	
	public ItemsBag navigateToCart() {
		waitForElement(viewShoppingBag, ObjectRepo.reader.getExplicitWait());
		viewShoppingBag.click();
		ItemsBag bag = new ItemsBag(driver);
		waitForElement(bag.reserveYourItem, ObjectRepo.reader.getExplicitWait());
		log.info("");
		return bag;
	}
}
