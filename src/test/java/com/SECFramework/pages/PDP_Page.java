package com.SECFramework.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.SkipException;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

public class PDP_Page extends LoadableComponent <PDP_Page> {

	private WebDriver driver;
	private boolean isPageLoaded;
	public static HashMap <String, String> prdDetails = new HashMap <String, String>();
	String strColorSwatch = "ul[class='swatches color'] li>a[title*='$']";
	String strColorSwatchANY = "ul[class='swatches color'] li>a[data-displayoutofstock='false']";
	String btnSizeOption = "ul[class='size-swatches size'] li a[title='$']";
	String btnSizeOptionANY = "ul[class='size-swatches size'] li:nth-child(1)";
	String btnQtyOption = "div[class='quantity-options-menu'] ul[class*='selectpicker'] li[rel='$']";
	

	/**********************************************************************************************
	 ********************************* WebElements of PDP *****************************************
	 **********************************************************************************************/

	@FindBy(css = "button[id='add-to-cart']")
	WebElement btnAddToCart;

	@FindBy(css = "ul[class='swatches color']")
	WebElement colorSwatch;

	@FindBy(css = "div[class='product-reviews-summary']")
	WebElement reviewSumary;

	@FindBy(css = "button[data-id='va-size']")
	WebElement btnSize;

	@FindBy(css = "button[data-id='Quantity']")
	WebElement btnQty;

	@FindBy(css = "a[class*='minicart-button'][title='Checkout']")
	WebElement btnCheckoutInMiniCart;

	@FindBy(css = "div[class='mini-cart-total']")
	WebElement btnShoppingBag;

	@FindBy(css = "span[class='price-sales '], span[class='price-sales black stdPrice']")
	WebElement labelSalesPrice;

	@FindBy(css = "span[itemprop='productID']")
	WebElement labelPrdID;

	@FindBy(css = "h1[itemprop='name']")
	WebElement labelPrdName;

	@FindBy(css = "input[name='q']")
	WebElement txtSearch;

	@FindBy(css = "form[role='search'] button[type='submit']")
	WebElement btnSearch;
	
	@FindBy(css ="div[class*= 'reviews-summary'] a[title*= 'review']")
	WebElement lnkWriteReview;

	/**********************************************************************************************
	 ********************************* WebElements of PDP - Ends **********************************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public PDP_Page(WebDriver driver) {
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
			isPageLoaded = Utils.waitForElement(driver, btnShoppingBag, 60);
		}
		catch (TimeoutException e) {
			driver.get(driver.getCurrentUrl());
			Utils.waitForPageLoad(driver);
			isPageLoaded = Utils.waitForElement(driver, colorSwatch, 60);
			isPageLoaded = Utils.waitForElement(driver, reviewSumary, 60);
		}

	}// isLoaded

	@Override
	protected void load() {

		isPageLoaded = true;
		Utils.waitForPageLoad(driver);
		Utils.waitForElement(driver, btnAddToCart);

	}// load

	/**
	 * Add Item to cart from PDP - PUMA
	 * 
	 * @param color
	 *            : Color to be selected. If 'any' is passed, first available color will be selected
	 * @param size
	 *            : Size to be selected. If 'any' is passed, first available size will be selected
	 * @param qty
	 *            : No of Qty to be picked
	 */
	public HashMap <String, String> addItemToBag(String color, String size, int qty) {

		final long startTime = StopWatch.startTime();

		HashMap <String, String> prdDetails = new HashMap <String, String>();
		prdDetails.put("price", BrowserActions.getText(driver, labelSalesPrice, "Paymet Page"));
		prdDetails.put("sku", BrowserActions.getText(driver, labelPrdID, "Paymet Page"));
		prdDetails.put("name", BrowserActions.getText(driver, labelPrdName, "Paymet Page"));

		BrowserActions.clickOnButton((strColorSwatch.replace("$", color)), driver, "Color");
		Log.event("Selected Color: " + color + ".", StopWatch.elapsedTime(startTime));

		BrowserActions.clickOnButton(btnSize, driver, "Clicked Size Button");
		BrowserActions.clickOnButton((btnSizeOption.replace("$", size)), driver, "Clicked Size Option Button");
		Log.event("Selected Size: " + size + ".", StopWatch.elapsedTime(startTime));

		BrowserActions.clickOnButton(btnQty, driver, "Clicked Qty Button");
		BrowserActions.clickOnButton((btnQtyOption.replace("$", String.valueOf(qty - 1))), driver, "Clicked Qty Option Button");
		Log.event("Selected Qty: " + qty + ".", StopWatch.elapsedTime(startTime));

		BrowserActions.clickOnButton(btnAddToCart, driver, "Add To Bag");
		Log.event("Clicked Add to Bag button.", StopWatch.elapsedTime(startTime));

		Utils.waitForElement(driver, btnCheckoutInMiniCart);

		return prdDetails;

	}// addItemToBag

	/**
	 * Go To Shopping Bag Page
	 */
	public ShoppingBagPage goToShoppingBagPage() {

		//final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(btnShoppingBag, driver, "Product Thumbnail");
		//Log.event("Clicked Shopping Bag button.", StopWatch.elapsedTime(startTime));
		return new ShoppingBagPage(driver).get();

	}// goToShoppingBagPage
	
	public boolean gotoWriteReview(){
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(lnkWriteReview, driver,"click on order status button");
		Log.event("Searched the provided product!", StopWatch.elapsedTime(startTime));
		return isPageLoaded;
	}
	
	public PDP_Page addAvailableItemToCart() {

        int scrollCount = 0;
        boolean foundAvaiableProduct = false;
        //List <WebElement> listOfProducts = driver.findElements(By.cssSelector("ul[id='search-result-items']"));
        List <WebElement> listOfProducts =driver.findElements(By.xpath("//ul[@id='search-result-items']/li/div[1]"));
        for (int i = 1; i <= listOfProducts.size(); i++) 
        {
               try {

                     if (foundAvaiableProduct)
                            break;
                     if (scrollCount == 3) {
                            JavascriptExecutor jse = (JavascriptExecutor) driver;
                            jse.executeScript("window.scrollBy(0, 250)", "");
                            scrollCount = 0;
                     }
                            driver.findElement(By.xpath("//ul[@id='search-result-items']/li["+i+"]/div[1]/div[@class='product-name']/h2/a")).click();
                            scrollCount++;
                     

                     Utils.waitForPageLoad(driver);
                     
                                   String inStockMessage = BrowserActions.getText(driver, "div[class='availability-msg'] p", "Available Message");
                                   if (inStockMessage.equalsIgnoreCase("in stock"))
                                          foundAvaiableProduct = true;
                                   if (foundAvaiableProduct == true) {
                                   List <WebElement> listOfColors = driver.findElements(By.cssSelector("ul[class='swatches color'] li"));

                                   for (int clr = 0; clr < listOfColors.size(); clr++) {

                                          if (foundAvaiableProduct)
                                                 break;
                                          else
                                                 listOfColors = driver.findElements(By.cssSelector("ul[class='swatches color'] li"));

                                          listOfColors.get(clr).click();
                                          Utils.waitForPageLoad(driver);
                                          
                                          List <WebElement> listOfSize = driver.findElements(By.cssSelector("ul[class='size-swatches size'] li"));

                                          for (int sz = 0; sz < listOfSize.size(); sz++) {

                                                 if (foundAvaiableProduct)
                                                        break;

                                                 BrowserActions.clickOnButton(btnSize, driver, "Clicked Size Button");

                                                 try {
                                                        listOfSize.get(sz).click();
                                                 }
                                                 catch (StaleElementReferenceException e) {
                                                        i--;
                                                        listOfSize = driver.findElements(By.cssSelector("ul[class='size-swatches size'] li"));
                                                        listOfSize.get(sz).click();
                                                 }

                                                 Utils.waitForPageLoad(driver);
                                                 btnAddToCart.click();
                                                 Utils.waitForPageLoad(driver);
                                   //else
                                          //listOfSize = driver.findElements(By.cssSelector("ul[class='size-swatches size'] li"));
                                          }
                            }

                     }// Color For

                     if (!foundAvaiableProduct) {
                            driver.navigate().back();
                            Utils.waitForPageLoad(driver);
                     }
               }
               catch (StaleElementReferenceException e) {
                     i--;
                     listOfProducts = driver.findElements(By.cssSelector("ul[id='search-result-items'] li[class*='grid-tile']"));
               }
        }
        // main loop

        if (!foundAvaiableProduct) {
               throw new SkipException("No Product Available in Search Result Page!");
        }
        else {
               Utils.waitForPageLoad(driver);
               prdDetails.put("price", BrowserActions.getText(driver, labelSalesPrice, "Paymet Page"));
               prdDetails.put("sku", BrowserActions.getText(driver, labelPrdID, "Paymet Page"));
               prdDetails.put("name", BrowserActions.getText(driver, labelPrdName, "Paymet Page"));
        }
        return new PDP_Page(driver).get();

 }// End of method addItemDynamically

}// CLP_Page
