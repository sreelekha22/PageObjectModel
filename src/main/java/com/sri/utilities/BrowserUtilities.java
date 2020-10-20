package com.sri.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilities extends TestBase{
	//public WebDriver driver;
	public Properties prop;
	//public static ExtentTest logger;
	public Properties Tprop;
	
public  BrowserUtilities(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + 
			  "/src/main/java/com/sri/properties/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tprop = new Properties();
			FileInputStream tp = new FileInputStream(System.getProperty("user.dir") +
					"/src/main/java/com/sri/properties/testdata.properties");
			Tprop.load(tp);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

public void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			
			WebDriverManager.chromedriver().setup();
			((TestBase) this).driver = new ChromeDriver();
			//System.out.println("browser utilities driver: " + driver);
			
		}else if(browserName.equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	public void teardown() {
		driver.quit();
	}
	public void enterText(WebElement obj,String textval,String objName) throws Exception

	{
		if(obj.isEnabled())
		{
			Thread.sleep(4000);
			obj.sendKeys(textval);
			System.out.println("pass: "+textval+" value is entered in "+objName+"field");
			//Call take screenshot function
			logger.log(LogStatus.PASS,textval+" value is entered in "+objName+"field");
			
			
		}
		else
		{
			System.out.println("fail:" +objName+ " field does not exist please check application");
			logger.log(LogStatus.FAIL,textval+objName+" field does not exist please check application");
			
		}
	}
	
	public void clickObj(WebElement obj,String objName) throws Exception{
		Thread.sleep(2500);
		if(obj.isEnabled())
		{
			obj.click();
			System.out.println("pass :" +objName + " button is clicked");
			logger.log(LogStatus.PASS, objName+ " button is displayed and clicked");
		}
		else
		{
			System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
			logger.log(LogStatus.FAIL, objName+ "button is not displayed ,please check the application");
		}
	}
	

	public void selectCheckBox(WebElement obj, String objName) {
		
		if(obj.isDisplayed()) {
			
			if(obj.isSelected()) {
				System.out.println("Pass: "+objName+" is already selected");
				logger.log(LogStatus.INFO, objName + "is already selected");
			}else{
			obj.click();
			System.out.println("Pass: "+objName+" is selected");
			logger.log(LogStatus.PASS, objName + "is selected");
		    }}
			else {
			System.out.println("Fail:"+objName+" is not present.Please chk application");	
			logger.log(LogStatus.FAIL, objName+ " is not displayed ,please check the application");
		}	
	}
	
	public void selectDropdown(WebElement obj, String objName) {
						
				if(obj.isDisplayed()) {
					System.out.println("Pass: "+objName+" is  selected");
					obj.click();
				}else
				{
				
					System.out.println("Fail:"+objName+" is not present.Please chk application");	
				
			    }
		}
	public void switchFrame( WebDriver driver,WebElement obj) {
		 
	    if(obj.isDisplayed()) {
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	     logger.log(LogStatus.PASS,  "Switch to frame" );
	     
	    }else {
	     System.out.println("fail: we can't switch to the "+obj+ " frame");
	     logger.log(LogStatus.FAIL,  "Cannot Switch to frame" );
	    }
	}


	public void switchFrameid( WebDriver driver,String obj) {
		 
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	     logger.log(LogStatus.PASS,  "we can switch to the frame" );
	     
	    }

	public void switchdefaultFrame( WebDriver driver){
		driver.switchTo().defaultContent();
		System.out.println("Pass: we can switch to the "+ driver + " back to frame");
		logger.log(LogStatus.PASS,  "we can switch back to the frame" );
	}
	public void mouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
	   Actions action=new Actions(driver);
	   action.moveToElement(obj).build().perform();
		System.out.println("Pass: "+obj+" is present");
		logger.log(LogStatus.PASS,  "obj is present" );
		}
	 else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
			logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
		}
	}


	public void SelectbyText(WebElement we, String VisibleText){
		   if(we.isDisplayed())
		   {
			   Select selObj=new Select(we);
	           selObj.selectByVisibleText(VisibleText);
		           System.out.println("Pass: "+VisibleText+ " is Selected by VisibleText" );
		           logger.log(LogStatus.PASS, " is Selected by VisibleText" );
		           
		   } 
		   else
		   {
		    System.out.println("Fail: "+VisibleText+ " is not available");
		    logger.log(LogStatus.FAIL, " is not Selected by VisibleText" );
		    
		   }
		      
	}

	public void SelectByValue(WebElement obj, String val) {
		  //if(obj.isSelected()) {
		if(obj.isDisplayed()) {
		   Select selObj=new Select(obj);
		    
		   selObj.selectByValue(val);
		  System.out.println("pass:"+val + " is selected from drop down ");
		  logger.log(LogStatus.PASS, " is selected from drop down " );
		 
		  }else {
		   System.out.println("Fail:"+val+"is not selected");
		   logger.log(LogStatus.FAIL, " is not selected from drop down " );
		  }
	}	  



	public void selectByIndex(WebElement obj, int index) {
		  if(obj.isDisplayed()) {
		   Select selObj=new Select(obj);
		  selObj.selectByIndex(index);
		  
		  System.out.println("pass:"+index + " is selected from drop down ");
		  logger.log(LogStatus.PASS, " is selected from drop down " );
		  }else {
		   System.out.println("Fail:"+index+"is not selected");
		   logger.log(LogStatus.FAIL, " is not selected from drop down " );
		  }
		 }

	public void selectByVisibleText(WebElement obj, String Name) {
		if(obj.isEnabled()) {
			 Select drop = new Select(obj);
			 drop.selectByVisibleText(Name);
		 System.out.println("Pass: dropdown is selected");
		 }else {
		 System.out.println("Fail: dropdown is not available check your application");
		 }
	 }


	public void Radiobutton(WebElement obj, String objName) {
		
		if(obj.isDisplayed() ){
			obj.click();
			System.out.println("Pass: "+objName+" is clicked");
		}else {
			System.out.println("Fail:"+objName+" is not displayed .Please check your application");			
		}
	}


	public void switchtoAlert(WebDriver driver) {
		 driver.switchTo().alert().accept();
		 System.out.println("Pass: alert is present and accepted.");
	}
	public void switchtoAlertDismiss(WebDriver driver) {
		 driver.switchTo().alert().dismiss();
		 System.out.println("Pass: alert is present and dismissed");
	}
	public void scroll() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
	}
}
