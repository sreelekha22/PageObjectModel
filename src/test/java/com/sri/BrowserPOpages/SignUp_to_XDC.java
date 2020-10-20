package com.sri.BrowserPOpages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sri.utilities.TestBase;

public class SignUp_to_XDC extends TestBase{
	@FindBy(linkText = "Free trial")
	WebElement Freetrial;
	
	@FindBy(xpath = "//title[contains(text(),'Accounting Software - Do Beautiful Business | Xero')]")
	WebElement title;
	
	@FindBy(xpath = "//title[contains(text(),'Signup for Xero - Free Trial | Xero US')]")
	WebElement title2;
	
	@FindBy(name = "FirstName")
	WebElement FirstName;
	
	@FindBy(name = "LastName")
	WebElement LastName;
	
	@FindBy(name = "EmailAddress")
	WebElement EmailAddress;
	
	@FindBy(name = "PhoneNumber")
	WebElement PhoneNumber;
	
	@FindBy(name = "LocationCode")
	WebElement Country;
	
	@FindBy(xpath = "/html[1]/body[1]/div[4]/main[1]/div[1]/div[1]/div[1]/form[1]/div[7]/div[1]/div[1]/iframe[1]")
	WebElement Robot;
	
	@FindBy(name = "TermsAccepted")
	WebElement TermsAccepted;
	
	@FindBy(xpath = "//span[@class='g-recaptcha-submit']")
	WebElement submit;
	
	@FindBy(xpath = "//body[@class='xero is-live-mode']")
	WebElement robotBtn;
	
	@FindBy(id = "signup-form-error-message-3")
	WebElement errorMsg3;
	
	@FindBy(xpath = "//a[contains(text(),'terms')]")
	WebElement Terms;
	
	@FindBy(xpath = "//a[contains(text(),'privacy')]")
	WebElement privacy;
	
	@FindBy(xpath = "//title[contains(text(),'Terms of Use | Xero US')]")
	WebElement Termstitle;
	
	@FindBy(xpath = "//title[contains(text(),'Privacy Notice | Xero US')]")
	WebElement Privacytitle;
	
	@FindBy(xpath = "//a[contains(text(),'offer details')]")
	WebElement OfferDetails;
	
	@FindBy(xpath = "//title[contains(text(),'Offer details | Xero US')]")
	WebElement OfferTitle;
	
	@FindBy(xpath = "//a[contains(text(),'accountant or bookkeeper')]")
	WebElement bookKeeper;
	
	@FindBy(xpath = "//title[contains(text(),'Sign up for the Xero Partner Program | Xero US')]")
	WebElement bookKeeperTitle;
	
	WebDriver driver = TestBase.driver;
	ExtentTest logger;
	ExtentReports report;
	
	String sPathOFScreenshot1 = System.getProperty("user.dir")+"//screenshot/screenshot_SignUp_to_XDC.png";
	
	public SignUp_to_XDC() {
		PageFactory.initElements(driver,this);
		logger = TestBase.logger;
		report = TestBase.report;
	}
	public String ValidateLaunchPage() throws Exception {
		ExtentTest logger = TestBase.logger;

		if(title.isEnabled()) {
			logger.log(LogStatus.PASS," Xero application page is displayed ");
		}else {
			logger.log(LogStatus.FAIL, " Xero application page is not displayed ");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
		return driver.getTitle();
	}
	public void ValidateFreeTrialPage() throws Exception {
		ExtentTest logger = TestBase.logger;
		oBroUtil.clickObj(Freetrial, "Freetrial");
		if(title2.isEnabled()) {
			logger.log(LogStatus.PASS," 30 day free trial page is displayed ");
		}else {
			logger.log(LogStatus.FAIL," 30 day free trial page is not displayed ");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}
	public void FillThePage() throws Exception {
		ExtentTest logger = TestBase.logger;
		
		oBroUtil.enterText(FirstName, oBroUtil.Tprop.getProperty("FirstName") , "FirstName ");
		oBroUtil.enterText(LastName, oBroUtil.Tprop.getProperty("LastName") , "LastName ");
		oBroUtil.enterText(EmailAddress, oBroUtil.Tprop.getProperty("EmailAddress") , "EmailAddress ");
		oBroUtil.enterText(PhoneNumber, oBroUtil.Tprop.getProperty("PhoneNumber") , "PhoneNumber ");
		
		oBroUtil.clickObj(Country, "Country");
		oBroUtil.selectByVisibleText(Country,"Uganda");
	
		oBroUtil.clickObj(TermsAccepted, "TermsAccepted ");
		oBroUtil.clickObj(submit, "submit ");
		oBroUtil.clickObj(robotBtn, "robotBtn");
		if(robotBtn.isSelected()) {
			logger.log(LogStatus.PASS," Inbox page is displayed. ");
		}else {
			logger.log(LogStatus.FAIL, "Inbox page is not displayed.");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
		
	}
	
	public void DontFill() throws Exception {
		ExtentTest logger = TestBase.logger;
		oBroUtil.clickObj(submit, "submit ");
		if(errorMsg3.isDisplayed()) {
			logger.log(LogStatus.PASS," Error Message \"First name,Last name,Email address, Phone number can't be empty\" is dispalyed\r\n" + 
				" ");
		}else {
			logger.log(LogStatus.FAIL, "Error message is not displayed");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}
	
	public void wrongFormatMail() throws Exception {
		ExtentTest logger = TestBase.logger;
		oBroUtil.enterText(EmailAddress, oBroUtil.Tprop.getProperty("wrongFormat"), "EmailAddress ");
		if(errorMsg3.isDisplayed()) {
			logger.log(LogStatus.PASS, "Error Message \"Email address is invalid\" is displayed");
		}else {
			logger.log(LogStatus.FAIL, "Error Message is not displayed");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
		System.out.println(errorMsg3.getText());
	}
	public void WithoutPlicyCheck() throws Exception {
		ExtentTest logger = TestBase.logger;
		oBroUtil.enterText(FirstName, oBroUtil.Tprop.getProperty("FirstName") , "FirstName ");
		oBroUtil.enterText(LastName, oBroUtil.Tprop.getProperty("LastName") , "LastName ");
		oBroUtil.enterText(EmailAddress, oBroUtil.Tprop.getProperty("EmailAddress") , "EmailAddress ");
		oBroUtil.enterText(PhoneNumber, oBroUtil.Tprop.getProperty("PhoneNumber") , "PhoneNumber ");
		
		oBroUtil.clickObj(submit, "submit ");
		boolean notHighLight = TermsAccepted.isSelected();
		if(notHighLight == false) {
			logger.log(LogStatus.PASS," Term and Policy checkbox highlight. ");
		}else {
			logger.log(LogStatus.FAIL," Term and Policy checkbox is not highlight. ");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}
	
	public void ValidateTermsLink() throws Exception {
		ExtentTest logger = TestBase.logger;
		oBroUtil.clickObj(Terms, "Terms");
		//Switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2500);
		if(Termstitle.isEnabled()) {
			logger.log(LogStatus.PASS, "A new Xero Terms of use web page open");
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(2500);
		}else {
			logger.log(LogStatus.FAIL, "A new Xero Terms of use web page is not open");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}
	public void ValidatePrivacyLink() throws Exception {
		ExtentTest logger = TestBase.logger;
		oBroUtil.clickObj(privacy, "privacy ");
		Thread.sleep(2500);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		if(Privacytitle.isEnabled()) {
			logger.log(LogStatus.PASS, "A new Privacy policy web page open");
		}else {
			logger.log(LogStatus.FAIL, "A new Privacy policy web page is not open");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}
	public void ValidateOfferPage() throws Exception {
		ExtentTest logger = TestBase.logger;
		oBroUtil.clickObj(OfferDetails, "OfferDetails ");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if(OfferTitle.isEnabled()) {
			logger.log(LogStatus.PASS, "A new offer details web page open");
		}else {
			logger.log(LogStatus.FAIL, "web page is not open");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}
	public void ValidateBookKeeperPage() throws Exception {
		ExtentTest logger = TestBase.logger;
		oBroUtil.scroll();
		oBroUtil.clickObj(bookKeeper, "bookKeeper ");
		
		if(bookKeeperTitle.isEnabled()) {
			logger.log(LogStatus.PASS, "A new Let's start a great partnership web page open");
		}else {
			logger.log(LogStatus.FAIL, " web page is not open");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}


}
