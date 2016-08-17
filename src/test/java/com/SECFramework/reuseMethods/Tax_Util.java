package com.SECFramework.reuseMethods;

import com.SECFramework.support.Log;
import com.SECFramework.support.StopWatch;

/**
 * Re-Usable methods of Calculating Tax for Retail Sites
 * 
 * @author harish.subramani
 * 
 */
public class Tax_Util {

	/**
	 * Calculate State Tax - Can be used for Cloth/Accesories
	 * 
	 * @param amount
	 *            : Total Purchase Amount
	 * @param stateTaxPerc
	 *            : State Tax Percentage
	 * @return: State Tax
	 */
	final public static double getStateTax(double amount, double stateTaxPerc) {

		final long startTime = StopWatch.startTime();
		double totalStateTax = amount * stateTaxPerc;
		Log.trace("Calculated State Tax.", StopWatch.elapsedTime(startTime));
		return totalStateTax;

	}// getStateTax

	/**
	 * Calculate State Tax - Can be used for Cloth/Accesories
	 * 
	 * @param unitPrice
	 *            : Price of an product of 1 qty
	 * @param qty
	 *            : No of Quantity
	 * @param stateTaxPerc
	 *            : State Tax Percentage
	 * @return: State Tax
	 */
	final public static double getStateTax(double unitPrice, int qty, double stateTaxPerc) {

		double amount = unitPrice * qty;
		final long startTime = StopWatch.startTime();
		double totalStateTax = amount * stateTaxPerc;
		Log.trace("Calculated State Tax.", StopWatch.elapsedTime(startTime));
		return totalStateTax;

	}// getStateTax

	/**
	 * Calculate Country Tax
	 * 
	 * @param amount
	 *            : Total Purchase Amount
	 * @param countyTaxPerc
	 *            : Country Tax Percentage
	 * @return: Country Tax
	 */
	final public static double getCountryTax(double amount, double countyTaxPerc) {

		final long startTime = StopWatch.startTime();
		double totalCountyTax = amount * countyTaxPerc;
		Log.trace("Calculated Country Tax.", StopWatch.elapsedTime(startTime));
		return totalCountyTax;

	}// getCountryTax

	/**
	 * Calculate Country Tax
	 * 
	 * @param unitPrice
	 *            : Price of an product of 1 qty
	 * @param qty
	 *            : No of Quantity
	 * @param countyTaxPerc
	 *            : Country Tax Percentage
	 * @return: Country Tax
	 */
	final public static double getCountryTax(double unitPrice, int qty, double countyTaxPerc) {

		double amount = unitPrice * qty;
		final long startTime = StopWatch.startTime();
		double totalCountyTax = amount * countyTaxPerc;
		Log.trace("Calculated Country Tax.", StopWatch.elapsedTime(startTime));
		return totalCountyTax;

	}// getCountryTax

	/**
	 * Calculate Total Sales Tax [State Tax + Country Tax]
	 * 
	 * @param amount
	 *            : Total Purchase Amount
	 * @param stateTaxPerc
	 *            : State Tax Percentage
	 * @param countyTaxPerc
	 *            : Country Tax Percentage
	 * @return: Total Sales Tax
	 */
	final public static double getTotalSalesTax(double amount, double stateTaxPerc, double countyTaxPerc) {

		final long startTime = StopWatch.startTime();
		double totalStateTax = amount * stateTaxPerc;
		double totalCountyTax = amount * countyTaxPerc;
		double totalSalesTax = totalStateTax + totalCountyTax;
		Log.trace("Calculated Total Sales Tax.", StopWatch.elapsedTime(startTime));
		return totalSalesTax;

	}// getTotalSalesTax

	/**
	 * Calculate Total Sales Tax [State Tax + Country Tax]
	 * 
	 * @param unitPrice
	 *            : Price of an product of 1 qty
	 * @param qty
	 *            : No of Quantity
	 * @param stateTaxPerc
	 *            : State Tax Percentage
	 * @param countyTaxPerc
	 *            : Country Tax Percentage
	 * @return: Total Sales Tax
	 */
	final public static double getTotalSalesTax(double unitPrice, int qty, double stateTaxPerc, double countyTaxPerc) {

		double amount = unitPrice * qty;
		final long startTime = StopWatch.startTime();
		double totalStateTax = amount * stateTaxPerc;
		double totalCountyTax = amount * countyTaxPerc;
		double totalSalesTax = totalStateTax + totalCountyTax;
		Log.trace("Calculated Total Sales Tax.", StopWatch.elapsedTime(startTime));
		return totalSalesTax;

	}// getTotalSalesTax

	/**
	 * Calculate Total Sales Tax [Purchase Amount + Tax Amount]
	 * 
	 * @param amount
	 *            : Total Purchase Amount
	 * @param stateTaxPerc
	 *            : State Tax Percentage
	 * @param countyTaxPerc
	 *            : Country Tax Percentage
	 * @return: Total Sale Amount
	 */
	final public static double getTotalSaleAmount(double amount, double stateTaxPerc, double countyTaxPerc) {

		final long startTime = StopWatch.startTime();

		double totalStateTax = amount * stateTaxPerc;
		double totalCountyTax = amount * countyTaxPerc;
		double totalSalesTax = totalStateTax + totalCountyTax;
		double totalSaleAmount = amount + totalSalesTax;
		Log.trace("Calculated Total Sales Amount.", StopWatch.elapsedTime(startTime));
		return totalSaleAmount;

	}// getTotalSaleAmount

	/**
	 * Calculate Total Sales Tax [Purchase Amount + Tax Amount]
	 * 
	 * @param unitPrice
	 *            : Price of an product of 1 qty
	 * @param qty
	 *            : No of Quantity
	 * @param stateTaxPerc
	 *            : State Tax Percentage
	 * @param countyTaxPerc
	 *            : Country Tax Percentage
	 * @return: Total Sale Amount
	 */
	final public static double getTotalSaleAmount(double unitPrice, int qty, double stateTaxPerc, double countyTaxPerc) {

		final long startTime = StopWatch.startTime();
		double amount = unitPrice * qty;
		double totalStateTax = amount * stateTaxPerc;
		double totalCountyTax = amount * countyTaxPerc;
		double totalSalesTax = totalStateTax + totalCountyTax;
		double totalSaleAmount = amount + totalSalesTax;
		Log.trace("Calculated Total Sales Amount.", StopWatch.elapsedTime(startTime));
		return totalSaleAmount;

	}// getTotalSaleAmount

}// Tax_Util