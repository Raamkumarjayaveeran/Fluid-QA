package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of PDP for Retail Sites
 * 
 * @author harish.subramani
 * 
 */
public class PDP_Util {

	/**
	 * Select Size in PDP - DW and Non DW site
	 * 
	 * @param btnSize
	 *            : Size Button WebElement
	 * @param optToSelect
	 *            : Option to select from combobox
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectSize(WebElement btnSize, String optToSelect, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnSize, driver, "Clicked Size Button");
		BrowserActions.clickOnButton(optToSelect, driver, "Clicked Size Option Button");
		Log.trace("Selected " + "Size - " + optToSelect + ".", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectSize

	/**
	 * Select Quantity in PDP - DW and Non DW site
	 * 
	 * @param btnQty
	 *            : Quantity Button WebElement
	 * @param optToSelect
	 *            : Option to select from combobox
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectQty(WebElement btnQty, String optToSelect, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.selectFromComboBox(btnQty, optToSelect, driver, "Quantity - " + optToSelect);
		Log.trace("Selected " + "Quantity - " + optToSelect + ".", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectQty

	/**
	 * Select Quantity in PDP - DW and Non DW site
	 * 
	 * @param btnQty
	 *            : Quantity Button WebElement
	 * @param optToSelect
	 *            : Option to select from combobox
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void pickQty(WebElement btnQty, String optToSelect, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnQty, driver, "Clicked Qty Button");
		BrowserActions.clickOnButton(optToSelect, driver, "Clicked Qty Option Button");
		Log.trace("Selected " + "Qty - " + optToSelect + ".", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// pickQty

	/**
	 * Select Color in PDP - DW and Non DW site
	 * 
	 * @param btnColor
	 *            : Color Button WebElement
	 * @param optToSelect
	 *            : Option to select from combobox
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectColor(WebElement btnColor, String optToSelect, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.selectFromComboBox(btnColor, optToSelect, driver, "Color - " + optToSelect);
		Log.trace("Selected " + "Color - " + optToSelect + ".", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectColor

	/**
	 * Click Color in PDP - DW and Non DW site
	 * 
	 * @param btnColor
	 *            : Color Button WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectColor(WebElement btnColor, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnColor, driver, "Color");
		Log.trace("Selected Color Swatch.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectColor

	/**
	 * Click Color in PDP - DW and Non DW site
	 * 
	 * @param btnColor
	 *            : Color Button CSS Locator
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectColor(String btnColor, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnColor, driver, "Color");
		Log.trace("Selected Color Swatch.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectColor

	/**
	 * Click on Product Thumbnail in PDP - DW and Non DW site
	 * 
	 * @param linkPrdThumbnail
	 *            : Product Thumbnail WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void clickProductThumbnail(WebElement linkPrdThumbnail, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(linkPrdThumbnail, driver, "Product Thumbnail");
		Log.trace("Clicked Product Thumbnail button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// clickProductThumbnail

	/**
	 * Expand Product Details Tab - DW site
	 * 
	 * @param tabPrdDetails
	 *            : Product Details Tab WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void expandProductDetailsTab(WebElement tabPrdDetails, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(tabPrdDetails, driver, "Product Details Tab");
		Log.trace("Clicked Product Details Tab button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// expandProductDetailsTab

	/**
	 * Expand Product Size Guide Tab - DW site
	 * 
	 * @param tabPrdSizeGuide
	 *            : Product Size Guide Tab WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void expandProductSizeGuideTab(WebElement tabPrdSizeGuide, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(tabPrdSizeGuide, driver, "Product Size Guide Tab");
		Log.trace("Clicked Product Size Guide Tab button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// expandProductSizeGuideTab

	/**
	 * Expand Product Shipping Returns Tab - DW site
	 * 
	 * @param tabPrdShippingReturns
	 *            : Product Shipping Returns Tab WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void expandProductShippingReturnsTab(WebElement tabPrdShippingReturns, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(tabPrdShippingReturns, driver, "Product Shipping Returns Tab");
		Log.trace("Clicked Product Shipping Returns Tab button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// expandProductShippingReturnsTab

	/**
	 * Click on Product Play Video in PDP - DW and Non DW site
	 * 
	 * @param btnPlayVideo
	 *            : Play Video WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void clickPlayVideo(WebElement btnPlayVideo, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnPlayVideo, driver, "Product Play Video");
		Log.trace("Clicked Product Play Video button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// clickPlayVideo

	/**
	 * Click on Certona Previous/Next Arrow - DW Site [you might also like, Recently viewed and Trending now]
	 * 
	 * @param btnArrow
	 *            : Certona Arrow WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void clickCertonaArrow(WebElement btnArrow, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnArrow, driver, "Certona Arrow");
		Log.trace("Clicked Certona Arrow button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// clickPlayVideo

	/**
	 * Open PDP from Certona - DW Site [you might also like, Recently viewed and Trending now]
	 * 
	 * @param btnPDPFromCertona
	 *            : PDP button from Certona
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void openPDPFromCertona(WebElement btnPDPFromCertona, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnPDPFromCertona, driver, "Open PDP from Certona");
		Log.trace("Clicked PDP button from Certona.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// openPDPFromCertona

	/**
	 * To get a text from PDP
	 * 
	 * @param fromWhichTxtShldExtract
	 *            : WebElement from which Text need to extracted
	 * @param driver
	 *            : WebDriver instance
	 * 
	 * @return: String - text from Wishlist Page
	 */
	final public static String getTextFromPDP(WebElement fromWhichTxtShldExtract, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String textToReturn = BrowserActions.getText(driver, fromWhichTxtShldExtract, "Paymet Page");
		Log.trace("Text extracted", StopWatch.elapsedTime(startTime));

		return textToReturn;

	}// getTextFromPaymetPage

	/**
	 * Click Checkout/Shopping bag Button in Mini-cart PDP
	 * 
	 * @param btnCheckout
	 *            : Checkout button
	 * @param driver
	 *            : Webdriver Instance
	 */
	final public static void goToCheckoutOrShoppingBagPage(WebElement btnCheckout, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnCheckout, driver, "Product Thumbnail");
		Log.trace("Clicked Checkout button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// goToCheckoutPage
	
}// PDP_Util