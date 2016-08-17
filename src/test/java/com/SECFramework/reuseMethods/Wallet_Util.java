package com.SECFramework.reuseMethods;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
public class Wallet_Util {

	/**
	 * Click on Add Credit card button in wallet page
	 * 
	 * @param addCardButton
	 *            : WebElement to navigate to the Add Credit Card Page
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void clickAddCreditCard(WebElement addCardButton, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(addCardButton, driver, "Add Card Button");
		Log.trace("Clicked Add Card Button.", StopWatch.elapsedTime(startTime));

	}// clickAddCreditCard

	/**
	 * Add a Credit card to the wallet
	 * 
	 * @param addCC
	 *            : HashMap String, String of list of webelement action to be perform <br>
	 *            Example for Type: key: text_DescriptionOfElement_TextToTypeInTextBox || Value: Actual Locator in CSS Form <br>
	 *            Example for Click: key: Click_DescriptionOfElement || Value: Actual Locator in CSS Form <br>
	 *            Example for Select: key: text_DescriptionOfElement_OptionToSelectInOptionCombo || Value: Actual Locator in CSS Form <br>
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 */
	@SuppressWarnings("rawtypes")
	final public static void addCreditCard(HashMap <String, String> addCC, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		Set addCCSet = addCC.entrySet();
		Iterator addCCIterator = addCCSet.iterator();

		while (addCCIterator.hasNext()) {

			Map.Entry mapEntry = (Map.Entry) addCCIterator.next();
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

	}// addCreditCard

	/**
	 * Edit a Credit card to the wallet
	 * 
	 * @param editButton
	 *            : WebElement to navigate to the Edit Credit Card Page
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void editCreditCard(String editButton, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(editButton, driver, "Edit Card Button");
		Log.trace("Clicked Add Card Button to navigate to Add Card page.", StopWatch.elapsedTime(startTime));

	}// editCreditCard

	/**
	 * Delete an existing card
	 * 
	 * @param deleteButton
	 *            : String which has the css with the place holder for card number
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void deleteCard(String deleteButton, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(deleteButton, driver, "Delete Card Button");
		Log.trace("Clicked Add Card Button to navigate to Add Card page.", StopWatch.elapsedTime(startTime));

	}// deleteCard

	/**
	 * Verify whether the Add card button is disabled on reaching the max count of cards to be listed in the page.
	 * 
	 * @param addCardButton
	 *            : String which is the css of the Add Card button
	 * 
	 * @param cardLink
	 *            : String which is the css of the Card links that are listed in the page
	 * 
	 * @param maximumCardsCount
	 *            : Integer which is the expected maximum number of cards that are to be present in the page
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void verifyAddCardButtonDisabledOnReachingCount(String addCardButton, String cardLink, int maximumCardsCount, WebDriver driver) {
		final long startTime = StopWatch.startTime();
		List <WebElement> webElement = driver.findElements(By.cssSelector(cardLink));
		int cardsCount = webElement.size();
		if (cardsCount < maximumCardsCount) {
			Log.trace("The existing number of cards listed in the page has not reached the max count.", StopWatch.elapsedTime(startTime));
		}
		else {

			Assert.assertTrue((!driver.findElement(By.cssSelector(addCardButton)).isEnabled()), "The add card is enabled even on reaching the max cards count.");
		}
		Utils.waitForPageLoad(driver);

	}// verifyAddCardButtonDisabledOnReachingCount

}// Wallet_Util
