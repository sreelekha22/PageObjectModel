package com.sri.extentReportAndListener;

import com.relevantcodes.extentreports.ExtentReports;
import com.sri.utilities.TestBase;

public class ExtentReport extends TestBase{
	
	    public void createreport() {
		String path = "C:/Users/dolby/eclipse-workspace/finalProject/Report/report.html";
		((TestBase) this).report = new ExtentReports(path);
	}
	public void CloseReport() {
		((TestBase) this).report.flush();
	}
	public void CreateTestScriptReport(String TestScriptName) {
		((TestBase) this).logger = ((TestBase) this).report.startTest(TestScriptName);
		//System.out.println("extent report: " + logger);
		//System.out.println(TestScriptName);
	}
	
}
