package com.Snapfish.Utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Snapfish.TestBase.MainLauncher;

public class Forcee extends MainLauncher{
	
	public Forcee() throws IOException {
		
	}

	public static void popup(){
		
		try{
			driver.findElement(By.xpath("//div[@id='acsMainInvite']/div/p[3]/a[@text()='No, thanks']")).click();
			
		}catch(Exception e){
			
		}
		
	}

}
