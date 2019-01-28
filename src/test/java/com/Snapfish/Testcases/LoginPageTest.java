package com.Snapfish.Testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Snapfish.Pages.HomePage;
import com.Snapfish.Pages.LoginPage;
import com.Snapfish.Pages.WelcomePage;
import com.Snapfish.TestBase.MainLauncher;

public class LoginPageTest extends MainLauncher {
//Its a login test 
	WelcomePage welcomepage;
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp(Method method) throws IOException {
		test = extent.createTest(method.getName().toString());
		initialize();
		welcomepage = new WelcomePage();
		homepage = new HomePage();
		loginpage = welcomepage.clickonSigninLink();
	}

	@Test
	public void validatingtheLoginFuntionalityonLoginPage_TEST() throws IOException, InterruptedException {
		loginpage.enterthecredentialsTologintotheaccount(properties.getProperty("username"),properties.getProperty("password"));
		/*boolean flag = loginpage.verifythesigninButton();
		Assert.assertTrue(flag);
		test.pass("Sign In button found on the page");*/
		loginpage.clickonthesigninButton();
		boolean titleflag = homepage.getHomePageTitle();
		Assert.assertTrue(titleflag,"Titles are not matched");

	}

}
