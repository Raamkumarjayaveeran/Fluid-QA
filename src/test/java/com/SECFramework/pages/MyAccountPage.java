package com.SECFramework.pages;

import java.util.HashMap;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.SECFramework.reuseMethods.Account_Util;
import com.SECFramework.support.BrowserActions;
import com.SECFramework.support.Utils;



public class MyAccountPage extends LoadableComponent<MyAccountPage> {

	private WebDriver driver;
	private boolean isPageLoaded;
	private static final String INPUT_ID = "input[id='";
	public static HashMap<String, String> prdDetails = new HashMap<String, String>();
	private static final String CUSTOMER_FIRST_NAME = INPUT_ID + "dwfrm_profile_customer_firstname']";
	private static final String CUSTOMER_LAST_NAME = "input[id='dwfrm_profile_customer_lastname']";
	private static final String CUSTOMER_EMAIL = "input[id='dwfrm_profile_customer_email']";
	private static final String CUSTOMER_CONFIRM_EMAIL = "input[id='dwfrm_profile_customer_emailconfirm']";
	private static final String CUSTOMER_PASSWORD = "input[id*='dwfrm_profile_login_password']";
	private static final String CUSTOMER_CONFIRM_PASSWORD = "input[id*='dwfrm_profile_login_passwordconfirm']";
	private static final String ACCOUNT_APPLY_BUTTON = "[value='Apply']";
	
	
	private static final String TXTORDER_NUMBER = "input[id*='orderNumber']";
	private static final String TXTPOSTAL_CODE = "input[id*='postalCode']";
	private static final String BTN_CHECK_STATUS = "button[value='Check Status']";
	private static final String USER_NAME = "input[type='email']";
	private static final String LOGIN_PASSWORD = "input[type='password']";
	private static final String ACCOUNT_LOGIN_BUTTON = "button[value='Login']";
	private static final String FIRSTNAME_ERROR = "li:contains('First Name')";
	private static final String LASTNAME_ERROR = "li:contains('Last Name')";
	private static final String EMAIL = "li:contains('Enter Email')";
	private static final String CONFIRMEMAIL_ERROR = "li:contains('Confirm Email')";
	private static final String PASSWORD = "li:contains('Enter Password')";
	private static final String CONFIRM_PASSWORD_ERROR = "li:contains('Confirm Password')";
	private static final String EMAIL_ALREADY_EXIST_ERROR = "li:contains('Username')";
	private static final String ORDER_STATUS_ERROR = "div[class='error-form']";
	private static final String ADDRESS_NAME = "input[id*='dwfrm_profile_address_addressid']";
	private static final String USER_FIRSTNAME = "input[id*='dwfrm_profile_address_firstname']";
	private static final String NEW_PASSWORD = "input[id*='newpassword']";
	private static final String NEW_CONFIRM_PASSEORD = "input[id*='newpasswordconfirm']";
	private static final String BTNPASSWORD = "form[id='PasswordRegistrationForm'] button";
	private static final String NEWSCLOSE = "div[class*='close-button']";

	/**********************************************************************************************
	 ********************************* WebElements of MyAccountPage *****************************************
	 **********************************************************************************************/

	@FindBy(css = "div[class='breadcrumb']")
	WebElement accountPageBreadcrumb;

	@FindBy(css = "input[id='dwfrm_ordertrack_orderNumber']")
	WebElement orderNumber;

	@FindBy(css = "button[class='btn btn-primary'][value='Check Status']")
	WebElement checkStatus;

	@FindBy(css = "button[class='btn btn-primary'][value='Create an Account']")
	WebElement creatAccountButton;

	@FindBy(css = CUSTOMER_FIRST_NAME)
	WebElement txtCustFirstName;

	@FindBy(css = CUSTOMER_LAST_NAME)
	WebElement txtCustLastName;

	@FindBy(css = CUSTOMER_EMAIL)
	WebElement txtCustEmail;

	@FindBy(css = CUSTOMER_CONFIRM_EMAIL)
	WebElement txtCustConfirmEmail;

	@FindBy(css = CUSTOMER_PASSWORD)
	WebElement txtCustPassword;

	@FindBy(css = CUSTOMER_CONFIRM_PASSWORD)
	WebElement txtCustConfirmPassword;

	@FindBy(css = ACCOUNT_APPLY_BUTTON)
	WebElement applyButton;

	@FindBy(css = TXTPOSTAL_CODE)
	WebElement postalCode;

	@FindBy(css = TXTORDER_NUMBER)
	WebElement ordNumber;

	@FindBy(css = "a[title='Order History']")
	WebElement orderHistory;

	@FindBy(css = "li a[title*='personal information']")
	WebElement personalData;

	@FindBy(css = "form[id='RegistrationForm'] button ")
	WebElement editAccountButton;

	@FindBy(css = "li:contains('Please')")
	WebElement emailError;
	
	@FindBy (css = "li a[title*='Manage your billing']")
	WebElement lnkAddresses;
	
	@FindBy (css = "a[title='Create New Address']")
	WebElement btnCreateNewAddress;
	
	@FindBy (css ="div[class='bootstrap-dialog-close-button']")
	WebElement btnClose;
	
	@FindBy (css ="input[id*='dwfrm_profile_address_addressid']")
	WebElement addressName;
	
	@FindBy (css ="div[class*='visible'] a[title*='newsletter']")
	WebElement lnkNewsPaper;
	

	/**********************************************************************************************
	 ********************************* WebElements of MyAccountPage - Ends **********************************
	 **********************************************************************************************/

	/**
	 * constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				Utils.maxElementWait);
		PageFactory.initElements(finder, this);
	}// MyAccountPage

	@Override
	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}

		try {
			isPageLoaded = Utils.waitForElement(driver, accountPageBreadcrumb, 60);
		} catch (TimeoutException e) {
			driver.get(driver.getCurrentUrl());
			Utils.waitForPageLoad(driver);
			isPageLoaded = Utils.waitForElement(driver, accountPageBreadcrumb, 60);
		}

	}// isLoaded

	@Override
	protected void load() {

		isPageLoaded = true;
		Utils.waitForPageLoad(driver);
		Utils.waitForElement(driver, accountPageBreadcrumb);

	}// load

	/**
	 * use this method to click on the create Account button from My Account
	 * login page
	 * 
	 */
	public boolean clickCreateAccount() {
		// final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(creatAccountButton, driver,
				"click on create account button");
		// Log.event("return to shopping from order status page !",
		// StopWatch.elapsedTime(startTime));
		return isPageLoaded;
	}

	/**
	 * use this method to track the status of your order <br>
	 * 
	 * @param orderNumber
	 *            : webElement of the order number text field
	 * @param postalNumber
	 *            : webElement of the postal code text field
	 * @return MyAccountPage Object
	 */
	public void orderTracking(String orderNumber, String postalNumber) {

		// final long startTime = StopWatch.startTime();
		BrowserActions.typeOnTextField(TXTORDER_NUMBER, orderNumber, driver,
				"Enter order number");
		BrowserActions.typeOnTextField(TXTPOSTAL_CODE, postalNumber, driver,
				"Enter postal code");
		BrowserActions.clickOnButton(checkStatus, driver,
				"click on order status button");
		// Log.event("Searched the order tracking status!",StopWatch.elapsedTime(startTime));

	}

	/**
	 * use this method to create an account
	 * 
	 * @param accountDetails
	 *            : Hashmap Input it takes below formatted input <br>
	 *            CUSTOMER_FIRST_NAME: webElement of the first name text field <br>
	 *            CUSTOMER_LAST_NAME: webElement of the last name text field <br>
	 *            CUSTOMER_EMAIL: webElement of the email text field <br>
	 *            CUSTOMER_CONFIRM_EMAIL: webElement of the confirm email text <br>
	 *            field CUSTOMER_PASSWORD: webElement of the password text field <br>
	 *            CUSTOMER_CONFIRM_PASSWORD: webElement of the confirm password <br>
	 *            text field ACCOUNT_APPLY_BUTTON: webElement of the apply <br>
	 *            Button
	 */
	public void createAccount(HashMap<String, String> accountDetails) {

		// final long startTime = StopWatch.startTime();
		accountDetails.put("type_FirstName_" + accountDetails.get("firstname"), CUSTOMER_FIRST_NAME);
		accountDetails.put("type_lastname_" + accountDetails.get("lastname"), CUSTOMER_LAST_NAME);
		accountDetails.put("type_emailid_" + accountDetails.get("email"), CUSTOMER_EMAIL);
		accountDetails.put("type_confirmemailid_" + accountDetails.get("confirmemail"), CUSTOMER_CONFIRM_EMAIL);
		accountDetails.put("type_pasword_" + accountDetails.get("password"), CUSTOMER_PASSWORD);
		accountDetails.put("type_confirmpassword_"+ accountDetails.get("confirmpassword"), CUSTOMER_CONFIRM_PASSWORD);
		accountDetails.put("click_apply button has been clicked", ACCOUNT_APPLY_BUTTON);
		
		Account_Util.doAccountOperations(accountDetails, driver);
		// Log.event("Account has been successfully created",
		// StopWatch.elapsedTime(startTime));
	}

	/**
	 *
	 * Use this method for sign in to your Account <br>
	 * 
	 * @param loginDetails
	 *            :LOGIN_PASSWORD = webElement of the login password text field
	 *            ACCOUNT_LOGIN_BUTTON = webElement of the login button
	 *            USER_NAME = webElement of the username/email
	 */

	public MyAccountPage signIn(HashMap<String, String> loginDetails) {
		// final long startTime = StopWatch.startTime();
		loginDetails.put("type_email_" + loginDetails.get("email"), USER_NAME);
		loginDetails.put("type_password_" + loginDetails.get("password"),
				LOGIN_PASSWORD);
		loginDetails.put("click_login button is clicked", ACCOUNT_LOGIN_BUTTON);
		Account_Util.doAccountOperations(loginDetails, driver);
		// Log.event("user successfully logged In",
		// StopWatch.elapsedTime(startTime));
		return new MyAccountPage(driver).get();
	}
	
	public void creatAddress(HashMap<String, String> addressDetails) {
		// final long startTime = StopWatch.startTime();
		addressDetails.put("type_email_" + addressDetails.get("addressname"), ADDRESS_NAME);
		addressDetails.put("type_password_" + addressDetails.get("Firstname"),USER_FIRSTNAME);
		/*addressDetails.put("type_password_" + addressDetails.get("lastname"),LOGIN_PASSWORD);
		addressDetails.put("type_password_" + addressDetails.get("address"),LOGIN_PASSWORD);
		addressDetails.put("type_password_" + addressDetails.get("streetnumber"),LOGIN_PASSWORD);
		
		addressDetails.put("type_password_" + addressDetails.get("zip"),LOGIN_PASSWORD);
		addressDetails.put("type_password_" + addressDetails.get("city"),LOGIN_PASSWORD);
		addressDetails.put("type_password_" + addressDetails.get("countryCodeFromCombo"),LOGIN_PASSWORD);
		addressDetails.put("click_login button is clicked", ACCOUNT_LOGIN_BUTTON);*/
		Account_Util.doAccountOperations(addressDetails, driver);
		// Log.event("user successfully logged In",
		// StopWatch.elapsedTime(startTime));
		
	}


	/**
	 * use this method to click on the order history in account page as a signed
	 * in customer
	 * 
	 * orderHistory = webElement of the order history link
	 * 
	 * @return
	 */
	public Order_History clickOrderHistory() {
		//final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(orderHistory, driver,
				"click on order history button");
		//Log.event("return to shopping from order status page !",StopWatch.elapsedTime(startTime));
		return new Order_History(driver).get();
	}

	/**
	 * Use this method for click on personal data<br>
	 * 
	 * 
	 * personalData: webElement of the personal data link
	 */
	public boolean  clickPersonalData() {
		// final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(personalData, driver,
				"click on order history button");
		// Log.event("return to shopping from order status page !",
		// StopWatch.elapsedTime(startTime));
		return isPageLoaded;
	}

	/**
	 * Use this method for comparing email
	 * 
	 * @param toCompareEmail
	 *            : Email to compared in the Create account page
	 */
	public void fetchAndCompareEmailAddress(String toCompareEmail) {
		// final long startTime = StopWatch.startTime();
		String email = BrowserActions.getText(driver, CUSTOMER_EMAIL,
				"customer email which displayed in create account page");
		email.equalsIgnoreCase(toCompareEmail);
		// Log.event("Get email which displayed in create account page !",
		// StopWatch.elapsedTime(startTime));
	}

	/**
	 * Use this method for the clicking the Apply button in edit account page
	 * 
	 * editAccountButton: Web element for the apply button in the edit account
	 * page
	 */

	public void AccountButton() {
		// final long startTime = StopWatch.startTime();
		BrowserActions.clickOnButton(editAccountButton, driver,
				"clicked on the apply button");
		// Log.event("Get email which displayed in create account page !",
		// StopWatch.elapsedTime(startTime));
	}

	/**
	 * Use this method to verify the error message is displayed in the edit
	 * account page
	 * 
	 * EMAIL_ERROR: Web element of the email error message 
	 * 
	 * PASSWORD_ERROR: Web element of the password error message
	 */

	public boolean editAccountPageErrorDisplayed() {
		// final long startTime = StopWatch.startTime();
		BrowserActions.elementDisplayed(driver, CONFIRMEMAIL_ERROR);
		return BrowserActions.elementDisplayed(driver, CONFIRM_PASSWORD_ERROR);
		// Log.event("Get email which displayed in create account page !", StopWatch.elapsedTime(startTime));

	}
	
	/**<br> Use this method to validate all text field error message is displayed 
	 * 
	 * @return CONFIRM_PASSWORD_ERROR : Web element of confirm password Error message
	 */
	
	public boolean createAccountPageErrorDisplayed(){	
		// final long startTime = StopWatch.startTime();
		BrowserActions.elementDisplayed(driver, FIRSTNAME_ERROR);
		BrowserActions.elementDisplayed(driver, LASTNAME_ERROR);
		BrowserActions.elementDisplayed(driver, EMAIL);
		BrowserActions.elementDisplayed(driver, CONFIRMEMAIL_ERROR);
		BrowserActions.elementDisplayed(driver, PASSWORD);
		return BrowserActions.elementDisplayed(driver, CONFIRM_PASSWORD_ERROR);
		// Log.event("Error displayed for all fields in create account page !",StopWatch.elapsedTime(startTime));
	}
	
	/**Use this method to verify Email already exists error is displayed
	 * 
	 * @return EMAIL_ALREADY_EXIST_ERROR :Web element of email already exists error message
	 */
	public boolean emailAlreadyExists(){
		// final long startTime = StopWatch.startTime();
		return BrowserActions.elementDisplayed(driver, EMAIL_ALREADY_EXIST_ERROR);
		// Log.event("Get email which displayed in create account page !",StopWatch.elapsedTime(startTime));
	}

	/**Use this method to check the order status<br>
	 * 
	 * @param orderDetails: HashMap contains the order number and postal code
	 * 
	 * @return 
	 */
	public Order_Tracking checkOrderStatus(HashMap<String, String> orderDetails){
		// final long startTime = StopWatch.startTime();
		orderDetails.put("type_orderNumber_" + orderDetails.get("OrderNumber"), TXTORDER_NUMBER);
		orderDetails.put("type_zipcode_" + orderDetails.get("Zipcode"),TXTPOSTAL_CODE);
		orderDetails.put("click_login button is clicked", BTN_CHECK_STATUS);
		Account_Util.doAccountOperations(orderDetails, driver);
		// Log.event("user successfully logged In", StopWatch.elapsedTime(startTime));
		return new Order_Tracking(driver).get();	
	}

	/**
	 * 
	 * @return ORDER_STATUS_ERROR: Web element of order status error
	 */
	public boolean validateOrderStatus() {
		// final long startTime = StopWatch.startTime();
		return BrowserActions.elementDisplayed(driver, ORDER_STATUS_ERROR);
		// Log.event("Get email which displayed in create account page !",StopWatch.elapsedTime(startTime));
		
	}

	public void clickAddress() {
		// final long startTime = StopWatch.startTime();
				BrowserActions.clickOnButton(lnkAddresses, driver,"clicked on the apply button");
				
				// Log.event("Get email which displayed in create account page !",
				// StopWatch.elapsedTime(startTime));
			}
	
	public boolean createAddress(){
		BrowserActions.clickOnButton(btnCreateNewAddress, driver,"clicked on the apply button");
		return isPageLoaded;
	}
	
	public boolean close(){
		BrowserActions.clickOnButton(btnClose, driver,"clicked on the apply button");
		return isPageLoaded;
	}
	
	public void gotoNewsPaper(){
		BrowserActions.clickOnButton(lnkNewsPaper, driver, "CLicked the news paper link");
	}
	
	public boolean checkNewsPaper(){
		return BrowserActions.elementDisplayed(driver, NEWSCLOSE);
	}
	
	
	public void setNewPassword(HashMap<String, String> Password_details) {
		// final long startTime = StopWatch.startTime();
		Password_details.put("type_email_" + Password_details.get("password"), NEW_PASSWORD);
		Password_details.put("type_password_" + Password_details.get("confirm_password"),NEW_CONFIRM_PASSEORD);
		Password_details.put("click_login button is clicked", BTNPASSWORD);
		Account_Util.doAccountOperations(Password_details, driver);
		// Log.event("user successfully logged In",
		// StopWatch.elapsedTime(startTime));
	}
}
