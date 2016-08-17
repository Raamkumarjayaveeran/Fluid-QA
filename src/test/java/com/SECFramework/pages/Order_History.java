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

import com.SECFramework.support.Utils;




/**
 * 
 * 
 * @author harish.subramani
 * 
 */
public class Order_History extends LoadableComponent <Order_History> {

	private WebDriver driver;
	private boolean isPageLoaded;
	public static HashMap <String, String> prdDetails = new HashMap <String, String>();
	

	/**********************************************************************************************
	 ********************************* WebElements of Order_History *****************************************
	 **********************************************************************************************/

	@FindBy(css = "h1[class='h8 my-account-main-interior my-account-headers']")
	WebElement orderHistoryTitle;

	
	

	/**********************************************************************************************
	 ********************************* WebElements of Order_History - Ends **********************************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public Order_History(WebDriver driver) {
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, Utils.maxElementWait);
		PageFactory.initElements(finder, this);
	}// PDP_Page

	@Override
	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}

		try {
			isPageLoaded = Utils.waitForElement(driver, orderHistoryTitle, 60);
		}
		catch (TimeoutException e) {
			driver.get(driver.getCurrentUrl());
			Utils.waitForPageLoad(driver);
			isPageLoaded = Utils.waitForElement(driver, orderHistoryTitle, 60);
		}

	}// isLoaded

	@Override
	protected void load() {

		isPageLoaded = true;
		Utils.waitForPageLoad(driver);
		Utils.waitForElement(driver, orderHistoryTitle);

	}// load
	
}