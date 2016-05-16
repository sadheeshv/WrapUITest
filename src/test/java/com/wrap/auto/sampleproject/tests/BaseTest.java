package com.wrap.auto.sampleproject.tests;

import org.testng.annotations.AfterClass;

import com.wrap.auto.sampleproject.pages.HomePage;
import com.wrap.auto.sampleproject.pages.LandingPage;
import com.wrap.auto.sampleproject.pages.WrapDesignPage;

public class BaseTest {
	HomePage homePage;
	LandingPage landingPage;
	WrapDesignPage designPage;

	public BaseTest() {
		homePage = new HomePage();
	}

	protected void pause(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	  @AfterClass
	  public void quitApplication(){
		  homePage.quit();
	  } 
}
