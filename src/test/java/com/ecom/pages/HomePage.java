package com.ecom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.ecom.support.*;

/**
 * POM - Home Page of PUMA <br>
 * This Class contains all the required methods and locators of Home Page
 * 
 * @author harish.subramani
 * 
 */
public class HomePage extends LoadableComponent <HomePage> {

	// Private Class Variables
	private String appURL;
	private WebDriver driver;
	private boolean isPageLoaded;

	/**********************************************************************************************
	 ********************************* WebElements of Home Page ***********************************
	 **********************************************************************************************/
	// Cache Lookup will be used when the locator won't change in period time.
	// So the already got instance of the locator can be re-used for the browser action

	@CacheLookup
	@FindBy(css = "input[name='q']")
	WebElement txtSearch;
	
	@FindBy(css = "a[class*='menu-link mini-cart-link'][title='Please add an item to your cart']")
	WebElement emptybag;
	
	@CacheLookup
	@FindBy(css = "form[role='search'] button[type='submit']")
	WebElement btnSearch;

	@CacheLookup
	@FindBy(css = "button[title='Close']")
	WebElement btnEmailClosePopup;

	/**********************************************************************************************
	 ********************************* WebElements of Home Page - Ends ****************************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 * 
	 * @param url
	 *            : UAT URL
	 */
	public HomePage(WebDriver driver, String url) {
		appURL = url;
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, Utils.maxElementWait);
		PageFactory.initElements(finder, this);
	}// HomePage

	/**
	 * Loadable Component Overloaded method - isLoaded()
	 */
	@Override
	protected void isLoaded() {

		Utils.waitForPageLoad(driver);

		if (!isPageLoaded) {
			Assert.fail();
		}

		Utils.waitForPageLoad(driver);

		if (isPageLoaded && !(Utils.waitForElement(driver, btnSearch))) {
			Log.fail("Home Page did not open up. Site might be down.", driver);
		}

	}// isLoaded

	@Override
	protected void load() {

		isPageLoaded = true;
		driver.get(appURL);
		Utils.waitForPageLoad(driver);
		Utils.waitForElement(driver, btnSearch);

	}// load

	/**
	 * Method used to search for the product
	 * 
	 * @param textToSearch
	 *            : Text need to searched on the page
	 */
	public CLP_Page searchProduct(String textToSearch) {
		
		//final long startTime = StopWatch.startTime();
		
		BrowserActions.typeOnTextField(txtSearch, textToSearch, driver, "Search Box");
		BrowserActions.clickOnButton(btnSearch, driver, "Search");
		//Log.event("Searched the provided product!", StopWatch.elapsedTime(startTime));		
		
		return new CLP_Page(driver).get();
		
	}//searchProduct
	
	public ShoppingBagPage tapOnEmptyBag(){
		BrowserActions.clickOnButton(emptybag, driver, "clicking empty bag");
		return new ShoppingBagPage(driver).get();
	}

	
}// HomePage
