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

public class Incorrect_Email extends TestBase{
	@FindBy(partialLinkText = "Login")
	WebElement login;
	
	@FindBy(name = "Username")
	WebElement username;
	
	@FindBy(id = "xl-form-password")
	WebElement password;
	
	@FindBy(id = "xl-form-submit")
	WebElement submit;
	
	@FindBy(xpath = "//li[contains(text(),'Your email or password is incorrect')]")
	WebElement ErrorMsg;
	
	WebDriver driver = TestBase.driver;
	ExtentTest logger;
	ExtentReports report;
	
	String sPathOFScreenshot1 = System.getProperty("user.dir")+"//screenshot/screenshot_Incorrect_Email.png";
	
	public Incorrect_Email() {
		PageFactory.initElements(driver,this);
		logger = TestBase.logger;
		report = TestBase.report;
	}
	public String ValidateLaunchPage() throws Exception {
		ExtentTest logger = TestBase.logger;
		WebElement title =  driver.findElement(By.tagName("title"));
		if(title.isEnabled()) {
			logger.log(LogStatus.PASS," Xero application page is displayed ");
		}else {
			logger.log(LogStatus.FAIL, " Xero application page is not displayed ");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
		return driver.getTitle();
	}
	public WebElement Login(String un,String pwd) throws Exception {
		
		oBroUtil.clickObj(login, "login");
		oBroUtil.enterText(username, un , "UserName");
		oBroUtil.enterText(password, pwd , "PassWord");
		oBroUtil.clickObj(submit, "Submit");
		return ErrorMsg;
	}
	public void validateErrorMsg() throws Exception {
		ExtentTest logger = TestBase.logger;
		if(ErrorMsg.isDisplayed()) {
			logger.log(LogStatus.PASS," error message is displayed ");
		}else {
			logger.log(LogStatus.FAIL, " error message is not displayed ");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}
}
