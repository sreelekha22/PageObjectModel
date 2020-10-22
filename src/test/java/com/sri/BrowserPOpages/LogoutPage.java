package com.sri.BrowserPOpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sri.utilities.TestBase;

public class LogoutPage extends TestBase{
	@FindBy(xpath = "//img[@class='xrh-avatar']")
	WebElement AccountBtn;
	
	@FindBy(xpath = "//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')]")
	WebElement logout;
	
	@FindBy(xpath = "//div[@class='form-container']")
	WebElement WelcomePage;
	
	@FindBy(xpath = "//fieldset//div[1]")
	WebElement userNameField;
	
	String sPathOFScreenshot1 = System.getProperty("user.dir")+"//screenshot/screenshot_LogOutPage.png";
	WebDriver driver = TestBase.driver;
	ExtentTest logger;
	ExtentReports report;

	
	public LogoutPage() {
		PageFactory.initElements(driver,this);
		logger = TestBase.logger;
		report = TestBase.report;

	}
	
	public void logout() throws Exception{
		ExtentTest logger = TestBase.logger;
		oBroUtil.clickObj(AccountBtn, "AccountBtn");
		oBroUtil.clickObj(logout, "logout");
		if(WelcomePage.isDisplayed()) {
			logger.log(LogStatus.PASS, "Welcome to xero page is displayed.");
		}else {
			logger.log(LogStatus.FAIL, "Welcome to xero page is not displayed.");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}
	public void UserNameFieldValidation() throws Exception {
		ExtentTest logger = TestBase.logger;
		if(userNameField.isDisplayed()) {
			logger.log(LogStatus.PASS, "user name displayed in user name field");
		}else {
			logger.log(LogStatus.FAIL, "user name is not displayed");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}

}
