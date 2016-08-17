/**
 * rsr 
 *
 *Aug 5, 2016
 */
package com.cucumber.framework.helper;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.cucumber.framework.configreader.PropertyFileReader;
import com.cucumber.framework.configuration.browser.BrowserType;
import com.cucumber.framework.configuration.browser.ChromeBrowser;
import com.cucumber.framework.configuration.browser.FirefoxBrowser;
import com.cucumber.framework.configuration.browser.HtmlUnitBrowser;
import com.cucumber.framework.configuration.browser.IExploreBrowser;
import com.cucumber.framework.configuration.browser.PhantomJsBrowser;
import com.cucumber.framework.exception.NoSutiableDriverFoundException;
import com.cucumber.framework.helper.Alert.AlertHelper;
import com.cucumber.framework.helper.Browser.BrowserHelper;
import com.cucumber.framework.helper.Button.ButtonHelper;
import com.cucumber.framework.helper.CheckBox.CheckBoxOrRadioButtonHelper;
import com.cucumber.framework.helper.DropDown.DropDownHelper;
import com.cucumber.framework.helper.HyperLink.LinkHelper;
import com.cucumber.framework.helper.Javascript.JavaScriptHelper;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Navigation.NavigationHelper;
import com.cucumber.framework.helper.TextBox.TextBoxHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;
import com.cucumber.framework.interfaces.IconfigReader;
import com.cucumber.framework.settings.ObjectRepo;

/**
 * @author rsr
 *
 *         Aug 5, 2016
 */

public abstract class InitializeWebDrive {

	private volatile WebDriver driver;
	private volatile IconfigReader reader;
	private Logger oLog = LoggerHelper.getLogger(InitializeWebDrive.class);

	protected ButtonHelper button;
	protected AlertHelper alert;
	protected JavaScriptHelper javaScript;
	protected BrowserHelper browser;
	protected CheckBoxOrRadioButtonHelper chkBox;
	protected WaitHelper wait;
	protected DropDownHelper dropDown;
	protected LinkHelper link;
	protected NavigationHelper navigate;
	protected TextBoxHelper txtBox;

	public void initializeComponent(WebDriver dDriver, IconfigReader rReader)
			throws Exception {
		try {
			button = new ButtonHelper(dDriver);
			alert = new AlertHelper(dDriver);
			javaScript = new JavaScriptHelper(dDriver);
			browser = new BrowserHelper(dDriver);
			chkBox = new CheckBoxOrRadioButtonHelper(dDriver);
			wait = new WaitHelper(dDriver, rReader);
			dropDown = new DropDownHelper(dDriver);
			link = new LinkHelper(dDriver);
			navigate = new NavigationHelper(dDriver);
			txtBox = new TextBoxHelper(dDriver);
		} catch (Exception e) {
			throw e;
		}
	}

	protected InitializeWebDrive() {
		reader = new PropertyFileReader();
	}

	protected InitializeWebDrive(String fileName) {
		reader = new PropertyFileReader(fileName);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public IconfigReader getConfigReader() {
		return reader;
	}

	public WebDriver gridSetUp(String hubUrl, String browser)
			throws MalformedURLException {
		
		oLog.info(hubUrl + " : " + browser);
		
		switch (BrowserType.valueOf(browser)) {
		
		case Chrome:
			ChromeBrowser chrome = new ChromeBrowser();
			return chrome.getChromeDriver(hubUrl,
					chrome.getChromeCapabilities());

		case Firefox:
			FirefoxBrowser firefox = new FirefoxBrowser();
			return firefox.getFirefoxDriver(hubUrl,
					firefox.getFirefoxCapabilities());

		case HtmlUnitDriver:

		case Iexplorer:
			IExploreBrowser iExplore = new IExploreBrowser();
			return iExplore.getIExplorerDriver(hubUrl,
					iExplore.getIExplorerCapabilities());

		case PhantomJs:
			PhantomJsBrowser jsBrowser = new PhantomJsBrowser();
			return jsBrowser.getPhantomJsDriver(hubUrl,
					jsBrowser.getPhantomJsService(),
					jsBrowser.getPhantomJsCapability());

		default:
			throw new NoSutiableDriverFoundException(" Driver Not Found : "
					+ reader.getBrowser());
		}
	}

	public WebDriver standAloneStepUp() throws Exception {
		
		oLog.info(reader.getBrowser());
		
		switch (reader.getBrowser()) {
		
		case Chrome:
			ChromeBrowser chrome = ChromeBrowser.class.newInstance();
			return chrome.getChromeDriver(chrome.getChromeCapabilities());

		case Firefox:
			FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
			return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());

		case HtmlUnitDriver:
			HtmlUnitBrowser htmlUnit = HtmlUnitBrowser.class.newInstance();
			return htmlUnit.getHtmlUnitDriver(htmlUnit
					.getHtmlUnitDriverCapabilities());

		case Iexplorer:
			IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
			return iExplore.getIExplorerDriver(iExplore
					.getIExplorerCapabilities());

		case PhantomJs:
			PhantomJsBrowser jsBrowser = PhantomJsBrowser.class.newInstance();
			return jsBrowser.getPhantomJsDriver(
					jsBrowser.getPhantomJsService(),
					jsBrowser.getPhantomJsCapability());

		default:
			throw new NoSutiableDriverFoundException(" Driver Not Found : "
					+ reader.getBrowser());
		}

	}
	
	@Parameters(value={"hubUrl","browser"})
	@BeforeClass(alwaysRun = true)
	public void setUpDriver(@Optional("") String hubUrl,@Optional("") String browser) throws Exception {
		if(hubUrl.isEmpty() || browser.isEmpty())
			this.driver = standAloneStepUp();
		else 
			this.driver = gridSetUp(hubUrl == null ? "http://localhost:4444/wd/hub" : hubUrl, 
					browser == null ? "Chrome" : browser);
			

		oLog.debug("InitializeWebDrive : " + this.driver.hashCode());
		driver.manage().timeouts()
				.pageLoadTimeout(reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.get(reader.getWebsite());
		driver.manage().window().maximize();
		initializeComponent(driver, reader);
		ObjectRepo.data.put(Thread.currentThread().getName()
				+ Thread.currentThread().getId(), this.driver);

	}

	@AfterClass(alwaysRun = true)
	public void tearDownDriver() throws Exception {
		oLog.info("Shutting Down the driver");
		try {
			if (driver != null)
				driver.quit();
		} catch (Exception e) {
			oLog.error(e);
			throw e;
		}

	}

}
