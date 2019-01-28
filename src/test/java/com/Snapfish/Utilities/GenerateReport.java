package com.Snapfish.Utilities;

import java.io.File;
import java.io.IOException;

import com.Snapfish.TestBase.MainLauncher;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenerateReport extends MainLauncher{
	public GenerateReport() throws IOException {
		
	}

	public static ExtentReports extent;
	public static ExtentHtmlReporter reporter;
	public static ExtentTest test;

	public static ExtentReports extentReport() {
		extent = new ExtentReports();
		reporter = new ExtentHtmlReporter(new File(projectLocation + "\\Report\\snapfishReport.html"));
		reporter.loadXMLConfig(projectLocation + "\\extent-config.xml", true);
		extent.attachReporter(reporter);
		return extent;

	}
}
