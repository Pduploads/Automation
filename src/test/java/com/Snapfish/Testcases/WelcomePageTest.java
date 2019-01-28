package com.Snapfish.Testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Snapfish.Pages.HomePage;
import com.Snapfish.Pages.WelcomePage;
import com.Snapfish.TestBase.MainLauncher;

public class WelcomePageTest extends MainLauncher{

	WelcomePage welcomepage;
	
	public WelcomePageTest() throws IOException {
		//Which reads/Loads the properties from the properties file.
		super();
		
	}
	
	
	@BeforeMethod
	public void SetUp(Method method) throws IOException{
		String testName = method.getName();
		test = extent.createTest(testName);
		test.info("Initializing the Browser");
		initialize();
		welcomepage = new WelcomePage();
	}
	
	@Test(priority=1)
	public void validateTheSignINLinkOnWelcomePage_TEST() throws IOException{
		boolean flag = welcomepage.verifySigninLink();
		Assert.assertTrue(flag);
		}
	@Test
	public void validateTheSignINLinkClickOnWelcomePage_TEST() throws IOException{	
		welcomepage.clickonSigninLink();
		
	}
	

}
