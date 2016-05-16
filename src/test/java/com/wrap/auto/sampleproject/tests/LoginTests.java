package com.wrap.auto.sampleproject.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
	
  @BeforeMethod
  public void loginTest() { 
	  landingPage = homePage.get()
					 .navToLogin()
					 .loginAs("aaa123@gmail.com")
					 .withPassWord("password123");
  }
  
  @Test(description="Test Flow for creating Wrap from scratch")
  public void createWrapFromScratchTest(){	  
	 designPage =  landingPage.createWrap().fromScratch();
	 if(designPage != null)
		 designPage
		 	.nameWrap("Test Wrap")
		 		.publishWrap();
 }
  
  @Test(description="Test Flow for creating Wrap from Template")
  public void createWrapFromTemplateTest(){	  
	 designPage =  landingPage.createWrap().fromTemplate();
	 if(designPage != null)
		 designPage
		 	.nameWrap("Test Wrap")
		 		.publishWrap();
 }
  

}
