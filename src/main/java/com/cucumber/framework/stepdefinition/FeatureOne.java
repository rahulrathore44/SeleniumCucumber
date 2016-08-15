package com.cucumber.framework.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class FeatureOne {
	
	private WebDriver driver;
	
	@Given("^I create the webdriver object$")
	public void i_create_the_webdriver_object() throws Throwable {
		driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
	}

	@Given("^I navigate to youtube page$")
	public void i_navigate_to_youtube_page() throws Throwable {
	   driver.get("https://www.youtube.com/");
	}

	@When("^I click on the sign in button$")
	public void i_click_on_the_sign_in_button() throws Throwable {
		//driver.findElement(By.xpath("//button//span[text()='Sign in']")).click();
	}

	@Then("^Sigh in page should open$")
	public void sigh_in_page_should_open() throws Throwable {
		System.out.println("Waiting ....");
	}

	@Then("^check more title$")
	public void check_more_title() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(200, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.titleContains("YouTube"));
		System.out.println(driver.getTitle());
	}
}
