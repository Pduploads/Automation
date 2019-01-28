package com.Snapfish.Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Snapfish.TestBase.MainLauncher;
import com.google.common.io.Files;

import net.bytebuddy.utility.RandomString;


public class ScreenShot extends MainLauncher{
	
	public ScreenShot() throws IOException {
		
		// TODO Auto-generated constructor stub
	}

	public static String takeScreenshot(String method) throws IOException{
		
		String loc = projectLocation +"\\FailedScreenShots\\" +method+System.currentTimeMillis()+".jpg";
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File(loc));
		return loc;
	}

	

}
