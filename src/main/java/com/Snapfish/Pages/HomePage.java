package com.Snapfish.Pages;

import java.io.IOException;

import com.Snapfish.TestBase.MainLauncher;
import com.Snapfish.Utilities.Forcee;

public class HomePage extends MainLauncher{

	public HomePage() throws IOException {
		
	}

	public boolean getHomePageTitle() {
		Forcee.popup();
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(properties.getProperty("homepagetitle")))
		return true;
		else return false;
	}

}
