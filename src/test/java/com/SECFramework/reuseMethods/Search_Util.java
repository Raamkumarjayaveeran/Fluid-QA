package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Search Functionality for Retail Sites
 * 
 * Also created re-usable methods for DemandWare business flows
 * 
 * Some of the DW methods can be optimized and use for other platform based retail site also
 * 
 * @author harish.subramani
 * 
 */
public class Search_Util {

	/**
	 * Searches keyword in Retail Search Box
	 * 
	 * @param txtSrch
	 *            : WebElement for Search Box
	 * @param btnSrch
	 *            : WebElement for Search Button
	 * @param txtToSearch
	 *            : Keyword to search
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void doSearch(WebElement txtSrch, WebElement btnSrch, String txtToSearch, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.typeOnTextField(txtSrch, txtToSearch, driver, "Search Box");
		Log.trace("Text entered in Search Box.", StopWatch.elapsedTime(startTime));

		BrowserActions.clickOnButton(btnSrch, driver, "Search");
		Log.trace("Clicked Search button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// doSearch

	/**
	 * Select the search product from result - DW and Non-DW application can use this
	 * 
	 * @param srchRsltLoc
	 *            : String format - ul[class=''] li:nth-child($) a
	 * @param whichRsltToClick
	 *            : $ symbol in srchRsltLoc param will be replaced with this string. Ex: "1" - ul[class=''] li:nth-child(1) a
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectFromSearchProductResult(String srchRsltLoc, String whichRsltToClick, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String replacedString = srchRsltLoc.replace("$", whichRsltToClick);

		BrowserActions.clickOnButton(replacedString, driver, "Search Result");
		Log.trace("Clicked '" + whichRsltToClick + "' Search product from result.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectFromSearchProductResult

	/**
	 * Select the search suggestion from result - DW application can use this
	 * 
	 * @param srchSuggstnRslt
	 *            : String format - ul[class=''] li:nth-child($) a
	 * @param whichSuggstnToClick
	 *            : $ symbol in srchRsltLoc param will be replaced with this string. Ex: "1" - ul[class=''] li:nth-child(1) a
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectFromSearchProductSuggestion(String srchSuggstnRslt, String whichSuggstnToClick, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String replacedString = srchSuggstnRslt.replace("$", whichSuggstnToClick);

		BrowserActions.clickOnButton(replacedString, driver, "Search Suggestion");
		Log.trace("Clicked '" + whichSuggstnToClick + "' Search product from result.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectFromSearchProductSuggestion	

}// Search_Util