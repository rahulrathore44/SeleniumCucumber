/**
 * @author rahul.rathore
 *	
 *	06-Aug-2016
 */
package com.cucumber.framework.helper.Wait;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.framework.helper.Generic.GenericHelper;
import com.cucumber.framework.helper.Javascript.JavaScriptHelper;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.interfaces.IconfigReader;
import com.google.common.base.Function;

/**
 * @author rahul.rathore
 *
 *         06-Aug-2016
 *
 */
public class WaitHelper extends GenericHelper {
	
	private WebDriver driver;
	private IconfigReader reader;
	private Logger oLog = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver,IconfigReader reader) {
		super(driver);
		this.driver = driver;
		this.reader = reader;
		oLog.debug("WaitHelper : " + this.driver.hashCode());
	}
	
	private WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec) {
		oLog.debug("");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	
	public void setImplicitWait(long timeout,TimeUnit unit) {
		oLog.info(timeout);
		driver
		.manage()
		.timeouts()
		.implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}
	
	public void waitForElementVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		oLog.info(locator);
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
	}

	public void hardWait(int timeOutInMiliSec) throws InterruptedException {
		oLog.info(timeOutInMiliSec);
		Thread.sleep(timeOutInMiliSec);
	}
	
	public WebElement handleStaleElement(By locator,int retryCount,int delayInSeconds) throws InterruptedException {
		oLog.info(locator);
		WebElement element = null;
		
		while (retryCount >= 0) {
			try {
				element = driver.findElement(locator);
				return element;
			} catch (StaleElementReferenceException e) {
				hardWait(delayInSeconds);
				retryCount--;
			}
		}
		throw new StaleElementReferenceException("Element cannot be recovered");
	}
	
	public void elementExits(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		oLog.info(locator);
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(elementLocatedBy(locator));
		setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
	}
	
	public void elementExistAndVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		oLog.info(locator);
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(elementLocatedBy(locator));
		new JavaScriptHelper(driver).scrollIntoView(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		
	}
	
	public void waitForIframe(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		oLog.info(locator);
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		driver.switchTo().defaultContent();
		setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
	}
	
	private Function<WebDriver, Boolean> elementLocatedBy(final By locator){
		return new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				oLog.debug(locator);
				return driver.findElements(locator).size() >= 1;
			}
		};
	}

}
