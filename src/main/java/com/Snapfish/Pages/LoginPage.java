package com.Snapfish.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Snapfish.TestBase.MainLauncher;
import com.Snapfish.Utilities.Forcee;

public class LoginPage extends MainLauncher{

	
	@FindBy(xpath = "//h1[contains(text(),'Sign in to Snapfish')]")
	WebElement textSingnIntoSnapfish;
	
	@FindBy(id = "EmailAddress")
	WebElement emailaddress;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "loginsubmit")
	WebElement loginbutton;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean textsignintoSnapfish(){
		Forcee.popup();
		boolean flag = textSingnIntoSnapfish.isDisplayed();
		return flag;
	}
	public void enterthecredentialsTologintotheaccount(String emailaddress, String password) throws InterruptedException{
		Forcee.popup();
		//this.emailaddress.clear();
		this.emailaddress.sendKeys(emailaddress);
		test.info("Entering email address : "+emailaddress.toString());
		//this.password.clear();
		Thread.sleep(15000);
		this.password.sendKeys(password);
		test.info("Entering Password : "+password.toString());
		
	}
	public boolean verifythesigninButton(){
		Forcee.popup();
		test.info("Searching to find the element on the Page  "+loginbutton.toString());
		return loginbutton.isDisplayed();
	}
	public HomePage clickonthesigninButton() throws IOException, InterruptedException{
		Thread.sleep(15000);
		//loginbutton.click();
		Actions action = new Actions(driver);
		action.click(loginbutton).build().perform();
		Thread.sleep(15000);
		
		/*WebElement webElement = driver.findElement(By.id("loginsubmit"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webElement);
		WebElement webElement = driver.findElement(By.id("loginsubmit"));
		Actions builder = new Actions(driver);
		builder.moveToElement(webElement).click(webElement).build().perform();
		
		test.info("Clicked on the Button : "+loginbutton.toString());*/
		return new HomePage();
	}
}
