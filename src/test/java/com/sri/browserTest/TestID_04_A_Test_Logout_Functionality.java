package com.sri.browserTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sri.BrowserPOpages.LogoutPage;
import com.sri.BrowserPOpages.Navigate_to_XERO;
import com.sri.utilities.TestBase;
@Listeners(com.sri.extentReportAndListener.Listener.class)
public class TestID_04_A_Test_Logout_Functionality extends TestBase{
	LogoutPage Loggingout;
	
	Navigate_to_XERO NavigateToXERO;
	
	public TestID_04_A_Test_Logout_Functionality() {
		super();
	}
	
	@BeforeSuite
	public void setUp() {
		oBroUtil.initialization();
		oReport.createreport();
	}
	@BeforeMethod
	public void openUrl() {
		NavigateToXERO = new Navigate_to_XERO();
	}
	@Test(priority = 1)
	public void launchPageTest() throws Exception {
		oReport.CreateTestScriptReport("TestID_04_A_Test_Logout_Functionality");
		NavigateToXERO.ValidateLaunchPage();
	}
	@Test(priority = 2)
	public void logintest() throws Exception {
		NavigateToXERO.Login(oBroUtil.prop.getProperty("username"),oBroUtil.prop.getProperty("password"));
	}
	@Test(priority = 3)
	public void HomePageTest() throws Exception {
		NavigateToXERO.validateHomePage();
		
	}
	@Test(priority = 4)
	public void LogOutTest() throws Exception {
		Loggingout = new  LogoutPage();
		Loggingout.logout();
	}
	@Test(priority = 5)
	public void UserNameFieldTest() throws Exception {
		Loggingout.UserNameFieldValidation();
	}
	
	@AfterSuite
	public void closingBrowser() throws Exception {
		oReport.CloseReport();
		oBroUtil.teardown();
	}

}
