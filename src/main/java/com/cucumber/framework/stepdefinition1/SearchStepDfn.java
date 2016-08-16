/**
 * @author rahul.rathore
 *	
 *	16-Aug-2016
 */
package com.cucumber.framework.stepdefinition1;

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

	@Given("^: I am at the home page$")
	public void _i_am_at_the_home_page() throws Throwable {
	}

	@When("^: I click on the laptops search filter$")
	public void _i_click_on_the_laptops_search_filter() throws Throwable {
	}

	@Then("^: I should be at the laptop search page$")
	public void _i_should_be_at_the_laptop_search_page() throws Throwable {
	}

	@And("^: The title should be laptop search page title$")
	public void _the_title_should_be_laptop_search_page_title()
			throws Throwable {
	}

}
