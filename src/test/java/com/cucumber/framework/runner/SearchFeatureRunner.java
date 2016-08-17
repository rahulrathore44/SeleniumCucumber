/**
 * @author rahul.rathore
 *	
 *	14-Aug-2016
 */
package com.cucumber.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "classpath:com/cucumber/framework/featurefile/Search.feature" }, 
		glue={"classpath:com.cucumber.framework.stepdefinition","classpath:com.cucumber.framework.helper"},
		format={"pretty"})
public class SearchFeatureRunner extends AbstractTestNGCucumberTests {
}
