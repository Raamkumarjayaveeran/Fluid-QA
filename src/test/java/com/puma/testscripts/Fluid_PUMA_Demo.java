package com.puma.testscripts;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecom.pages.CLP_Page;
import com.ecom.pages.CheckoutPage;
import com.ecom.pages.HomePage;
import com.ecom.pages.PDP_Page;
import com.ecom.pages.ShoppingBagPage;
import com.ecom.support.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(EmailReport.class)
public class Fluid_PUMA_Demo extends BaseTest {

	private static String xltestDataWorkBook;
	private static String xltestDataWorkSheet;

	@Test(description = "Fluid-PUMA End To End Scenario", dataProviderClass = DataProviderUtils.class, dataProvider = "multiDataIterator")
	public void tcPUMADemo01(String browser, String webSiteWithStakeHolder, String paymentType) throws Exception {

		Fluid_PUMA_Demo.xltestDataWorkBook = "testdata\\data\\PUMA_PoC.xls";
		Fluid_PUMA_Demo.xltestDataWorkSheet = "PUMA_Demo";

		// Get the web driver instance
		final WebDriver driver = WebDriverFactory.get(browser, true);
		final TestDataExtractor testData = new TestDataExtractor();

		// Loading the test data from excel using the test case id
		testData.setWorkBookName(xltestDataWorkBook);
		testData.setWorkSheet(xltestDataWorkSheet);
		testData.setFilePathMapping(true);
		testData.setTestCaseId(Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase());
		testData.readData();

		String site = webSiteWithStakeHolder.split("_")[0];
		String stakeHolderName = webSiteWithStakeHolder.split("_")[1];
		String[] paymentDetails = paymentType.split("<>");

		ExtentTest extentedReport = extent.startTest("Fluid PoC - PUMA [" + paymentDetails[0] + " || Browser: " + browser + "]", "E2E Scenario: Checkout || Browser: " + browser + ".");
		extentedReport.assignCategory(testData.get("TC_Category") + browser);
		extentedReport.assignAuthor("Aspire Systems");

		Log.testCaseInfo(testData.get("Description") + "<small><b><i>[" + browser + " || " + stakeHolderName.toUpperCase() + " ]</b></i></small>");
		String emailAddress = "qaAutoamtion" + org.apache.commons.lang3.RandomStringUtils.randomNumeric(5).toString() + "@puma.com";
		HashMap <String, String> shippingDetails = new HashMap <String, String>();
		shippingDetails.put("firstname", "QA" + RandomStringUtils.randomNumeric(3).toString());
		shippingDetails.put("lastname", "Test" + RandomStringUtils.randomNumeric(3).toString());
		shippingDetails.put("address", "San Jose");
		shippingDetails.put("streetnumber", "18305");
		shippingDetails.put("zip", "95001");
		shippingDetails.put("city", "Automation");
		shippingDetails.put("email", emailAddress);
		shippingDetails.put("countryCodeFromCombo", "10"); // Italy

		try {

			HomePage homePage = new HomePage(driver, site).get();
			Log.message("Step 1. Navigated to '" + stakeHolderName + "' Home Page!");

			CLP_Page clpPage = homePage.searchProduct(testData.get("SearchKey"));
			Log.message("Step 2. Searched Product SKU: " + testData.get("SearchKey") + "!");

			PDP_Page pdpPage = clpPage.addAvailableItemToCart();
			HashMap <String, String> prdDetails = CLP_Page.prdDetails;
			Log.message("Step 3. Added Item to the Bag [Name: " + prdDetails.get("name") + " | SKU: " + prdDetails.get("sku") + "]");

			ShoppingBagPage shpgBgPage = pdpPage.goToShoppingBagPage();
			Log.message("Step 4. Navigated to Shopping Bag Page!");

			CheckoutPage chkOutPg = shpgBgPage.goToCheckoutPage();
			Log.message("Step 5. Navigated to Checkout Page!");

			chkOutPg.goToCheckoutPage();
			Log.message("Step 6. Navigated to Guest Checkout Page!");

			chkOutPg.enterShippingAddress(shippingDetails);
			Log.message("Step 7. Entered Shipping/Payment Address Information and Proceeded to Payment Page!");

			chkOutPg.selectCCPaymentAndProccedToReviewOrderPage();
			Log.message("Step 8. Selected CC Payment!");
			Log.message("Step 9. Proceeded to Order Review Page!");

			chkOutPg.submitOrder();
			Log.message("Step 10. Submitted Order!");

			String orderNumber = chkOutPg.doPayment(paymentDetails[0], paymentDetails[1], paymentDetails[2], paymentDetails[3], paymentDetails[4]);
			Log.messageWithExtentScreenshot("Step 11. Order Placed [Order Number: " + orderNumber + "]!", driver, extentedReport, true);

			Log.assertThat((chkOutPg.verifyPlacedOrder(prdDetails)), "Step-12: Order Placed Successfully!!", "Test Failed. Order Placed not available in Order Summary Page", driver);
			Log.message("-- Order Info [ Product Name: " + prdDetails.get("name") + " || Product Sales Price: " + prdDetails.get("price") + " || Product SKU: " + prdDetails.get("sku") + " || Payment Type: " + paymentDetails[0] + " || Card #: " + paymentDetails[1] + " ].");

			Log.testCaseResult();
			extentedReport.log(LogStatus.PASS, "Test Passed!");
			extent.endTest(extentedReport);

		}// try
		catch (Exception e) {
			Log.exception(e, driver);
		}// catch
		finally {
			Log.endTestCase();
			driver.quit();
		}// finally

	}// tcPUMADemo01

}// Fluid_PUMA_Demo