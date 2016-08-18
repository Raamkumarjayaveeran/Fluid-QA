package com.SECFramework.pages;

import java.util.HashMap;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;
import com.SECFramework.support.Log;

public class Order_Tracking extends LoadableComponent<Order_Tracking> {

	private WebDriver driver;
	private boolean isPageLoaded;
	//private static String CALL_LINK = "a:contains('call')";
	public static HashMap<String, String> prdDetails = new HashMap<String, String>();

	/**********************************************************************************************
	 ********************************* WebElements of Order Tracking *****************************************
	 **********************************************************************************************/

	@FindBy(css = "div[class='order-date']")
	WebElement orderDate;

	@FindBy(css = "a[class='btn btn-primary'][title='Return to Shopping']")
	WebElement returnShopping;
	
	@FindBy(css = "div[class*='confirmation-message'] div[class='content-asset'] a")
	WebElement gotoContactPagelink;

	/**********************************************************************************************
	 ********************************* WebElements of Order Tracking - Ends **********************************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public Order_Tracking(WebDriver driver) {
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				Utils.maxElementWait);
		PageFactory.initElements(finder, this);
	}// PDP_Page

	@Override
	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}

		try {
			isPageLoaded = Utils.waitForElement(driver, orderDate, 60);
		} catch (TimeoutException e) {
			driver.get(driver.getCurrentUrl());
			Utils.waitForPageLoad(driver);
			isPageLoaded = Utils.waitForElement(driver, orderDate, 60);
		}

	}// isLoaded

	@Override
	protected void load() {

		isPageLoaded = true;
		Utils.waitForPageLoad(driver);
		Utils.waitForElement(driver, orderDate);

	}// load

	/**
	 * use this method to click on the create Account button from My Account
	 * login page
	 * 
	 * @return : returnShopping = webElement of the return shopping button<br>
	 */

	public HomePage returnShopping() {
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(returnShopping, driver,"click on order status button");
		 Log.event("return to shopping from order status page !", StopWatch.elapsedTime(startTime));
		return new HomePage(driver, "http://development.eu.puma.com/").get();
		
		
	}
	public Contact_Page gotoContactPage(){
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(gotoContactPagelink, driver,"click on order status button");
		Log.event("Searched the provided product!", StopWatch.elapsedTime(startTime));
		return new Contact_Page(driver).get();
	}
}