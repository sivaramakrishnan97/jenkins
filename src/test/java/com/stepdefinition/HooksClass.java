package com.stepdefinition;




import java.io.FileNotFoundException;
import java.io.IOException;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass{
	
	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException  {
		//getDriver("chrome");
		launchBrowser(getPropertyFileValue("browser"));
		//launchUrl("https://omrbranch.com/");
		launchUrl(getPropertyFileValue("url"));
		maximizeWindow();
		implicitWaits(20);
	}
	
	@After
	public void afterScenario(Scenario scenario) {
			scenario.attach(screeshot(), "images/png", "Every Scenario");
			quitBrowser();
	}
	
	
	
	
	
	
	
	
}
