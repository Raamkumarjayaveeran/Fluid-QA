package com.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.ecom.support.*;

/**
 * 
 * @author harish.subramani
 * 
 */
public class ShoppingBagPage extends LoadableComponent <ShoppingBagPage> {

	private WebDriver driver;
	private boolean isPageLoaded;
	String textofemptybag = null;

	/**********************************************************************************************
	 ********************************* WebElements of Shopping Bag Page ***************************
	 **********************************************************************************************/

	@FindBy(css = "div[class*='cart-footer'] button[name*='checkoutCart']")
	WebElement btnCheckout;

	@FindBy(css = "button[name*='addCoupon']")
	WebElement btnPromoApply;
	
	@FindBy(css = "h2[class*= 'h8 font-styled-regular capitalize']")
	WebElement emptybagmessage;

	@FindBy(css = "form[id='cart-items-form']")
	WebElement formShoppingCartBlock;

	/**********************************************************************************************
	 ********************************* WebElements of Shopping Bag Page - Ends ********************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public ShoppingBagPage(WebDriver driver) {
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
			isPageLoaded = Utils.waitForElement(driver, formShoppingCartBlock, 60);
		}
		catch (TimeoutException e) {
			driver.get(driver.getCurrentUrl());
			Utils.waitForPageLoad(driver);
			isPageLoaded = Utils.waitForElement(driver, btnPromoApply, 60);
			isPageLoaded = Utils.waitForElement(driver, btnCheckout, 60);
		}

	}// isLoaded

	@Override
	protected void load() {

		isPageLoaded = true;
		Utils.waitForPageLoad(driver);
		Utils.waitForElement(driver, formShoppingCartBlock);

	}// load

	/**
	 * Go To Checkout Page
	 */
	public CheckoutPage goToCheckoutPage() {

		//final long startTime = StopWatch.startTime();
		
		driver.findElement(By.cssSelector("h1[class='checkout-header checkout-header-cart h6']")).click();
		Utils.waitForPageLoad(driver);		
		BrowserActions.clickOnButton(btnCheckout, driver, "Shopping Checkout Button");
		//Log.event("Clicked Checkout button.", StopWatch.elapsedTime(startTime));

		return new CheckoutPage(driver).get();
		
	}// goToShoppingBagPage
	
	public String emptyShoppingBagText() {
		//final long startTime = StopWatch.startTime();
		String textofemptybag = BrowserActions.getText(driver,emptybagmessage , "getting the text");
		//Log.event("Clicked Shopping Bag button.", StopWatch.elapsedTime(startTime));
		System.out.println(textofemptybag);
		return textofemptybag;
	}// goToShoppingBagPage

}// ShoppingBagPage