package com.sri.utilities;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sri.extentReportAndListener.ExtentReport;
import com.sri.extentReportAndListener.ScreenShot;

public class TestBase {
	public static ExtentTest logger;
	public static ExtentReports report;
	public static WebDriver driver;
	
	public static ScreenShot sc = new ScreenShot();
	public static BrowserUtilities oBroUtil = new BrowserUtilities();
	public static ExtentReport oReport = new ExtentReport();
	public static CommonUtilities oCommUtil = new CommonUtilities();
	
}
