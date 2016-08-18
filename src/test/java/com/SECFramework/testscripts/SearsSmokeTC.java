package com.SECFramework.testscripts;

import java.util.HashMap;
import java.util.LinkedHashMap;                     

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SECFramework.pages.HomePage;
import com.SECFramework.pages.MyAccountPage;
import com.SECFramework.pages.PLP_Page;
import com.SECFramework.support.*;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(EmailReport.class)
public class SearsSmokeTC extends BaseTest {

	private static String xltestDataWorkBook;
	private static String xltestDataWorkSheet;

	
	@Test(description = "Add to Cart", dataProviderClass = DataProviderUtils.class, dataProvider = "multiBrowserWebsites")
	public void tcAddToCart(String browser, String webSiteWithStakeHolder)throws Exception {

		SearsSmokeTC.xltestDataWorkBook  = "testdata\\data\\Sears.xls";
		SearsSmokeTC.xltestDataWorkSheet = "smoketest_cases";

		// Get the web driver instance
		final WebDriver driver = WebDriverFactory.get(browser, true);
		final TestDataExtractor testData = new TestDataExtractor();

		// Loading the test data from excel using the test case id
		testData.setWorkBookName(xltestDataWorkBook);
		testData.setWorkSheet(xltestDataWorkSheet);
		testData.setFilePathMapping(true);
		testData.setTestCaseId(Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase());
		testData.readData();
		
		String site = webSiteWithStakeHolder;
		String stakeHolderName = webSiteWithStakeHolder.split("-")[2];

		ExtentTest extentedReport = extent.startTest("Account Creation "+ "|| Browser: " + browser+ "Regression Scenario: Account Creation|| Browser: " + browser+ ".");
		extentedReport.assignCategory(testData.get("TC_Category") + browser);
		extentedReport.assignAuthor("Aspire Systems");

		Log.testCaseInfo(testData.get("Description") + "<small><b><i>["+ browser + " || " + stakeHolderName.toUpperCase()+ " ]</b></i></small>");
		
		try {

			HomePage homePage = new HomePage(driver, site).get();
			Log.message("Step 1. Navigated to '" + stakeHolderName+ "' Home Page!");
			
			PLP_Page plppage = homePage.searchProduct(testData.get("SearchKey"));
			Log.message("Step 2. Searched Product SKU: " + testData.get("SearchKey") + "!");
			
			plppage.addtobag();
			Log.message("Step 3. product added to bag: ");
			
		}// try
		catch (Exception e) {
			Log.exception(e, driver);
		}// catch
		finally {
			//Log.endTestCase();
			driver.quit();
		}// finally

	}// tcAddToCart
	@Test(description = "Account creation", dataProviderClass = DataProviderUtils.class, dataProvider = "multiBrowserWebsites")
	public void tcAccountCreation(String browser, String webSiteWithStakeHolder)throws Exception {

		SearsSmokeTC.xltestDataWorkBook  = "testdata\\data\\Sears.xls";
		SearsSmokeTC.xltestDataWorkSheet = "USER_Details";

		// Get the web driver instance
		final WebDriver driver = WebDriverFactory.get(browser, true);
		final TestDataExtractor testData = new TestDataExtractor();

		// Loading the test data from excel using the test case id
		testData.setWorkBookName(xltestDataWorkBook);
		testData.setWorkSheet(xltestDataWorkSheet);
		testData.setFilePathMapping(true);
		testData.setTestCaseId(Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase());
		testData.readData();
		
		String site = webSiteWithStakeHolder;
		String stakeHolderName = webSiteWithStakeHolder.split("-")[2];

		ExtentTest extentedReport = extent.startTest("Account Creation "+ "|| Browser: " + browser+ "Regression Scenario: Account Creation|| Browser: " + browser+ ".");
		extentedReport.assignCategory(testData.get("TC_Category") + browser);
		extentedReport.assignAuthor("Aspire Systems");

		final String emailAddress = "qaAutomation"+ org.apache.commons.lang3.RandomStringUtils.randomNumeric(5).toString() + "@puma.com";
		
		HashMap<String, String> accountDetails = new LinkedHashMap<String, String>();
		accountDetails.put("firstname", testData.get("Firstname"));
		accountDetails.put("lastname", testData.get("Lastname"));
		accountDetails.put("email", emailAddress);
		accountDetails.put("confirmemail", emailAddress);
		accountDetails.put("password", testData.get("Password"));
		accountDetails.put("confirmpassword", testData.get("ConfirmPassword"));

		Log.testCaseInfo(testData.get("Description") + "<small><b><i>["+ browser + " || " + stakeHolderName.toUpperCase()+ " ]</b></i></small>");
		
		try {

			HomePage homePage = new HomePage(driver, site).get();
			Log.message("Step 1. Navigated to '" + stakeHolderName+ "' Home Page!");

			homePage.clickSignIn();
			Log.assertThat(true, "Step 2. My account pop up displayed", "My Account pop up is not displayed", driver);
			
			MyAccountPage accountPage = homePage.clickRegister();
			Log.assertThat(true, "Step 3. Navigated to account creation page!", "Step 3.create Account page not displayed", driver);
				
			accountPage.createAccount(accountDetails);
			Log.assertThatExtentReport(true,"Step 4.Account has been successfully created!", "Step 4.Account creation Fails!", driver);
			
		}// try
		catch (Exception e) {
			Log.exception(e, driver);
		}// catch
		finally {
			//Log.endTestCase();
			driver.quit();
		}// finally

	}// tcAccountCreation
}