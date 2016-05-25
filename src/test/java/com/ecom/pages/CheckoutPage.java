package com.ecom.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import org.testng.SkipException;

import com.ecom.support.*;

/**
 * 
 * @author harish.subramani
 * 
 */
public class CheckoutPage extends LoadableComponent <CheckoutPage> {

	private WebDriver driver;
	private boolean isPageLoaded;

	/**********************************************************************************************
	 ********************************* WebElements of Checkout Page *******************************
	 **********************************************************************************************/

	@FindBy(css = "button[name*='login']")
	WebElement btnMemberLogin;

	@FindBy(css = "button[name*='unregistered']")
	WebElement btnGuestCheckout;

	@FindBy(css = "h1[class='checkout-header login h6']")
	WebElement labelCheckoutHeader;

	@FindBy(css = "label[for='is-PAYMENTOPERATOR_CREDIT']")
	WebElement radioCCPayment;

	@FindBy(css = "button[name*='billing_save']")
	WebElement btnOrderReviewPage;

	@FindBy(css = "button[name*='submit']")
	WebElement btnSubmitOrder;

	@FindBy(css = "select[name='KKName']")
	WebElement selectCCType;

	@FindBy(css = "input[name='KKnr']")
	WebElement txtCCNumber;

	@FindBy(css = "select[name='KKMonth']")
	WebElement selectExpryMonth;

	@FindBy(css = "select[name='KKYear']")
	WebElement selectExpryYear;

	@FindBy(css = "input[name='cccvc']")
	WebElement txtCVCNumber;

	@FindBy(css = "input[value='Confirm']")
	WebElement btnPaymentConfirm;

	@FindBy(css = "iframe[src*='paySSL.aspx']")
	WebElement paymentIFrame;

	@FindBy(css = "div[class*='mini-cart-total'] a[class*='mini-cart']")
	WebElement btnCheckout;

	@FindBy(css = "div[class*='cart-footer'] button[name*='checkoutCart']")
	WebElement btnShoppingBagCheckout;

	/****************************** Placed Order Verification Locators *******************************/

	@FindBy(css = "div[class='h10 name'] a")
	WebElement labelPrdName;

	@FindBy(css = "div[class='attribute sku'] span[class='value']")
	WebElement labelPrdSKU;

	@FindBy(css = "span[class='price-sales']")
	WebElement labelSalesPrice;

	@FindBy(css = "div[class='order-number'] span, div[class='order-number']")
	WebElement labelOrderNumber;

	/****************************** Shipping/Payment Address Locators *******************************/

	String txtZip = "input[id*='zip']";
	String txtCity = "input[id*='city']";
	String txtStreetNo = "input[id*='suite']";
	String txtAddress = "input[id*='address1']";
	String tnLastName = "input[id*='lastName']";
	String txtFirstName = "input[id*='firstName']";
	String countryCombo = "button[data-id*='countries_country']";

	String txtPhoneNUmber = "input[id*='phone']";
	String txtEmail = "input[id*='emailAddress']";
	String txtConfirmEmail = "input[id*='emailConfirm']";
	String btnNxtStepPayment = "button[id='checkout-continue']";
	String cmbxBirthDay = "h1[class='checkout-header login h6']";
	String cmbxBirthYear = "h1[class='checkout-header login h6']";
	String cmbxBirthMonth = "h1[class='checkout-header login h6']";
	String countryOptions = "div[class*='country'][class*='open'] ul[class='dropdown-menu inner selectpicker'] li[rel='$']";

	/**********************************************************************************************
	 ********************************* WebElements of Checkout Page - Ends ************************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, Utils.maxElementWait);
		PageFactory.initElements(finder, this);
	}// PDP_Page

	@Override
	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}

		try {
			isPageLoaded = Utils.waitForElement(driver, btnMemberLogin, 60);
		}
		catch (TimeoutException e) {
			driver.get(driver.getCurrentUrl());
			Utils.waitForPageLoad(driver);
			isPageLoaded = Utils.waitForElement(driver, btnGuestCheckout, 60);
			isPageLoaded = Utils.waitForElement(driver, labelCheckoutHeader, 60);
		}

	}// isLoaded

	@Override
	protected void load() {

		isPageLoaded = true;
		Utils.waitForPageLoad(driver);
		Utils.waitForElement(driver, btnMemberLogin);

	}// load

	/**
	 * Do Guest Checkout Page
	 */
	public void goToCheckoutPage() {

		//final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(btnGuestCheckout, driver, "Product Thumbnail");
		//Log.event("Clicked Guest Checkout button.", StopWatch.elapsedTime(startTime));

	}// goToCheckoutPage

	/**
	 * Enter all the required Shipping / Paymnet Address details and proceed to payment page
	 * 
	 * @param details
	 *            : Refer below Example <br>
	 *            HashMap <String, String> shippingDetails = new HashMap <String, String>(); <br>
	 *            shippingDetails.put("firstname", "QA"); <br>
	 *            shippingDetails.put("lastname", "Test"); <br>
	 *            shippingDetails.put("address", "San Jose");<br>
	 *            shippingDetails.put("streetnumber", "18305"); <br>
	 *            shippingDetails.put("zip", "95001"); <br>
	 *            shippingDetails.put("city", "CityTest"); s<br>
	 *            hippingDetails.put("email", emailAddress); <br>
	 *            shippingDetails.put("countryCodeFromCombo", "10"); //Italy
	 */
	public void enterShippingAddress(HashMap <String, String> details) {

		//final long startTime = StopWatch.startTime();

		LinkedHashMap <String, String> shippingDetails = new LinkedHashMap <String, String>();
		shippingDetails.put("type_FirstName_" + details.get("firstname"), txtFirstName);
		shippingDetails.put("type_LastName_" + details.get("lastname"), tnLastName);
		shippingDetails.put("type_Address_" + details.get("address"), txtAddress);
		shippingDetails.put("type_StreetNumber_" + details.get("streetnumber"), txtStreetNo);
		shippingDetails.put("type_Zip_" + details.get("zip"), txtZip);
		shippingDetails.put("type_City_" + details.get("city"), txtCity);
		shippingDetails.put("type_emailAddress_" + details.get("email"), txtEmail);
		shippingDetails.put("Click_CountryCombo", countryCombo);
		shippingDetails.put("Click_CountryOptions", (countryOptions.replace("$", details.get("countryCodeFromCombo"))));
		shippingDetails.put("type_ConfirmemailAddress_" + details.get("email"), txtConfirmEmail);

		Utils.waitForPageLoad(driver);
		enterShippingDetails(shippingDetails, driver);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 600)", "");

		WebElement test = driver.findElement(By.cssSelector(btnNxtStepPayment));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", test);		
//		BrowserActions.clickOnButton(btnNxtStepPayment, driver, "Payment Page");
		
		//Log.event("Clicked Guest Checkout button.", StopWatch.elapsedTime(startTime));

		if (!(Utils.waitForElement(driver, radioCCPayment, 1))) {
			reEnterShippingAddress(details);
		}

	}// enterShippingAddress

	public void reEnterShippingAddress(HashMap <String, String> details) {

		BrowserActions.clickOnButton(btnCheckout, driver, "Product Thumbnail");
		BrowserActions.clickOnButton(btnShoppingBagCheckout, driver, "Shopping Bag Checkout Button");
		goToCheckoutPage();
		enterShippingAddress(details);

		if (!(Utils.waitForElement(driver, radioCCPayment, 2))) { throw new SkipException("Site not re-directed to Payment Selection Page. May be product went out-of-stock!"); }

	}// reEnterShippingAddress

	/**
	 * Select CC Payment Radio Option
	 */
	public void selectCCPaymentAndProccedToReviewOrderPage() {
		//final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(radioCCPayment, driver, "Credit Card");
		BrowserActions.clickOnButton(btnOrderReviewPage, driver, "Credit Card");
		//Log.event("Clicked CC Radio & Order Review button.", StopWatch.elapsedTime(startTime));
	}// selectCCPaymentAndProccedToReviewOrderPage

	/**
	 * Clicked Submit Order
	 */
	public void submitOrder() {
		//final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(btnSubmitOrder, driver, "Credit Card");
		//Log.event("Clicked Submit Order button.", StopWatch.elapsedTime(startTime));
	}// submitOrder

	/**
	 * Do Payment
	 * 
	 * @param paymentType
	 *            : CC Type : Visa or Mastercard
	 * @param ccNumber
	 *            : CC number
	 * @param expiryMonth
	 *            : Expiry Month
	 * @param expireyYear
	 *            : Expiry Year
	 * @param cvcNumber
	 *            : CVV or CVC Number
	 */
	public String doPayment(String paymentType, String ccNumber, String expiryMonth, String expireyYear, String cvcNumber) {

		//final long startTime = StopWatch.startTime();

		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame(paymentIFrame);

		BrowserActions.selectFromComboBox(selectCCType, paymentType, driver, "Credit Card - " + paymentType);
		//Log.event("Selected CC Payment Type.", StopWatch.elapsedTime(startTime));

		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame(paymentIFrame);

		BrowserActions.typeOnTextField(txtCCNumber, ccNumber, driver, "CC/GC");
		//Log.event("Entered CC Number.", StopWatch.elapsedTime(startTime));

		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame(paymentIFrame);

		BrowserActions.selectFromComboBox(selectExpryMonth, expiryMonth, driver, "Credit Card - " + expiryMonth);
		//Log.event("Selected CC Expiry Month.", StopWatch.elapsedTime(startTime));

		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame(paymentIFrame);

		BrowserActions.selectFromComboBox(selectExpryYear, expireyYear, driver, "Credit Card - " + expireyYear);
		//Log.event("Selected CC Expirey Year.", StopWatch.elapsedTime(startTime));

		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame(paymentIFrame);

		BrowserActions.typeOnTextField(txtCVCNumber, cvcNumber, driver, "CVC");
		//Log.event("Enterd CVC Number.", StopWatch.elapsedTime(startTime));

		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame(paymentIFrame);

		BrowserActions.clickOnButton(btnPaymentConfirm, driver, "Credit Card");
		//Log.event("Clicked Payment Confirm Button.", StopWatch.elapsedTime(startTime));

		return BrowserActions.getText(driver, labelOrderNumber, "Paymet Page");

	}// doPayment

	public boolean verifyPlacedOrder(HashMap <String, String> prdDetails) {
		boolean returnValue = false;

		try {
			boolean prdName = (labelPrdName.getText().toLowerCase().trim().equals(prdDetails.get("name").toLowerCase()));
			boolean productSKU = (labelPrdSKU.getText().toLowerCase().trim().equals(prdDetails.get("sku").toLowerCase()));
			boolean productSalesPrice = (labelSalesPrice.getText().toLowerCase().trim().equals(prdDetails.get("price").toLowerCase()));

			if (prdName && productSKU && productSalesPrice)
				returnValue = true;
		}
		catch (NoSuchElementException e) {
		}

		return returnValue;
	}// verifyAddedItemOnInvoicePage

	@SuppressWarnings("rawtypes")
	final public static void enterShippingDetails(LinkedHashMap <String, String> shippingDetails, WebDriver driver) {

		//final long startTime = StopWatch.startTime();

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
					//Log.trace("Option not matched - please read Method document to pass correct form of parameter. Try: Type/Click/Select", StopWatch.elapsedTime(startTime));
					break;

			}// Switch

			Utils.waitForPageLoad(driver);

		}// While

	}// enterShippingDetails

}// ShoppingBagPage