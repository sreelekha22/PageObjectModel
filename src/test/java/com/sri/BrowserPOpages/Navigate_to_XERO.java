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

public class Navigate_to_XERO extends TestBase{
	
	@FindBy(partialLinkText = "Login")
	WebElement login;
	
	@FindBy(name = "Username")
	WebElement username;
	
	@FindBy(id = "xl-form-password")
	WebElement password;
	
	@FindBy(id = "xl-form-submit")
	WebElement submit;
	
	@FindBy(xpath= "//h1[@class='xui-pageheading--title']")
	WebElement HomePage;
	
	WebDriver driver = TestBase.driver;
	ExtentTest logger;
	ExtentReports report;
	
	public Navigate_to_XERO() {
		//System.out.println("calling Navigate_to_XERO constructor");
		PageFactory.initElements(driver,this);
		logger = TestBase.logger;
		report = TestBase.report;
	}
	String sPathOFScreenshot1 = System.getProperty("user.dir")+"//screenshot/screenshot_Navigate_to_XERO.png";
	
	public String ValidateLaunchPage() throws Exception {
		//System.out.println(driver);
		//System.out.println(logger);
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
		return HomePage;
	}
	public void validateHomePage() throws Exception {
		if(HomePage.isDisplayed()) {
			logger.log(LogStatus.PASS," User's Home Page is displayed ");
		}else {
			logger.log(LogStatus.FAIL, " User's Home Page is not displayed ");
			sc.takeSnapShot(driver, sPathOFScreenshot1);
		}
	}

}
