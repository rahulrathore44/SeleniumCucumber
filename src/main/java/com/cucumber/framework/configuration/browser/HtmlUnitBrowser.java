/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.cucumber.framework.configuration.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author rsr
 *
 * Aug 6, 2016
 */
public class HtmlUnitBrowser {
	
	public Capabilities getHtmlUnitDriverCapabilities() {
		DesiredCapabilities unit = DesiredCapabilities.htmlUnitWithJs();
		return unit;
	}
	
	public WebDriver getHtmlUnitDriver(Capabilities cap) {
		return new HtmlUnitDriver(cap);
	}

}
