package com.SECFramework.reuseMethods;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Account Page Functionality for Retail Sites
 * 
 * Also created re-usable methods for DemandWare business flows
 * 
 * Some of the DW methods can be optimized and use for other platform based retail site also
 * 
 * @author harish.subramani
 * 
 */
public class Account_Util {

	/**
	 * Use this method to do all kind of Account related operations like Account Creation, Edit created address, Add Address etc.. <br>
	 * 
	 * - DW and Non DW Application
	 * 
	 * @param accountDetails
	 *            : Like Username, password, address etc.. : HashMap String, String (key,Value) of list of webElement action to be perform <br>
	 * <br>
	 *            Example for Type: key: text_DescriptionOfElement_TextToTypeInTextBox || Value: Actual Locator in CSS Form <br>
	 * <br>
	 *            Example for Click: key: Click_DescriptionOfElement || Value: Actual Locator in CSS Form <br>
	 * <br>
	 *            Example for Select: key: text_DescriptionOfElement_OptionToSelectInOptionCombo || Value: Actual Locator in CSS Form <br>
	 * <br>
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	@SuppressWarnings("rawtypes")
	final public static void doAccountOperations(HashMap <String, String> accountDetails, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		Set accountDetailsSet = accountDetails.entrySet();
		Iterator accountDetailsIterator = accountDetailsSet.iterator();

		while (accountDetailsIterator.hasNext()) {

			Map.Entry mapEntry = (Map.Entry) accountDetailsIterator.next();
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

	}// doAccountOperations

}// Account_Util