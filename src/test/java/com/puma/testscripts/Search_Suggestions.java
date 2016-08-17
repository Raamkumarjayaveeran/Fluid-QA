package com.puma.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ecom.pages.HomePage;
import com.ecom.support.*;



public class Search_Suggestions extends BaseTest{
	
	private static String xltestDataWorkBook;
	private static String xltestDataWorkSheet;
	
	@Test(description = "Search suggestion links", dataProviderClass = DataProviderUtils.class, dataProvider = "multiDataIterator")
	public void searchSuggestionLinks(String browser, String webSiteWithStakeHolder) throws Exception {

		Search_Suggestions.xltestDataWorkBook = "testdata\\data\\PUMA_PoC.xls";
		Search_Suggestions.xltestDataWorkSheet = "PUMA_Demo";
		
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
				try {

					HomePage homePage = new HomePage(driver, site).get();
					Log.message("Step 1. Navigated to '" + stakeHolderName + "' Home Page!");
					
				    homePage.typeOnSearchField(testData.get("SearchKey"));
					Log.message("Step 2. Searched Product SKU: " + testData.get("SearchKey") + "!");
				}
				catch (Exception e) {
					Log.exception(e, driver);
				}// catch
				finally {
					Log.endTestCase();
					driver.quit();
				}// finally				
	}

}
