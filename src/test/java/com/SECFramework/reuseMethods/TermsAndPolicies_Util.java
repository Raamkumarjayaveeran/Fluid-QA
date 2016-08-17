package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Terms and Policies Functionality for Retail Sites
 * 
 * Also created re-usable methods for DemandWare business flows
 * 
 * Some of the DW methods can be optimized and use for other platform based retail site also
 * 
 * @author sudharsan.srinivasan
 * 
 */
public class TermsAndPolicies_Util {

	/**
	 * Verify Policy Statements listed in the Policies Page
	 * 
	 * @param policyLink
	 *            : WebElement to navigate to the Policies page
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void verifyPolicyStatement(WebElement policyLink, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(policyLink, driver, "Policies Link");
		Log.trace("Clicked Policies link.", StopWatch.elapsedTime(startTime));
		Utils.waitForPageLoad(driver);

	}// verifyPolicyStatement

	/**
	 * Verify Term Statements listed in the Terms Page
	 * 
	 * @param termsLink
	 *            : WebElement to navigate to the Terms page
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void verifyTerms(WebElement termsLink, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(termsLink, driver, "Terms Link");
		Log.trace("Clicked Terms link to navigate to Policies page.", StopWatch.elapsedTime(startTime));
		Utils.waitForPageLoad(driver);

	}// verifyTerms

}// TermsAndPolicies_Util
