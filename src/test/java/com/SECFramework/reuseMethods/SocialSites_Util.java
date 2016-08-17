package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Social Sites navigation Functionality for Retail Sites -
 * 
 * FB, Instagram, Pinterest, Twitter, Youtube, Tumblr and GooglePlus
 * 
 * @author harish.subramani
 * 
 */
public class SocialSites_Util {

	/**
	 * Navigate to FB Circle/Share on FB - On QV/PDP/CLP/Home
	 * 
	 * @param btnFaceBook
	 *            : WebElement for FB Button
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void navigateToFaceBook(WebElement btnFaceBook, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnFaceBook, driver, "Facebook");
		Log.trace("Clicked FB Button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// navigateToFaceBook

	/**
	 * Navigate to Instagram Circle/Share on Instagram - On QV/PDP/CLP/Home
	 * 
	 * @param btnInstagram
	 *            : WebElement for Instagram Button
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void navigateToInstagram(WebElement btnInstagram, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnInstagram, driver, "Instagram");
		Log.trace("Clicked Instagram Button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// navigateToInstagram

	/**
	 * Navigate to Pinterest Circle/Share on Pinterest - On QV/PDP/CLP/Home
	 * 
	 * @param btnPinterest
	 *            : WebElement for Pinterest Button
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void navigateToPinterest(WebElement btnPinterest, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnPinterest, driver, "Pinterest");
		Log.trace("Clicked Pinterest Button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// navigateToPinterest

	/**
	 * Navigate to Twitter Circle/Share on Twitter - On QV/PDP/CLP/Home
	 * 
	 * @param btnTwitter
	 *            : WebElement for Twitter Button
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void navigateToTwitter(WebElement btnTwitter, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnTwitter, driver, "Twitter");
		Log.trace("Clicked Twitter Button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// navigateToTwitter

	/**
	 * Navigate to Youtube Circle/Share on Youtube - On QV/PDP/CLP/Home
	 * 
	 * @param btnYoutube
	 *            : WebElement for Youtube Button
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void navigateToYoutube(WebElement btnYoutube, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnYoutube, driver, "YouTube");
		Log.trace("Clicked Youtube Button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// navigateToYoutube

	/**
	 * Navigate to Tumblr Circle/Share on Tumblr - On QV/PDP/CLP/Home
	 * 
	 * @param btnTumblr
	 *            : WebElement for Tumblr Button
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void navigateToTumblr(WebElement btnTumblr, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnTumblr, driver, "Tumblr");
		Log.trace("Clicked Tumblr Button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// navigateToTumblr

	/**
	 * Navigate to GooglePlus Circle/Share on GooglePlus - On QV/PDP/CLP/Home
	 * 
	 * @param btnGooglePlus
	 *            : WebElement for GooglePlus Button
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void navigateToGooglePlus(WebElement btnGooglePlus, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnGooglePlus, driver, "Google Plus");
		Log.trace("Clicked GooglePlus Button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// navigateToGooglePlus

}// SocialSites_Util