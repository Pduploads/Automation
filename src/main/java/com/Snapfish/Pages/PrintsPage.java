package com.Snapfish.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Snapfish.TestBase.MainLauncher;

public class PrintsPage extends MainLauncher{

	
	@FindBy(xpath = "//div[contains(text(),'Standard Prints - From 9¢')]")
	WebElement labelstandardprints;
	
	@FindBy(xpath = "//div[contains(text(),'Square Prints - From 20¢')]")
	WebElement labelsquareprints;
	
	
	PrintsPage()throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public String getthetitle(){
		return driver.getTitle();
	}
	
	public boolean verify_LABEL_STANDARD_PRINTS(){
		test.info("Searching to find the element on the Page  "+labelstandardprints.toString());
		return labelstandardprints.isDisplayed();
		
	}
	public boolean verify_LABEL_SQUARE_PRINTS(){
		test.info("Searching to find the element on the Page  "+labelsquareprints.toString());
		return labelsquareprints.isDisplayed();
		
	}
}
