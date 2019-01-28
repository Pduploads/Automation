package com.Snapfish.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Snapfish.Utilities.GenerateReport;
import com.Snapfish.Utilities.ScreenShot;
import com.Snapfish.Utilities.WebEventListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MainLauncher {
	// Declaring the Report variables
		public static ExtentReports extent;
		public static ExtentHtmlReporter reporter;
		public static ExtentTest test;

		

	@BeforeSuite
	public void initilizingRepo() {
		extent = GenerateReport.extentReport();
	}

	@AfterMethod
	public void checkingTheResults(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS){
			test.pass(MarkupHelper.createLabel(result.getName()+" Passed", ExtentColor.GREEN));
		}
		if(result.getStatus()==ITestResult.FAILURE){
			test.fail(MarkupHelper.createLabel(result.getName()+" Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
			String capture = ScreenShot.takeScreenshot(result.getName());
			test.fail("Below is the Screenshot : ");
			test.addScreenCaptureFromPath(capture);
		}
		if(result.getStatus()==ITestResult.SKIP){
			test.skip(MarkupHelper.createLabel(result.getName()+" Skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
		//driver.quit();
	}
	
	@AfterSuite
	public void tearDown(){
		extent.flush();
	}

	public static WebDriver driver = null;
	public static Properties properties;
	public static String projectLocation = System.getProperty("user.dir");
	public static FileInputStream file;

	// Load the properties
	public MainLauncher() throws IOException {
		file = new FileInputStream(projectLocation + "\\snapfishProperties.properties");
		properties = new Properties();
		properties.load(file);
		}
	
	// WebDriver Event Listener declaration
			static EventFiringWebDriver eventFiring;
			static WebEventListener weblistener;

	public static void initialize() {
			if(properties.getProperty("browser").equalsIgnoreCase("chrome")){
				test.info("Setting the properties to select the browser");
				System.setProperty("webdriver.chrome.driver", projectLocation+"\\exeFiles\\chromedriver.exe");
				test.info("Selected Chrome Browser");
				driver = new ChromeDriver();
				test.info("Launching the Browser");
			}
				else if(properties.getProperty("browser").equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver", projectLocation+"\\exeFiles\\geckodriver.exe");
					test.info("Setting the properties to select the browser");
					test.info("Selected FireFox Browser");
					driver = new FirefoxDriver();
					test.info("Launching the Browser");
			}
			
			eventFiring = new EventFiringWebDriver(driver);
			try {
				weblistener = new WebEventListener();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eventFiring.register(weblistener);
			driver = eventFiring;
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}

}
