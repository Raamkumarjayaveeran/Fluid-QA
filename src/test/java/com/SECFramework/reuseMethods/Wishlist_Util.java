package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Wishlist Functionality for Retail Sites
 * 
 * Also created re-usable methods for DemandWare business flows
 * 
 * Some of the DW methods can be optimized and use for other platform based retail site also
 * 
 * @author harish.subramani
 * 
 */
public class Wishlist_Util {

	/**
	 * Click Wishlist Button - DW and Non-DW Sites
	 * 
	 * @param btnWishlist
	 *            : Wishlist Button WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void addToWishlist(WebElement btnWishlist, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnWishlist, driver, "Add To Wishlist");
		Log.trace("Clicked addToWishlist button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// addToWishlist

	/**
	 * Click Remove Wishlist Button - DW and Non-DW Sites
	 * 
	 * @param btnRemvWishilst
	 *            : Wishlist Button WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void removeFromWishlist(WebElement btnRemvWishilst, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnRemvWishilst, driver, "removeFromWishlist");
		Log.trace("Clicked removeFromWishlist button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// removeFromWishlist

	/**
	 * To get a text for Wishlist - From PDP/QV/Wishlist Page
	 * 
	 * @param fromWhichTxtShldExtract
	 *            : WebElement from which Text need to extracted
	 * @param driver
	 *            : WebDriver instance
	 * 
	 * @return: String - text from Wishlist Page
	 */
	final public String getTextForWishlist(WebElement fromWhichTxtShldExtract, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String textToReturn = BrowserActions.getText(driver, fromWhichTxtShldExtract, "Paymet Page");
		Log.trace("Text extracted for Wishlist.", StopWatch.elapsedTime(startTime));

		return textToReturn;

	}// getTextFromPaymetPage

	/**
	 * Remove Wishlist Button - DW and Non-DW Sites
	 * 
	 * @param btnRemvWishilst
	 *            : Wishlist Delete String [CSS Selector]
	 * @param wishlistPosition
	 *            : $ symbol in btnRemvWishilst param will be replaced with this string. Ex: "1" - ul[class=''] li:nth-child(1) a
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void removeFromWishlist(String btnRemvWishilst, String wishlistPosition, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String replacedString = btnRemvWishilst.replace("$", wishlistPosition);

		BrowserActions.clickOnButton(replacedString, driver, "Wishlist Delete");
		Log.trace("Clicked Delete Wishlist button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// removeFromWishlist

	/**
	 * Delete desired number of Wishlist
	 * 
	 * @param btnRemvWishilst
	 *            : Wishlist Delete String
	 * @param wishlistCountToDelete
	 *            : Number of Wishlist to delete
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void deleteMulitpleWishlist(WebElement btnRemvWishilst, int wishlistCountToDelete, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		for (int i = 0; i < wishlistCountToDelete; i++) {

			BrowserActions.clickOnButton(btnRemvWishilst, driver, "Wishlist Delete");
			Log.trace("Clicked Delete 'X' Wishlist button.", StopWatch.elapsedTime(startTime));

		}

		Log.trace("Deleted '" + wishlistCountToDelete + "' Wishlist.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// deleteMulitpleWishlist

}// Wishlist_Util