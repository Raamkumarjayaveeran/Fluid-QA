package com.SECFramework.reuseMethods;

import org.openqa.selenium.WebDriver;

import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;

public class RewardPoints_Util {	

	/**
	 * @param redeemPointsLink
	 * 			  : String which is the css of the Redeem Points Link
	 * 
	 * @param redeemPointsTextBox
	 * 			  : String which is the css of the Text Box in which the Points that are to be redeemed are mentioned.
	 * 
	 * @param redeemPointsButton
	 * 			  : String which is the css of the Redeem Points Button
	 * 
	 * @param points
	 * 			  : Integer which is the number of points which the user wishes to redeem
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void redeemPoints(String redeemPointsLink, String redeemPointsTextBox, String redeemPointsButton, String points, WebDriver driver){
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(redeemPointsLink, driver, "Redeem Points Link");
		Log.trace("Clicked on the Redeem Points link", StopWatch.elapsedTime(startTime));
		BrowserActions.typeOnTextField(redeemPointsTextBox, points, driver, "Redeem Points Text Box");
		Log.trace("Entered the points in the Redeem Points Text Box.", StopWatch.elapsedTime(startTime));
		BrowserActions.clickOnButton(redeemPointsButton, driver, "Redeem Points Button");
		Log.trace("Clicked on the Redeem Points Button", StopWatch.elapsedTime(startTime));
	}//redeemPoints

	/**
	 * Verify Reward Points
	 * 
	 * @param viewRewardPointsLink
	 *            : String which is the View Rewards Point Link.
	 *            
	 * @param rewardPointsText
	 * 			  : String which is the css of the actual Reward Points Text
	 * 
	 * @param expectedRewardPoints
	 * 			  : String which is the expected Reward Points
	 * 
	 * @param driver
	 *            : WebDriver instance
	 */
	final public static void verifyRewardPoints(String viewRewardPointsLink, String rewardPointsText, String expectedRewardPoints, WebDriver driver) {
		final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(viewRewardPointsLink, driver, "cardToBeRemoved");
		Log.trace("Clicked on the view Reward Points link", StopWatch.elapsedTime(startTime));

	}// verifyRewardPoints
	
}//InternationalShipping_Util
