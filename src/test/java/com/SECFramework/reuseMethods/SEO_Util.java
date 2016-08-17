package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;

import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;

/**
 * Re-Usable methods of SEO (Category CMS Override, Product CMS Override, Category Formulaic, Product Formulaic) for Retail Sites
 * 
 * @author harish.subramani
 * 
 */
public class SEO_Util {

	/**
	 * Validate current browser URL with specific set of characters - For DW and Non-DW Applications
	 * 
	 * @param urlShouldContain
	 *            : URL Pattern [Ex:  /womens/accessories/scarves/ or  /product/classic-wrap/22951021.html
	 * @param driver
	 *            : WebDriver Instance
	 * 
	 * @return: Boolean [Current page URL matches with provided URL Pattern]
	 */
	final public static boolean validateURLwithPattern(String urlShouldContain, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		boolean resltToReturn = false;

		if (driver.getCurrentUrl().toLowerCase().contains(urlShouldContain.toLowerCase()))
			resltToReturn = true;

		Log.trace("Validated URL with Pattern.", StopWatch.elapsedTime(startTime));
		return resltToReturn;

	}// validateURLwithPattern

	/**
	 * Validate Page Source whether it having Index text - For DW and Non-DW Applications
	 * 
	 * @param indexToSearch
	 *            : Index text in string format
	 * @param driver
	 *            : WebDriver Instance
	 * @return: Boolean [Page Source having Provided Index]
	 */
	final public static boolean validateIndexInPageSource(String indexToSearch, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		boolean resltToReturn = false;

		if (driver.getPageSource().toLowerCase().contains(indexToSearch.toLowerCase()))
			resltToReturn = true;

		Log.trace("validated Index in Page Source.", StopWatch.elapsedTime(startTime));
		return resltToReturn;

	}// validateIndexInPageSource

	/**
	 * Validate current browser Title. Can be used for Top Category or SubCategories, PDP/QV, CLP. - For DW and Non-DW Applications
	 * 
	 * @param title
	 *            : Page Title [Ex: Brand|Dress, Brand|Jeans|Skinny Fit]
	 * @param driver
	 *            : WebDriver Instance
	 * @return: Boolean [Page Title matches with provided title]
	 */
	final public static boolean validatePageTitle(String title, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		boolean resltToReturn = false;

		if (driver.getTitle().toLowerCase().contains(title.toLowerCase()))
			resltToReturn = true;

		Log.trace("Validated Page Title.", StopWatch.elapsedTime(startTime));
		return resltToReturn;

	}// validatePageTitle

}// SEO_Util
