package com.puma.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ecom.pages.HomePage;
import com.ecom.pages.ShoppingBagPage;
import com.ecom.support.BaseTest;
import com.ecom.support.DataProviderUtils;
import com.ecom.support.Log;
import com.ecom.support.WebDriverFactory;

public class FluidSample extends BaseTest{
	
	@Test(description = "Sample test", dataProviderClass = DataProviderUtils.class, dataProvider = "multiDataIterator")
	public void sam (String browser, String webSiteWithStakeHolder, String paymentType) throws Exception {

		final WebDriver driver = WebDriverFactory.get(browser, true);
		
		String site = webSiteWithStakeHolder.split("_")[0];
		String stakeHolderName = webSiteWithStakeHolder.split("_")[1];
		
		try {

			HomePage homePage = new HomePage(driver, site).get();
			Log.message("Step 1. Navigated to '" + stakeHolderName + "' Home Page!");
			
			ShoppingBagPage shpgBgPage = homePage.tapOnEmptyBag();
			Log.message("Step 2. Clicking empty bag");	
			
			String m = shpgBgPage.emptyShoppingBagText();
			if (m.equalsIgnoreCase("Oops, Your Shopping Cart Is Empty!\nI Think We Can Help:")){
				Log.message("Step 3. Message got matched with'" + m +"'this!");	
			}
				else
				{
					Log.message("Step 3. Message not got matched with'" + m +"'this!");	
			}
		
		}// try
		catch (Exception e) {
			Log.exception(e, driver);
		}// catch
		finally {
			Log.endTestCase();
			driver.quit();
		}// finally

	}
}