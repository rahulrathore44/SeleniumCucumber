/**
 * @author rahul.rathore
 *	
 *	23-Aug-2016
 */
package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.helper.PageObject.itemsbag.ItemsBag;
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
	private ItemsBag bag;
	
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

	@Then("^: I change the quantity to \"([^\"]*)\" and click on update button$")
    public void _i_change_the_quantity_to_something_and_click_on_update_button(String qty) throws Throwable {
		bag = (ItemsBag)ObjectRepo.data.get("ItemsBag");
		bag.updateQuantity(qty);
    }
	
	@Then("^: I change the quantity of item \"([^\"]*)\" to \"([^\"]*)\" and click on update button$")
	public void _i_change_the_quantity_of_item_something_to_something_and_click_on_update_button(
			String item, String qty) throws Throwable {
		bag = (ItemsBag)ObjectRepo.data.get("ItemsBag");
		bag.updateQuantity(item, qty);
		System.out.println();
	}

}
