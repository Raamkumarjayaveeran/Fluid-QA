package com.SECFramework.reuseMethods;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Shipping Page Functionality for Retail Sites
 * 
 * Also created re-usable methods for DemandWare business flows
 * 
 * Some of the DW methods can be optimized and use for other platform based retail site also
 * 
 * @author harish.subramani
 * 
 */
public class Shipping_Page_Util {

	/**
	 * Enter Shipping Details
	 * 
	 * @param shippingDetails
	 *            : HashMap String, String (key,Value) of list of webElement action to be perform <br>
	 * <br>
	 *            Example for Type: key: type_DescriptionOfElement_TextToTypeInTextBox || Value: Actual Locator in CSS Form <br>
	 * <br>
	 *            Example for Click: key: Click_DescriptionOfElement || Value: Actual Locator in CSS Form <br>
	 * <br>
	 *            Example for Select: key: select_DescriptionOfElement_OptionToSelectInOptionCombo || Value: Actual Locator in CSS Form <br>
	 * <br>
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	@SuppressWarnings("rawtypes")
	final public static void enterShippingDetails(LinkedHashMap <String, String> shippingDetails, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		Set shippingDetailsSet = shippingDetails.entrySet();
		Iterator shippingDetailsIterator = shippingDetailsSet.iterator();

		while (shippingDetailsIterator.hasNext()) {

			Map.Entry mapEntry = (Map.Entry) shippingDetailsIterator.next();
			String[] keyWithElementTypeAndDescriptionAndTextToType = mapEntry.getKey().toString().split("_");
			String locator = mapEntry.getValue().toString();
			
			switch (keyWithElementTypeAndDescriptionAndTextToType[0].toLowerCase()) {

				case "type":
					BrowserActions.typeOnTextField(locator, keyWithElementTypeAndDescriptionAndTextToType[2], driver, keyWithElementTypeAndDescriptionAndTextToType[1]);
					break;
				case "click":
					BrowserActions.clickOnButton(locator, driver, keyWithElementTypeAndDescriptionAndTextToType[1]);
					break;
				case "select":
					BrowserActions.selectFromComboBox(locator, keyWithElementTypeAndDescriptionAndTextToType[2], driver, keyWithElementTypeAndDescriptionAndTextToType[1]);
					break;
				default:
					Log.trace("Option not matched - please read Method document to pass correct form of parameter. Try: Type/Click/Select", StopWatch.elapsedTime(startTime));
					break;

			}// Switch

			Utils.waitForPageLoad(driver);

		}// While

	}// enterShippingDetails

	/**
	 * Click Billing Page Button - DW and Non-DW Sites
	 * 
	 * @param btnBillingPage
	 *            : Billing Page Button WebElement
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void clickGoToBillingPage(WebElement btnBillingPage, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnBillingPage, driver, "Billing Page");
		Log.trace("Clicked Billing Page button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// clickGoToBillingPage

	/**
	 * Click Shipping Button/Radio - DW and Non-DW Sites (STS or STH)
	 * 
	 * @param btnShippingType
	 *            : Shipping Button WebElement
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectShippingType(WebElement btnShippingType, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnShippingType, driver, "Shipping Type");
		Log.trace("Clicked Shipping Type button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectShippingType

	/**
	 * Click Shipment Type Button/Radio - DW and Non-DW Sites (Standard, 2 3 Day and Overnight)
	 * 
	 * @param btnShipmentType
	 *            : Shipment Type Button WebElement
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void selectShipmentType(WebElement btnShipmentType, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnShipmentType, driver, "Shipment Type");
		Log.trace("Clicked Shipment Type button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// selectShipmentType
	
	/**
	 * Click Payment Page navigation button - DW and Non-DW Sites (Standard, 2 3 Day and Overnight)
	 * 
	 * @param btnPaymentpage
	 *            : Payment Button WebElement
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void goToPaymentPage(String btnPaymentpage, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnPaymentpage, driver, "Payment Page");
		Log.trace("Clicked Payment Page button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// goToPaymentPage

}// Shipping_Page_Util