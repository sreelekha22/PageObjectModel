package com.sri.browserTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sri.BrowserPOpages.Incorrect_Email;
import com.sri.utilities.TestBase;
@Listeners(com.sri.extentReportAndListener.Listener.class)
public class TestID_01_C_Incorrect_Email extends TestBase{
     Incorrect_Email incorrectUserName;
	
	
	public TestID_01_C_Incorrect_Email() {
		super();
	}
	@BeforeSuite
	public void startreport() {
		oReport.createreport();
	}
	@BeforeClass
	public void setUp() {
		oBroUtil.initialization();
		incorrectUserName = new Incorrect_Email();
	}
	@Test(priority = 1)
	public void launchPageTest() throws Exception {
		oReport.CreateTestScriptReport("Incorrect email.");
		incorrectUserName.ValidateLaunchPage();
	}
	@Test(priority = 2)
	public void logintest() throws Exception {
		incorrectUserName.Login(oBroUtil.prop.getProperty("wrogUID"),oBroUtil.prop.getProperty("password"));
	}
	@Test(priority = 3)
	public void ErrorMsgTest() throws Exception {
		incorrectUserName.validateErrorMsg();
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
