package com.Snapfish.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Snapfish.TestBase.MainLauncher;
import com.Snapfish.Utilities.Forcee;

public class WelcomePage extends MainLauncher{
	
	@FindBy(id="globalHeaderSignInRegister")
	WebElement signINLink;
	@FindBy(xpath = "//li[@id='PRINTS']")
	WebElement printslink;
	
	
	
	public WelcomePage()throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySigninLink() throws IOException{
		Forcee.popup();			
		test.info("Searching for the element on the page: "+ signINLink.toString());
		boolean flag =signINLink.isDisplayed();	
		
		return flag;
		
	}
	
	public LoginPage clickonSigninLink() throws IOException{
		Forcee.popup();
		test.info("Searching for the element on the page: "+ signINLink.toString());			
			signINLink.click();	
			return new LoginPage();		
		}
		
	public PrintsPage clickon_PRINTS_LINK() throws IOException{
		printslink.click();
		return new PrintsPage();
	}
		
	}
	

