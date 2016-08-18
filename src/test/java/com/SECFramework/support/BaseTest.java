package com.SECFramework.support;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class BaseTest {
	protected static ExtentReports extent;
	public static String timeanddate = DateTimeUtility.getCurrentDateAndTime();
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestContext ctx) {

	}
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		extent = new ExtentReports("./test-output/Regression.html", true, DisplayOrder.NEWEST_FIRST, NetworkMode.ONLINE);
		File file = new File("test-output\\failed-output\\FailedTestAutomationResults".concat(timeanddate)+".txt");
	        boolean fileCreated = false;
	        try {
	            fileCreated = file.createNewFile();
	        } catch (IOException ioe) {
	            System.out.println("Error while creating empty file: " + ioe);
	}
	}

	/*
	 * After suite will be responsible to close the report properly at the end You an have another afterSuite as well in the derived class and this one will be called in the end making it the last
	 * method to be called in test exe
	 */
	@AfterSuite
	public void afterSuite() {
		EmailReport emailreprt = new EmailReport();
		emailreprt.writeFailedLog(timeanddate);
		extent.flush();
}
}
