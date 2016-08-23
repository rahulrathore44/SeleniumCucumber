/**
 * @author rahul.rathore
 *	
 *	23-Aug-2016
 */
package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.settings.ObjectRepo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author rahul.rathore
 *	
 *	23-Aug-2016
 *
 */
public class SearchWithFilter {
	
	private HomePage hPage;
	
	@Then("^: I select \"([^\"]*)\" as the brand$")
    public void _i_select_something_as_the_brand(String brand) throws Throwable {
		hPage = (HomePage)ObjectRepo.data.get("HomePage");
		hPage.selectBrands(brand);
    }
	
	@And("^: I select \"([^\"]*)\" as the price filter$")
	public void _i_select_something_as_the_price_filter(String price)
			throws Throwable {
		hPage.selectPrice(price);
	}
	
}
