package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Shopping_Bag Functionality for Retail Sites
 * 
 * Also created re-usable methods for DemandWare business flows
 * 
 * Some of the DW methods can be optimized and use for other platform based retail site also
 * 
 * @author harish.subramani
 * 
 */
public class Shopping_Bag_Util {

	/**
	 * Click Edit Link
	 * 
	 * @param linkEdit
	 *            : Edit Link
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void editItem(WebElement linkEdit, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(linkEdit, driver, "Edit Link");
		Log.trace("Clicked Edit Link.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// editItem

	/**
	 * Click Remove Link
	 * 
	 * @param linkRemove
	 *            : Remove Link
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void removeItem(WebElement linkRemove, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(linkRemove, driver, "Remove Item from Bag");
		Log.trace("Clicked Remove Link.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// removeItem

	/**
	 * Delete desired Item from bag
	 * 
	 * @param linkRemove
	 *            : Item from bag [CSS Selector]
	 * 
	 * @param itemPosition
	 *            : $ symbol in linkRemove param will be replaced with this string. Ex: "1" - ul[class=''] li:nth-child(1) a
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void removeItemAtPosition(String linkRemove, String itemPosition, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String replacedString = linkRemove.replace("$", itemPosition);

		BrowserActions.clickOnButton(replacedString, driver, "Remove Item from Bag");
		Log.trace("Removed Item from Bag.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// removeItemAtPosition

	/**
	 * Delete desired number of promotions
	 * 
	 * @param linkRemove
	 *            : Item Remove Delete String
	 * 
	 * @param itemRemoveCount
	 *            : Number of Item to Remove
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void removeMultipleItem(WebElement linkRemove, int itemRemoveCount, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		for (int i = 0; i < itemRemoveCount; i++) {

			BrowserActions.clickOnButton(linkRemove, driver, "Promotion Delete");
			Log.trace("Removed Item from Bag.", StopWatch.elapsedTime(startTime));

		}

		Log.trace("Deleted '" + itemRemoveCount + "' Item from Bag.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// removeMultipleItem

	/**
	 * Change the Quantity
	 * 
	 * @param btnQty
	 *            : Qty Button WebElement
	 * 
	 * @param optToSelect
	 *            : Option to select from combobox
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void changeQty(WebElement btnQty, String optToSelect, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.selectFromComboBox(btnQty, optToSelect, driver, "Credit Card - " + optToSelect);
		Log.trace("Selected " + "Credit Card - " + optToSelect + ".", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectCreditCardPayment

	/**
	 * Click Checkout Button
	 * 
	 * @param btnCheckout
	 *            : Checkout Button
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void clickCheckout(WebElement btnCheckout, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnCheckout, driver, "Checkout Button");
		Log.trace("Clicked Checkout Button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// clickCheckout

	/**
	 * To get a text from Shopping Bag Page
	 * 
	 * @param fromWhichTxtShldExtract
	 *            : WebElement from which Text need to extracted
	 * @param driver
	 *            : WebDriver instance
	 * 
	 * @return: String - text from Shopping Bag Page
	 */
	final public static String getTextFromShoppingBagPage(WebElement fromWhichTxtShldExtract, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String textToReturn = BrowserActions.getText(driver, fromWhichTxtShldExtract, "Shopping Bag Page");
		Log.trace("Text extracted", StopWatch.elapsedTime(startTime));

		return textToReturn;

	}// getTextFromShoppingBagPage

}// Shopping_Bag_Util