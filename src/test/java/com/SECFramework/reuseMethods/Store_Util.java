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
public class Store_Util {

	/**
	 * Search Store with City/State/ZIP as input
	 * 
	 * @param txtCityStateZip
	 *            : City/State/ZIP WebElement
	 * 
	 * @param cityStateZip
	 *            : City Name /State Name /ZIP Code
	 * 
	 * @param btnSearch
	 *            : Store Search Button WebElement
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void searchStore(WebElement txtCityStateZip, String cityStateZip, WebElement btnSearch, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.typeOnTextField(txtCityStateZip, cityStateZip, driver, "Search Store");
		Log.trace("Search Store.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// searchStore

	/**
	 * Select the Store Details link from search suggestion - DW application can use this
	 * 
	 * @param storeDetailsFromSuggestion
	 *            : CSS Locator for Store Detail link from Suggestion . String format - ul[class=''] li:nth-child($) a
	 * 
	 * @param whichSuggstnToClick
	 *            : $ symbol in srchRsltLoc param will be replaced with this string. Ex: "1" - ul[class=''] li:nth-child(1) a
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectStoreDetailsFromStoreSuggestions(String storeDetailsFromSuggestion, String whichSuggstnToClick, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String replacedString = storeDetailsFromSuggestion.replace("$", whichSuggstnToClick);

		BrowserActions.clickOnButton(replacedString, driver, "Store Details Link");
		Log.trace("Clicked '" + whichSuggstnToClick + "' Store Details Link from Suggestion.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectStoreDetailsFromStoreSuggestions

	/**
	 * Select the Get Directions link from search suggestion - DW application can use this
	 * 
	 * @param storeDirectionsFromSuggestion
	 *            : CSS Locator for Store Direction link from Suggestion . String format - ul[class=''] li:nth-child($) a
	 * 
	 * @param whichSuggstnToClick
	 *            : $ symbol in srchRsltLoc param will be replaced with this string. Ex: "1" - ul[class=''] li:nth-child(1) a
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectGetDirectionsFromStoreSuggestions(String storeDirectionsFromSuggestion, String whichSuggstnToClick, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String replacedString = storeDirectionsFromSuggestion.replace("$", whichSuggstnToClick);

		BrowserActions.clickOnButton(replacedString, driver, "Store Get Direction Link");
		Log.trace("Clicked '" + whichSuggstnToClick + "' Store Get Direction Link from Suggestion.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectGetDirectionsFromStoreSuggestions

	/**
	 * Click "Make My Store" link from search suggestion - DW application can use this
	 * 
	 * @param makeMyStoreFromSuggestion
	 *            : CSS Locator for Make My Store link from Suggestion . String format - ul[class=''] li:nth-child($) a
	 * 
	 * @param whichSuggstnToClick
	 *            : $ symbol in srchRsltLoc param will be replaced with this string. Ex: "1" - ul[class=''] li:nth-child(1) a
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void makeMyStoreFromStoreSuggestions(String makeMyStoreFromSuggestion, String whichSuggstnToClick, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String replacedString = makeMyStoreFromSuggestion.replace("$", whichSuggstnToClick);

		BrowserActions.clickOnButton(replacedString, driver, "Make My Store");
		Log.trace("Clicked '" + whichSuggstnToClick + "' Make My Store from Suggestion.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// makeMyStoreFromStoreSuggestions

	/**
	 * Click STS Radio - DW application can use this
	 * 
	 * @param radioSTS
	 *            : STS Radio Button WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectSTSOption(WebElement radioSTS, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(radioSTS, driver, "STS Option");
		Log.trace("Clicked STS Radio button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectSTSOption

	/**
	 * Click STS Choose Store Button - DW application can use this
	 * 
	 * @param btnChooseStore
	 *            : Choose/Change Store Button WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectSTSChooseChangeStore(WebElement btnChooseStore, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnChooseStore, driver, "Choose Store");
		Log.trace("Clicked STS Radio button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectSTSChooseChangeStore

	/**
	 * Click "Select This Store" link from search suggestion - DW application can use this
	 * 
	 * @param selectThisStoreFromSuggestion
	 *            : CSS Locator for Select This Store link from Suggestion . String format - ul[class=''] li:nth-child($) a
	 * 
	 * @param whichSuggstnToClick
	 *            : $ symbol in srchRsltLoc param will be replaced with this string. Ex: "1" - ul[class=''] li:nth-child(1) a
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectStoreAsShippingStore(String selectThisStoreFromSuggestion, String whichSuggstnToClick, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String replacedString = selectThisStoreFromSuggestion.replace("$", whichSuggstnToClick);

		BrowserActions.clickOnButton(replacedString, driver, "Select This Store");
		Log.trace("Clicked '" + whichSuggstnToClick + "' Select This Store from Suggestion.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectStoreAsShippingStore

}// Store_Util