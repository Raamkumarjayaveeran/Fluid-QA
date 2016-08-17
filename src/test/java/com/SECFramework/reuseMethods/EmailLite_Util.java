package com.SECFramework.reuseMethods;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Email Sign-Up Functionality for Retail Sites
 * 
 * Also created re-usable methods for DemandWare business flows
 * 
 * Some of the DW methods can be optimized and use for other platform based retail site also
 * 
 * @author harish.subramani
 * 
 */
public class EmailLite_Util {

	/**
	 * Close Email Signup Popup - DemandWare Functionality
	 * 
	 * @param btnClsEmailPopup
	 *            : WebElement for Email Close Button
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void closeEmailSignUpPopup(WebElement btnClsEmailPopup, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnClsEmailPopup, driver, "Email Popup Close");
		Log.trace("Clicked Email Close button on Email Lite Popup.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// closeEmailSignUpPopup

	/**
	 * Can be used to do a Email Signup on Email Lite Popup and on Footer Email Signup - DemandWare Functionality
	 * 
	 * @param txtEmailAdd
	 *            : WebElement for Email Signup Text Field
	 * @param btnSignup
	 *            : WebElement for Email Signup Button
	 * @param emailID
	 *            : Email Address. Either you can provide a email or if you want random email address just pass "random"
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void emailSignup(WebElement txtEmailAdd, WebElement btnSignup, String emailID, WebDriver driver) {

		String emailIDToEnter = "";
		final long startTime = StopWatch.startTime();

		if (emailID.equalsIgnoreCase("random")) {
			XmlTest test = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
			String emailDomain = test.getParameter("webSite").toString().split("_")[1];
			emailIDToEnter = "qatest" + RandomStringUtils.randomNumeric(6).toString() + "@" + emailDomain + ".com";
		}
		else
			emailIDToEnter = emailID;

		BrowserActions.typeOnTextField(txtEmailAdd, emailIDToEnter, driver, "Email ID");
		Log.trace("Text entered in Search Box.", StopWatch.elapsedTime(startTime));

		BrowserActions.clickOnButton(btnSignup, driver, "Email Signup");
		Log.trace("Clicked Search button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// emailSignup

	/**
	 * To get a text from Email Signup Popup
	 * 
	 * @param fromWhichTxtShldExtract
	 *            : WebElement from which Text need to extracted
	 * @param driver
	 *            : WebDriver instance
	 * @return: String - text from Email Lite Popup
	 */
	final public String getTextFromEmailSignup(WebElement fromWhichTxtShldExtract, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String textToReturn = BrowserActions.getText(driver, fromWhichTxtShldExtract, "Email Signup Popup");
		Log.trace("Text extracted from Email Signup Popup - " + textToReturn + ".", StopWatch.elapsedTime(startTime));

		return textToReturn;

	}// getTextFromEmailSignup

}// EmailLite_Util