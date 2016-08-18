/**
 * @author rahul.rathore
 *	
 *	16-Aug-2016
 */
package com.cucumber.framework.stepdefinition;

import org.testng.Assert;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.helper.PageObject.laptoppage.LaptopPage;
import com.cucumber.framework.helper.PageObject.tabletpage.TabletPage;
import com.cucumber.framework.settings.ObjectRepo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author rahul.rathore
 *
 *         16-Aug-2016
 *
 */
public class SearchStepDfn {
	
	private HomePage hPage;
	private LaptopPage lPage;
	private TabletPage tPage;

	@Given("^: I am at the home page$")
	public void _i_am_at_the_home_page() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
		hPage = new HomePage(ObjectRepo.driver);
	}

	@When("^: I click on the laptops search filter$")
	public void _i_click_on_the_laptops_search_filter() throws Throwable {
		lPage = hPage.navigateToLaptop();
	}
	
	@When("^: I click on the tablet search filter$")
    public void _i_click_on_the_tablet_search_filter() throws Throwable {
		tPage = hPage.navigteToTablet();
    }

	@Then("^: I should be at the laptop search page with \"([^\"]*)\"$")
    public void _i_should_be_at_the_laptop_search_page_with_something(String items) throws Throwable {
		Assert.assertEquals(lPage.getItems(),items);
	}
	
	@Then("^: I should be at the tablet search page with \"([^\"]*)\"$")
	public void _i_should_be_at_the_tablet_search_page_with_something(String items) throws Throwable {
		Assert.assertEquals(tPage.getItems(),items);
	}
	
	@And("^: The title should be \"([^\"]*)\" search page$")
    public void _the_title_should_be_something_search_page(String title)
			throws Throwable {
		Assert.assertTrue(hPage.checkForTitle(title));
	}

}
