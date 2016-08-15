/**
 * @author rahul.rathore
 *	
 *	14-Aug-2016
 */
package com.cucumber.framework.settings;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



/**
 * @author rahul.rathore
 *
 *         14-Aug-2016
 *
 */



@CucumberOptions(features = { "classpath:com/cucumber/framework/featurefile/Feature1.feature" }, 
		glue="com.cucumber.framework.stepdefinition",
		format={"pretty"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
