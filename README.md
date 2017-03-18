### Selenium Framework with Cucumber

BDD framework for automation using Selenium Cucumber and TestNg

The framework has following features 

1. Modular Design
2. Maven based framework
3. Log4j enabled for logging
4. Report Generation (cucumber-reporting) 
5. Helper class to handle web component such as (Button,Link etc)
6. Centralized Configuration (Using Properties file)
7. POM
8. Hooks for different browser support (using tag @chrome,@firefox...)

### Here is the basic code:

To use the class for handling the web component create the object and use it

```java
	GridHelper grid = new GridHelper(driver);
	grid.typeInGrid(item,GridLocator.cartId,1,1,qty);
```

### Add the Feature file 

Add the feature file under `test\resources\featurefile`

```java
Feature: Adding a laptop to the Cart

  @chrome
  Scenario: Search Laptop and add it to the cart
    Given : I am at the home page
    When : I click on the "Laptops" search filter
    Then : I should be at the "Laptops" search page with "35 items"
    And : The title should be "Laptops" search page
    Then : I select the "APPLE MacBook Pro Retina" with description as "15-inch, 256GB"
    And : Add it to the cart
    Then : Navigate to user details page and provide the following details
      | Destination | Singapore  |
      | Airline     | AirAsia    |
      | FlightNo    | A089       |
      | FlightDate  | 24/08/2016 |
      | FlightTime  | 5:00       |
      | Terminal    | Terminal 1 |
      | FirstName   | Selenium   |
      | LastName    | Java       |
      | Email       | sq@j.com   |
      | Phone       |  121212121 |
```

use the tag `@chrome` to launch the specific browser or no-tag to use the browser form the `config.properties` file

### Create the Runner

```java
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
``` 

### Use the testng.xml file to run the test cases

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">
	<listeners>
		<listener
			class-name="com.cucumber.framework.listeners.reportlistener.CucumberReport" />
	</listeners>
	<test name="Test - 1">
		<classes>
			<class name="com.cucumber.framework.runner.SearchFeatureRunner" />
			<class name="com.cucumber.framework.runner.LaptopFeatureRunner" />
			<class name="com.cucumber.framework.runner.TabletFeatureRunner" />
			<class name="com.cucumber.framework.runner.SearchWithFilterRunner" />
		</classes>
	</test>
</suite> 
```

### To see this whole thing running simply checkout this project and run this command:

`mvn clean generate-sources test`

### Cucumber Report

There is a feature overview page:

![feature overview page](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/feature-overview.png)

And there are also feature specific results pages:

![feature specific page passing](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/feature-passed.png)

And useful information for failures:

![feature specific page passing](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/feature-failed.png)

If you have tags in your cucumber features you can see a tag overview:

![Tag overview](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/tag-overview.png)

And you can drill down into tag specific reports:

![Tag report](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/tag-report.png)


