package com.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	public ExtentReports extentReports;
	
	
	@BeforeMethod
	public void config() {
		//C:\Users\Lenovo\Desktop\Framework\HybridPomFrameWork\reports
	String path	= System.getProperty("user.dir")+"\\reports\\index.html";
	
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
    extentReports = new ExtentReports();
	extentReports.attachReporter(reporter);
	extentReports.setSystemInfo("Tester", "Rahul Shetty");
	}
	
	
	
	
	
	
	@Test
	public void initialDemo() {
		
		extentReports.createTest("initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println(driver.getTitle());
		 String title =   driver.getTitle();
		 Assert.assertEquals(title, "Let's Shop");
		 extentReports.flush();
		
	}
	
	
	
	
	
	
	
	
}
