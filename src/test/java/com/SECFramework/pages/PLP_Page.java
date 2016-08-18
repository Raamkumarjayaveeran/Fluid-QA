package com.SECFramework.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
import com.SECFramework.support.Utils;



/**
 * 
 * 
 * @author harish.subramani
 * 
 */
public class PLP_Page extends LoadableComponent <PLP_Page> {

	private WebDriver driver;
	private boolean isPageLoaded;
	public static HashMap <String, String> prdDetails = new HashMap <String, String>();
	

	/**********************************************************************************************
	 ********************************* WebElements of PLP *****************************************
	 **********************************************************************************************/

	@FindBy(css = "ul[id='search-result-items']")
	WebElement listOfProducts;
	
	@FindBy(css = "button[id='add-to-cart']")
	WebElement btnAddToCart;

	@FindBy(css = "button[data-id='va-size']")
	WebElement btnSize;

	@FindBy(css = "span[class='price-sales '], span[class='price-sales black stdPrice']")
	WebElement labelSalesPrice;

	@FindBy(css = "span[itemprop='productID']")
	WebElement labelPrdID;

	@FindBy(css = "h1[itemprop='name']")
	WebElement labelPrdName;
	

	/**********************************************************************************************
	 ********************************* WebElements of PLP - Ends **********************************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public PLP_Page(WebDriver driver) {
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
			isPageLoaded = Utils.waitForElement(driver, listOfProducts, 60);
		}
		catch (TimeoutException e) {
			driver.get(driver.getCurrentUrl());
			Utils.waitForPageLoad(driver);
			isPageLoaded = Utils.waitForElement(driver, listOfProducts, 60);
		}

	}// isLoaded

	@Override
	protected void load() {

		isPageLoaded = true;
		Utils.waitForPageLoad(driver);
		Utils.waitForElement(driver, listOfProducts);

	}// load

	public PDP_Page addtobag() {
		boolean foundAvaiableProduct = false;
		// TODO Auto-generated method stub
		List <WebElement> listOfProducts =driver.findElements(By.cssSelector("ul[id='search-result-items'] li"));
		for (WebElement productlist : listOfProducts)
		{
			try {
				productlist.findElement(By.cssSelector("div[class='product-tile'] div div a span")).click();
				String inStockMessage = BrowserActions.getText(driver, "div[class='availability-msg'] p", "Available Message");
				if (inStockMessage.equalsIgnoreCase("in stock")){
					foundAvaiableProduct = true;
					break; 
				}
				if (!foundAvaiableProduct) {
					driver.navigate().back();
					Utils.waitForPageLoad(driver);
				}
			}
			catch (StaleElementReferenceException e) {
				System.out.println("Exception:"+e);
			}
		}
		//Code for add to bag click
		return new PDP_Page(driver).get();
	}

	
}	