package com.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	
	
	    public static ExtentReports getReportObject() {
		
		String path	= System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Tester", "Rahul Shetty");
		
		return extentReports;
		
	}
	
	
	
}