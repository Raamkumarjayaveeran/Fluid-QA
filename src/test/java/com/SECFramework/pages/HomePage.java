package com.SECFramework.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import com.SECFramework.reuseMethods.Account_Util;
import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;



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
	private static final String USERNAME = "input[id='dwfrm_login_username_d0rnsscmduus']";
	//private static final String PASSWORD = "input[id=dwfrm_login_password']";
	private static final String TRYAGAIN = "div[id='panel4BackButton']";

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
	@FindBy(css = "div[class*='top-nav'] svg[class*='search__icon']")
	WebElement btnSearch;

	@CacheLookup
	@FindBy(css = "button[title='Close']")
	WebElement btnEmailClosePopup;
	
	@FindBy(css = "div[class*='top-nav'] svg[class*='icon-account']")
	WebElement lnkMyAccount;
	
	@FindBy (css = "div[class*='top-nav'] [title*='Register']")
	WebElement lnkRegister;
	
	@FindBy(css ="input[id='dwfrm_login_username_d0rnsscmduus']")
	WebElement username;
	
	@FindBy (css = "input[placeholder*='postal code']")
	WebElement txtpostalcode;
	
	@FindBy (css = "div[class='form-group'] button[class='btn btn-default']")
	WebElement btnpostalcode;
	
	@FindBy (css = "div [id = 'panel4templates'] a")
	WebElement btnShopOnline;
	
	@FindBy (css = "PASSWORD")
	WebElement password;

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
	public PLP_Page searchProduct(String textToSearch) {
		
		final long startTime = StopWatch.startTime();
		
		BrowserActions.typeOnTextField(txtSearch, textToSearch, driver, "Search Box");
		BrowserActions.clickOnButton(btnSearch, driver, "click on the search icon");
		Log.event("Searched the provided product!", StopWatch.elapsedTime(startTime));		
		
		return new PLP_Page(driver).get();
		
	}//searchProduct
	
	/**
	 * 
	 * @return
	 */
	public ShoppingBagPage tapOnEmptyBag(){
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(emptybag, driver, "clicking empty bag");
		Log.event("clicked on the empty bag!", StopWatch.elapsedTime(startTime));
		return new ShoppingBagPage(driver).get();
	}
	
	/**
	 * 
	 */
	public void accountSignIn(){
		final long startTime = StopWatch.startTime();
		HashMap <String, String> accountDetails = new HashMap<String, String>();
		accountDetails.put("type_Username_rjayaveeran@gmail.com",USERNAME);
		accountDetails.put("type_password_orion@123","PASSWORD");
		Account_Util.doAccountOperations(accountDetails, driver);
		Utils.waitForPageLoad(driver);
		Log.event("Signed In with the valid credentials!", StopWatch.elapsedTime(startTime));
		
	}
	
	/**
	 * 
	 * @return
	 */
	public void clickSignIn(){
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(lnkMyAccount, driver, "clicking sign in links");	
		Log.event("Clicked on the sign in link!", StopWatch.elapsedTime(startTime));	
	}
	
	/**
	 * 
	 * @return
	 */
	
	public MyAccountPage clickRegister(){
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(lnkRegister, driver, "clicking sign in links");	
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", element);
		Log.event("Clicked on the sign in link!", StopWatch.elapsedTime(startTime));
		return new MyAccountPage(driver).get();
	}
	/**
	 * 
	 * @param zipcode
	 * @return
	 */

	public boolean enterPostalCode(String zipcode) {
		final long startTime = StopWatch.startTime();
		BrowserActions.typeOnTextField(txtpostalcode, zipcode, driver, "Entered the valid postal code");
		Log.event("Entered the valid postal code!", StopWatch.elapsedTime(startTime));
		return isPageLoaded;	
	}
	
	/**
	 * 
	 * @return
	 */
	public StorePage gotoStoreLocatorPage(){
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(btnpostalcode, driver, "click on '<' links to navigate store page");	
		Log.event("Clicked on '<' button to navigate store locator page!", StopWatch.elapsedTime(startTime));
		return new StorePage(driver).get();
	}
	/**
	 * 
	 */

	public void TryAgain() {
		final long startTime = StopWatch.startTime();
		BrowserActions.elementDisplayed(driver, TRYAGAIN);
		Log.event("Try again button displayed!", StopWatch.elapsedTime(startTime));
		
	}
	/**
	 * 
	 * @return
	 */

	public boolean gotoShopOnline() {
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(btnShopOnline, driver, "click on shop online from store page");	
		Log.event("Try again button displayed!", StopWatch.elapsedTime(startTime));
		return isPageLoaded;
		
	}
	
}// HomePage
