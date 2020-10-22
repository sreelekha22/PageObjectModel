package com.sri.browserTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sri.BrowserPOpages.Incorrect_Password;
import com.sri.utilities.TestBase;
@Listeners(com.sri.extentReportAndListener.Listener.class)
public class TestID_01_B_Incorrect_Password extends TestBase{
	Incorrect_Password incorrectPwd;
	
	
	public TestID_01_B_Incorrect_Password() {
		super();
	}
	@BeforeSuite
	public void startreport() {
		oReport.createreport();
	}
	@BeforeClass
	public void setUp() {
		oBroUtil.initialization();
		incorrectPwd = new Incorrect_Password();
	}
	@Test(priority = 1)
	public void launchPageTest() throws Exception {
		oReport.CreateTestScriptReport("Incorrect password");
		incorrectPwd.ValidateLaunchPage();
	}
	@Test(priority = 2)
	public void logintest() throws Exception {
		incorrectPwd.Login(oBroUtil.prop.getProperty("username"),oBroUtil.prop.getProperty("wrongPWD"));
	}
	@Test(priority = 3)
	public void ErrorMsgTest() throws Exception {
		incorrectPwd.validateErrorMsg();
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
