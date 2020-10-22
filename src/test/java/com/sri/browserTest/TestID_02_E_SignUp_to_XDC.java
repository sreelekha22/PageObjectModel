package com.sri.browserTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sri.BrowserPOpages.SignUp_to_XDC;
import com.sri.utilities.TestBase;

@Listeners(com.sri.extentReportAndListener.Listener.class)
public class TestID_02_E_SignUp_to_XDC extends TestBase{
	SignUp_to_XDC SignUp;
	
	public TestID_02_E_SignUp_to_XDC() {
		super();
	}
	@BeforeSuite
	public void startreport() {
		oReport.createreport();
	}
	@BeforeClass
	public void setUp() {
		oBroUtil.initialization();
		SignUp = new SignUp_to_XDC();
	}
	@Test(priority = 1)
	public void launchPageTest() throws Exception {
		oReport.CreateTestScriptReport("Sign Up to XDC 2E");
		SignUp.ValidateLaunchPage();
	}
	@Test(priority = 2)
	public void FreeTrialPageTest() throws Exception {
		SignUp.ValidateFreeTrialPage();
	}
	@Test(priority = 3)
	public void BookKeeperPageTest() throws Exception {
		SignUp.ValidateBookKeeperPage();
	}
	@AfterClass
	public void closingBrowser() throws Exception {
		oBroUtil.teardown();
	}
	@AfterSuite
	public void closereport() {
		oReport.CloseReport();
	}
}
