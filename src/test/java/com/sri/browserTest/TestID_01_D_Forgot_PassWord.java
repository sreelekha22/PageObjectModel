package com.sri.browserTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sri.BrowserPOpages.Forgot_PassWord;
import com.sri.utilities.TestBase;


public class TestID_01_D_Forgot_PassWord extends TestBase{
	Forgot_PassWord ForgotPW;
	
	public TestID_01_D_Forgot_PassWord() {
		super();
	}
	@BeforeSuite
	public void setUp() {
		oBroUtil.initialization();
		oReport.createreport();
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
	@AfterSuite
	public void closingBrowser() throws Exception {
		oReport.CloseReport();
		oBroUtil.teardown();
	}

}
