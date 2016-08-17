package com.ecom.pages;

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

import com.ecom.support.*;

/**
 * 
 * 
 * @author harish.subramani
 * 
 */
public class CLP_Page extends LoadableComponent <CLP_Page> {

	private WebDriver driver;
	private boolean isPageLoaded;
	public static HashMap <String, String> prdDetails = new HashMap <String, String>();
	

	/**********************************************************************************************
	 ********************************* WebElements of PDP *****************************************
	 **********************************************************************************************/

	@FindBy(css = "ul[id='search-result-items'] li[class*='grid-tile']")
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
	 ********************************* WebElements of PDP - Ends **********************************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public CLP_Page(WebDriver driver) {
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
					System.out.println("####"+i+"#####");
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
								else
								listOfSize = driver.findElements(By.cssSelector("ul[class='size-swatches size'] li"));
								BrowserActions.clickOnButton(btnSize, driver, "Clicked Size Button");

								try {
									listOfSize.get(sz).click();
								}
								catch (StaleElementReferenceException e) {
									i--;
									listOfSize = driver.findElements(By.cssSelector("ul[class='size-swatches size'] li"));
									listOfSize.get(sz).click();
								}
							}
							
					}
						Utils.waitForPageLoad(driver);
						btnAddToCart.click();
						Utils.waitForPageLoad(driver);

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