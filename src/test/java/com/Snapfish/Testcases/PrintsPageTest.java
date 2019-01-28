package com.Snapfish.Testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Snapfish.Pages.PrintsPage;
import com.Snapfish.Pages.WelcomePage;
import com.Snapfish.TestBase.MainLauncher;

public class PrintsPageTest extends MainLauncher{
	
	WelcomePage welcomepage;
	PrintsPage printspage;

	public PrintsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp(Method method) throws IOException{
		test = extent.createTest(method.getName().toString());
		initialize();
		welcomepage = new WelcomePage();
		printspage = welcomepage.clickon_PRINTS_LINK();
	}

	@Test
	public void validate_LABEL_STANDARD_PRINTS(){
		boolean flag = printspage.verify_LABEL_STANDARD_PRINTS();
		Assert.assertTrue(flag, "The Standard Prints link is not found on the page");
	}
	
	@Test
	public void validate_LABEL_SQUARE_PRINTS(){
		boolean flag = printspage.verify_LABEL_SQUARE_PRINTS();
		Assert.assertTrue(flag, "The Square Prints link is not found on the page");
	}
}
