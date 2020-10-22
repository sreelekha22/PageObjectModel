package com.sri.browserTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sri.BrowserPOpages.Forgot_PassWord;
import com.sri.utilities.TestBase;

@Listeners(com.sri.extentReportAndListener.Listener.class)
public class TestID_01_D_Forgot_PassWord extends TestBase{
	Forgot_PassWord ForgotPW;
	
	public TestID_01_D_Forgot_PassWord() {
		super();
	}
	@BeforeSuite
	public void startreport() {
		oReport.createreport();
	}
	@BeforeClass
	public void setUp() {
		oBroUtil.initialization();
		ForgotPW = new Forgot_PassWord();
	}
	@Test(priority = 1)
	public void launchPageTest() throws Exception {
		oReport.CreateTestScriptReport("Forgot password");
		ForgotPW.ValidateLoginPage();
	}
	@Test(priority = 2)
	public void ResetPasswordTest() throws Exception {
		ForgotPW.ForgotPassword();
	}
	@Test(priority = 3)
	public void ResetMsgTest() throws Exception {
		ForgotPW.ResetMessage(oBroUtil.prop.getProperty("username"));
	}
	@Test(priority = 3)
	public void ResetMsgValidation() throws Exception {
		ForgotPW.validateResetMsg();
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
