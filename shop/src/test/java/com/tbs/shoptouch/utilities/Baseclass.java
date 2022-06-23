package com.tbs.shoptouch.utilities;

import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Baseclass extends Browser{
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest testName;		
	@BeforeSuite
	public void extendReport() {
			try {
				File file = new File("Test Reports");
				if (!file.exists()) {
					System.out.println("File created " + file);
					file.mkdir();
				}
			htmlReporter = new ExtentSparkReporter(new File("./"+file+"/"+"Shop_"+getTimeStamp()+".html"));
			//create ExtentReports and attach reporter(s)
		    extent = new ExtentReports();
		    extent.attachReporter(htmlReporter);
		    htmlReporter.config().setReportName("Shop Touch/Shop Test Report");
	        htmlReporter.config().setTheme(Theme.DARK);
					 
		} catch (Exception e) {
			System.out.println("An exception occured while taking Creating Report " + e.getCause());
		}

		}
	
	@BeforeSuite
	public void setup() {
		setProperties();
		StartBrowser();
	}
	
	@AfterTest
	public void tearDown() {
		quitbrowser(driver);
	}
	@AfterTest
	public void reportgeneration() {
		extent.flush();
	}
}
