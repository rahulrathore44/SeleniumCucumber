/**
 * @author rahul.rathore
 *	
 *	14-Aug-2016
 */
package com.cucumber.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/Search.feature" }, glue = {
		"classpath:com.cucumber.framework.stepdefinition",
		"classpath:com.cucumber.framework.helper" }, plugin = { "pretty",
		"json:target/SearchFeatureRunner.json" })
public class SearchFeatureRunner extends AbstractTestNGCucumberTests {
}
