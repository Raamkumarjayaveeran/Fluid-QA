package com.SECFramework.reuseMethods;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;

public class InternationalShipping_Util {
	
	/**
	 * @param changeCountryLink
	 *            : String which is the css for the Change Country Link
	 * @param CountryToBeSelected
	 *            : String which is the country to be selected
	 * @param selectCountrySelectBox
	 *            : String which is the css of the select box which selects the country
	 * @param submitButton
	 *            : String which is the css of the Redeem Points button.
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void changeCountry(String changeCountryLink, String countryToBeSelected, String selectCountrySelectBox, String submitButton, WebDriver driver) {
		clickChangeCountryLink(changeCountryLink, driver);
		selectCountry(selectCountrySelectBox, countryToBeSelected, driver);
		clickSubmitButton(submitButton, driver);
	}// changeCountry

	/**
	 * @param changeCurrencyLink
	 *            : String which is the css for the Change Currency Link
	 * @param currencyToBeSelected
	 *            : String which is the Currency to be selected
	 * @param selectCurrencySelectBox
	 *            : String which is the css of the select box which selects the Currency
	 * @param submitButton
	 *            : String which is the css of the Submit button.
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void updateShippingAddress(String changeCurrencyLink, String currencyToBeSelected, String selectCurrencySelectBox, String submitButton, WebDriver driver) {
		clickChangeShippingAddress(changeCurrencyLink, driver);
		selectCountry(selectCurrencySelectBox, currencyToBeSelected, driver);
		clickSubmitButton(submitButton, driver);
	}// changeCurrency

	/**
	 * @param changeShippingAddress
	 *            : String which is the css of the Change Shipping Address Link
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void clickChangeShippingAddress(String changeShippingAddress, WebDriver driver) {
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(changeShippingAddress, driver, "Change Country Link");
		Log.trace("Clicked on the Change Shipping Address link", StopWatch.elapsedTime(startTime));
	}// clickChangeShippingAddress

	/**
	 * @param address
	 *            : HashMap which has the css of the element as the key and the value as the value to be entered in the element
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void modifyShippingAddress(HashMap <String, String> address, WebDriver driver) {
		Set <Entry <String, String>> mapSet = address.entrySet();
		Iterator <Entry <String, String>> mapIterator = mapSet.iterator();
		while (mapIterator.hasNext()) {
			Entry <String, String> mapEntry = mapIterator.next();
			String keyValue = mapEntry.getKey();
			String value = mapEntry.getValue();
			BrowserActions.typeOnTextField(value, keyValue, driver, "Type the value in the Element keyValue");
		}
	}// modifyShippingAddress

	/**
	 * @param changeCountryLink
	 *            : String which is the css of the Change Country Link
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void clickChangeCountryLink(String changeCountryLink, WebDriver driver) {
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(changeCountryLink, driver, "Change Country Link");
		Log.trace("Clicked on the Change Country link", StopWatch.elapsedTime(startTime));
	}// changeCountryLink

	/**
	 * @param selectCountrySelectBox
	 *            : String which is the css of the Select Country Combo box
	 * 
	 * @param countryToBeSelected
	 *            : String which is the country to be selected
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void selectCountry(String selectCountrySelectBox, String countryToBeSelected, WebDriver driver) {
		final long startTime = StopWatch.startTime();
		BrowserActions.selectFromComboBox(selectCountrySelectBox, countryToBeSelected, driver, "Select Country Select Box");
		Log.trace("Selected the country from the Select Country Select Box", StopWatch.elapsedTime(startTime));
	}// selectCountry

	/**
	 * @param submitButton
	 *            : String which is the css of the Submit Button
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void clickSubmitButton(String submitButton, WebDriver driver) {
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(submitButton, driver, "Submit Button");
		Log.trace("Clicked on the Submit Button", StopWatch.elapsedTime(startTime));
	}// clickSubmitButton

	/**
	 * @param selectCurrencySelectBox
	 *            : String which is the css of the Select Country Combo box
	 * 
	 * @param countryToBeSelected
	 *            : String which is the country to be selected
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void selectCurrency(String selectCurrencySelectBox, String currencyToBeSelected, WebDriver driver) {
		final long startTime = StopWatch.startTime();
		BrowserActions.selectFromComboBox(selectCurrencySelectBox, currencyToBeSelected, driver, "Select Currency Select Box");
		Log.trace("Selected the Currency from the Select Currency Select Box", StopWatch.elapsedTime(startTime));
	}// selectCurrency
	
}//InternationalShipping_Util
