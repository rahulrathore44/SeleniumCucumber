/**
 * @author rahul.rathore
 *	
 *	14-Aug-2016
 */
package com.cucumber.framework1.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "classpath:com/cucumber/framework/featurefile/Search.feature" }, 
		glue="com.cucumber.framework.stepdefinition",
		format={"pretty"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
