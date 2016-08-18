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
public class Contact_Page extends LoadableComponent <Contact_Page> {

	private WebDriver driver;
	private boolean isPageLoaded;
	public static HashMap <String, String> prdDetails = new HashMap <String, String>();
	

	/**********************************************************************************************
	 ********************************* WebElements of PDP *****************************************
	 **********************************************************************************************/

	@FindBy(css = "h2[class='h8']")
	WebElement customerServiceHeader;



	/**********************************************************************************************
	 ********************************* WebElements of PDP - Ends **********************************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public Contact_Page(WebDriver driver) {
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
			isPageLoaded = Utils.waitForElement(driver, customerServiceHeader, 60);
		}
		catch (TimeoutException e) {
			driver.get(driver.getCurrentUrl());
			Utils.waitForPageLoad(driver);
			isPageLoaded = Utils.waitForElement(driver, customerServiceHeader, 60);
		}

	}// isLoaded

	@Override
	protected void load() {

		isPageLoaded = true;
		Utils.waitForPageLoad(driver);
		Utils.waitForElement(driver, customerServiceHeader);

	}// load
}
	
