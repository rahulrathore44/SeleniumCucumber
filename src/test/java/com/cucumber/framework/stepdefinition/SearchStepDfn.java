/**
 * @author rahul.rathore
 *	
 *	16-Aug-2016
 */
package com.cucumber.framework.stepdefinition;

import org.openqa.selenium.By;

import com.cucumber.framework.helper.InitializeWebDrive;

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
public class SearchStepDfn extends InitializeWebDrive {

	@Given("^: I am at the home page$")
	public void _i_am_at_the_home_page() throws Throwable {
		getDriver().get(getConfigReader().getWebsite());
	}

	@When("^: I click on the laptops search filter$")
	public void _i_click_on_the_laptops_search_filter() throws Throwable {
		button.click(By.xpath("//div[@id='main-nav']/ul/li[1]/ul/li[1]/a"));
	}

	@Then("^: I should be at the laptop search page$")
	public void _i_should_be_at_the_laptop_search_page() throws Throwable {
		txtBox.getText(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/h1"));
	}

	@And("^: The title should be laptop search page title$")
	public void _the_title_should_be_laptop_search_page_title()
			throws Throwable {
		System.out.println(getDriver().getTitle());
	}

}
