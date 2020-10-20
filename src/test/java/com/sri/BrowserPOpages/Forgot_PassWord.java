package com.sri.BrowserPOpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sri.utilities.TestBase;

public class Forgot_PassWord extends TestBase{
	@FindBy(partialLinkText = "Login")
	WebElement login;
	
	@FindBy(linkText = "Forgot password?")
	WebElement forgotPwd;
	
	@FindBy(xpath = "//title[contains(text(),'Xero | Forgot Password')]")
	WebElement forgotPage;
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "submit-reset-password")
	WebElement SendLink;
	
	@FindBy(tagName = "title")
	WebElement ReserMsg;
	
	WebDriver driver = TestBase.driver;
	ExtentTest logger;
	ExtentReports report;
	
	String sPathOFScreenshot1 = System.getProperty("user.dir")+"//screenshot/screenshot_Forgot_PassWord.png";

	public Forgot_PassWord() {
		PageFactory.initElements(driver,this);
		logger = TestBase.logger;
		report = TestBase.report;
	}
	public String ValidateLoginPage() throws Exception {
		ExtentTest logger = TestBase.logger;

		oBroUtil.clickObj(login, "login");
		WebElement title =  driver.findElement(By.tagName("title"));
		if(title.isEnabled()) {
			logger.log(LogStatus.PASS," Xero application page is displayed ");
		}else {
			logger.log(LogStatus.FAIL, " Xero application page is not displayed ");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
		return driver.getTitle();
	}
	public WebElement ForgotPassword() throws Exception {
		ExtentTest logger = TestBase.logger;
		oBroUtil.clickObj(forgotPwd, "forgot password ");
		if(forgotPage.isEnabled()) {
			logger.log(LogStatus.PASS," Xero forgot password page is displayed ");
		}else {
			logger.log(LogStatus.FAIL," Xero forgot password page is not displayed ");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
		return forgotPage;
	}
	public WebElement ResetMessage(String un) throws Exception {
		oBroUtil.enterText(Email, un , "User Email ");
		oBroUtil.clickObj(SendLink, "SendLink ");
		return ReserMsg;
	}
	public boolean validateResetMsg() throws Exception {
		ExtentTest logger = TestBase.logger;
		if(ReserMsg.isEnabled()) {
			logger.log(LogStatus.PASS," Password reset message is displayed ");
		}else {
			logger.log(LogStatus.FAIL," Password reset message is not displayed ");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
		return ReserMsg.isDisplayed();
	}

}
