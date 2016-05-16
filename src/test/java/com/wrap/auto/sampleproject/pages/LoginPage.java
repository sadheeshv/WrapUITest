package com.wrap.auto.sampleproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@class='auth']//input[@placeholder='Email or username']")
	private WebElement userNameField;

	@FindBy(how = How.XPATH, using = "//div[@class='auth']//input[@placeholder='Password']")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//div[@class='auth']//button[@type='submit']")
	private WebElement loginBtn;

	public LoginPage loginAs(String userName) {
		if (userNameField != null) {
			userNameField.sendKeys(userName);
		}

		return this;
	}

	public LandingPage withPassWord(String pwd) {
		boolean isLoginSuccess = false;
		passwordField.sendKeys(pwd);
		loginBtn.click();
		pause(5);
		System.out.println("curret title..." + driver.getTitle()); // logger.info statement
		isLoginSuccess = isTargetPageLoaded("Wrap Authoring", 5);
		Assert.assertEquals(true, isLoginSuccess, "Login failed");
		pause(5);
		return isLoginSuccess ? new LandingPage() : null;
	}

}
