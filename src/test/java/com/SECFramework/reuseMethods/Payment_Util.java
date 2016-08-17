package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Payment Functionality for Retail Sites
 * 
 * Also created re-usable methods for DemandWare business flows
 * 
 * Some of the DW methods can be optimized and use for other platform based retail site also
 * 
 * @author harish.subramani
 * 
 */
public class Payment_Util {

	/**
	 * Click Paypal Button/Radio - DW and Non-DW Sites
	 * 
	 * @param btnPaypal
	 *            : Paypal Button WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectPaypalPayment(WebElement btnPaypal, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnPaypal, driver, "Paypal");
		Log.trace("Clicked Paypal button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectPaypalPayment

	/**
	 * Click Credit Card Button - DW and Non-DW Sites
	 * 
	 * This method can be used to click specific type of CC type like Visa, MasterCard, AMEX... This option for Non-DW site
	 * 
	 * @param btnCreditCard
	 *            : Credit Card Button WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void clickCreditCardPayment(WebElement btnCreditCard, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnCreditCard, driver, "Credit Card");
		Log.trace("Clicked Credit Card button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// clickCreditCardPayment

	/**
	 * Select Credit Card option from ComboBox - DW and Non-DW Sites [Can be used for Expiry Month and year selection]
	 * 
	 * This method can be used to click specific type of CC type like Visa, MasterCard, AMEX... This option for Non-DW site
	 * 
	 * @param btnCreditCard
	 *            : Credit Card Button WebElement
	 * @param optToSelect
	 *            : Option to select from combobox
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectCreditCardPaymentAndExpiryYrMonth(WebElement btnCreditCard, String optToSelect, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.selectFromComboBox(btnCreditCard, optToSelect, driver, "Credit Card - " + optToSelect);
		Log.trace("Selected " + "Credit Card - " + optToSelect + ".", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectCreditCardPayment

	/**
	 * Enter CC/GC/Brand Card Number - DW and Non-DW Sites
	 * 
	 * @param txtCCNumber
	 *            : CC/GC/Brand Card WebElement
	 * @param ccNumber
	 *            : CC/GC/Brand Number
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void enterCCNumber(WebElement txtCCNumber, String ccNumber, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.typeOnTextField(txtCCNumber, ccNumber, driver, "CC/GC");
		Log.trace("Text entered in CC/GC Box.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// enterCCNumber

	/**
	 * Enter CVC or CVV number
	 * 
	 * @param txtCVCNumber
	 *            : CVC or CVV WebElement
	 * @param cvcNumber
	 *            : CVV Number
	 * @param driver
	 *            : Webdriver Instance
	 */
	final public static void enterCVCNumber(WebElement txtCVCNumber, String cvcNumber, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.typeOnTextField(txtCVCNumber, cvcNumber, driver, "CVC");
		Log.trace("Text entered in CVC Box.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// enterCCNumber

	/**
	 * Click Pay Button - DW and Non-DW Sites
	 * 
	 * @param btnPay
	 *            : Pay Button WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void clickPayButton(WebElement btnPay, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnPay, driver, "Pay");
		Log.trace("Clicked Pay button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// clickPayButton

	/**
	 * Select Paypal and Click Proceed to Paypal Login Page Button - For DW
	 * 
	 * @param btnPaypal
	 *            : Paypal Radio WebElement
	 * @param btnProceedToPaypalPage
	 *            : ProceedToPaypalPage WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void proceedToPaypalPortal(WebElement btnPaypal, WebElement btnProceedToPaypalPage, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		selectPaypalPayment(btnPaypal, driver);
		BrowserActions.clickOnButton(btnProceedToPaypalPage, driver, "Proceed To Paypal Page");
		Log.trace("Clicked Proceed To Paypal Page button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// proceedToPaypalPortal

	/**
	 * Do Credit Card Payment by selecting CC Type, Entering CC Number and Click on Pay Button
	 * 
	 * @param btnCreditCard
	 *            : CC WebElement
	 * @param optToSelect
	 *            : CC Option to select
	 * @param txtCCNumber
	 *            : CC NUmber WebElement
	 * @param ccNumber
	 *            :CC NUmber
	 * @param btnPay
	 *            : Pay Button WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void doCreditCardPayment(WebElement btnCreditCard, String optToSelect, WebElement txtCCNumber, String ccNumber, WebElement btnPay, WebElement expryMonth, WebElement expryYear, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		selectCreditCardPaymentAndExpiryYrMonth(btnCreditCard, optToSelect, driver);
		clickCreditCardPayment(btnCreditCard, driver);

		clickPayButton(btnPay, driver);
		Log.trace("Done Credit Card Payment.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// doCreditCardPayment

	/**
	 * To get a text from Paymet Page
	 * 
	 * @param fromWhichTxtShldExtract
	 *            : WebElement from which Text need to extracted
	 * @param driver
	 *            : WebDriver instance
	 * @return: String - text from Paymet Page
	 */
	final public String getTextFromPaymetPage(WebElement fromWhichTxtShldExtract, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String textToReturn = BrowserActions.getText(driver, fromWhichTxtShldExtract, "Paymet Page");
		Log.trace("Text extracted from Paymet Page - " + textToReturn + ".", StopWatch.elapsedTime(startTime));

		return textToReturn;

	}// getTextFromPaymetPage

	/**
	 * proceed to Order Review Page
	 * 
	 * @param btnOrdrReviewPg
	 *            : Order Review Button Webelement
	 * @param driver
	 *            : Webdriver Instance
	 */
	final public static void proceedToOrderReviewPage(WebElement btnOrdrReviewPg, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnOrdrReviewPg, driver, "Credit Card");
		Log.trace("Clicked Order Review button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// proceedToOrderReviewPage

	/**
	 * Click Submit Order
	 * 
	 * @param btnSubmitOrder
	 *            : Submit Order Button WebElement
	 * @param driver
	 *            : Webdriver Instance
	 */
	final public static void submitOrder(WebElement btnSubmitOrder, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnSubmitOrder, driver, "Credit Card");
		Log.trace("Clicked Submit Order button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// submitOrder

	/**
	 * To get a text from Payment Page
	 * 
	 * @param fromWhichTxtShldExtract
	 *            : WebElement from which Text need to extracted
	 * @param driver
	 *            : WebDriver instance
	 * 
	 * @return: String - text from Wishlist Page
	 */
	final public static String getTextFromPaymentPage(WebElement fromWhichTxtShldExtract, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String textToReturn = BrowserActions.getText(driver, fromWhichTxtShldExtract, "Payment Page");
		Log.trace("Text extracted", StopWatch.elapsedTime(startTime));

		return textToReturn;

	}// getTextFromPaymentPage

}// Payment_Util