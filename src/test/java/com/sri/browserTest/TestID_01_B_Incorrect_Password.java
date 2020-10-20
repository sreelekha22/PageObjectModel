package com.sri.browserTest;

import org.testng.annotations.AfterSuite;
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
	public void setUp() {
		oBroUtil.initialization();
		oReport.createreport();
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
	@AfterSuite
	public void closingBrowser() throws Exception {
		oReport.CloseReport();
		oBroUtil.teardown();
	}

}
