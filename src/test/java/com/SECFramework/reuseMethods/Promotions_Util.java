package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;
import com.SECFramework.support.Utils;

/**
 * Re-Usable methods of Promotion for Retail Sites
 * 
 * @author harish.subramani
 * 
 */
public class Promotions_Util {

	/**
	 * Apply Promotion after expanding the combo box - DW and Non DW Application
	 * 
	 * @param btnexpndMenu
	 *            : Expand Menu WebElement
	 * @param txtPromotion
	 *            : Promotion Text Box WebElement
	 * @param promoCode
	 *            : Promo Code (Ex: "HS100")
	 * @param btnApplyPromo
	 *            : Apply Promotion Button
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void applyPromotionWithExpandMenu(WebElement btnexpndMenu, WebElement txtPromotion, String promoCode, WebElement btnApplyPromo, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnexpndMenu, driver, "Promo Expand");
		Log.trace("Clicked Promotion Expand button.", StopWatch.elapsedTime(startTime));

		BrowserActions.typeOnTextField(txtPromotion, promoCode, driver, "Promotion");
		Log.trace("Promotion entered.", StopWatch.elapsedTime(startTime));

		BrowserActions.clickOnButton(btnApplyPromo, driver, "Apply Promotion");
		Log.trace("Clicked Apply Promo button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// applyPromotionWithExpandMenu

	/**
	 * Apply Promotion after expanding the combo box - DW and Non DW Application
	 * 
	 * @param btnexpndMenu
	 *            : Expand Menu WebElement
	 * @param txtPromotion
	 *            : Promotion Text Box WebElement
	 * @param promoCodes
	 *            : List of Promo Code that need to be applied (Ex: "HS100,TAXFREE100")
	 * @param btnApplyPromo
	 *            : Apply Promotion Button
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void applyMulitplePromotionWithExpandMenu(WebElement btnexpndMenu, WebElement txtPromotion, String promoCodes, WebElement btnApplyPromo, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String promoCode[] = promoCodes.split(",");

		for (int i = 0; i < promoCode.length; i++) {

			BrowserActions.clickOnButton(btnexpndMenu, driver, "Promo Expand");
			Log.trace("Clicked Promotion Expand button.", StopWatch.elapsedTime(startTime));

			BrowserActions.typeOnTextField(txtPromotion, promoCode[i], driver, "Promotion");
			Log.trace("Promotion entered - " + promoCode[i] + ".", StopWatch.elapsedTime(startTime));

			BrowserActions.clickOnButton(btnApplyPromo, driver, "Apply Promotion");
			Log.trace("Clicked Apply Promo button.", StopWatch.elapsedTime(startTime));

			Utils.waitForPageLoad(driver);

		}

		Log.trace("Applied mulitple Promotion", StopWatch.elapsedTime(startTime));

	}// applyMulitplePromotionWithExpandMenu

	/**
	 * Apply Promotion - DW and Non DW Application
	 * 
	 * @param txtPromotion
	 *            : Promotion Text Box WebElement
	 * @param promoCode
	 *            : Promo Code (Ex: "HS100")
	 * @param btnApplyPromo
	 *            : Apply Promotion Button
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void applyPromotionWithoutExpandMenu(WebElement txtPromotion, String promoCode, WebElement btnApplyPromo, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.typeOnTextField(txtPromotion, promoCode, driver, "Promotion");
		Log.trace("Promotion entered.", StopWatch.elapsedTime(startTime));

		BrowserActions.clickOnButton(btnApplyPromo, driver, "Apply Promotion");
		Log.trace("Clicked Apply Promo button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// applyPromotionWithoutExpandMenu

	/**
	 * Apply Mulitple Promotion - DW and Non DW Application
	 * 
	 * @param txtPromotion
	 *            : Promotion Text Box WebElement
	 * @param promoCodes
	 *            : List of Promo Code that need to be applied (Ex: "HS100,TAXFREE100")
	 * @param btnApplyPromo
	 *            : Apply Promotion Button
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void applyMultiplePromotionWithoutExpandMenu(WebElement txtPromotion, String promoCodes, WebElement btnApplyPromo, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String promoCode[] = promoCodes.split(",");

		for (int i = 0; i < promoCode.length; i++) {

			BrowserActions.typeOnTextField(txtPromotion, promoCode[i], driver, "Promotion");
			Log.trace("Promotion entered - " + promoCode[i] + ".", StopWatch.elapsedTime(startTime));

			BrowserActions.clickOnButton(btnApplyPromo, driver, "Apply Promotion");
			Log.trace("Clicked Apply Promo button.", StopWatch.elapsedTime(startTime));

			Utils.waitForPageLoad(driver);

		}

		Log.trace("Applied mulitple Promotion", StopWatch.elapsedTime(startTime));

	}// applyMultiplePromotionWithoutExpandMenu

	/**
	 * Delete Applied Promotion
	 * 
	 * @param btnPromoDel
	 *            : Promotion Delete WebElement
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void deletePromotion(WebElement btnPromoDel, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		BrowserActions.clickOnButton(btnPromoDel, driver, "Promotion Delete");
		Log.trace("Clicked Delete 'X' Promo button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// deletePromotion

	/**
	 * Delete desired promotion
	 * 
	 * @param btnPromoDel
	 *            : Promotion Delete String [CSS Selector]
	 * @param promoPosition
	 *            : $ symbol in btnPromoDel param will be replaced with this string. Ex: "1" - ul[class=''] li:nth-child(1) a
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void deletePromotionAtPosition(String btnPromoDel, String promoPosition, WebDriver driver) {

		final long startTime = StopWatch.startTime();
		String replacedString = btnPromoDel.replace("$", promoPosition);

		BrowserActions.clickOnButton(replacedString, driver, "Promotion Delete");
		Log.trace("Clicked Delete 'X' Promo button.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// deletePromotion

	/**
	 * Delete desired number of promotions
	 * 
	 * @param btnPromoDel
	 *            : Promotion Delete String
	 * @param promoCountToDelete
	 *            : Number of promotions to delete
	 * @param driver
	 *            : WebDriver Instance
	 */
	final public static void deleteMulitplePromotion(WebElement btnPromoDel, int promoCountToDelete, WebDriver driver) {

		final long startTime = StopWatch.startTime();

		for (int i = 0; i < promoCountToDelete; i++) {

			BrowserActions.clickOnButton(btnPromoDel, driver, "Promotion Delete");
			Log.trace("Clicked Delete 'X' Promo button.", StopWatch.elapsedTime(startTime));

		}

		Log.trace("Deleted '" + promoCountToDelete + "' Promotions.", StopWatch.elapsedTime(startTime));

		Utils.waitForPageLoad(driver);

	}// deleteMulitplePromotion

}// Promotions_Util