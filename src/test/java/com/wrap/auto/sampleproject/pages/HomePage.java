package com.wrap.auto.sampleproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

	@FindBy(how = How.CLASS_NAME, using = "global-nav_logo-text")
	private WebElement logoText;

	@FindBy(how = How.XPATH, using = "//a[@href='/register']")
	private WebElement freeTrial;

	@FindBy(how = How.XPATH, using = "//a[@href='/login']")
	private WebElement login;

	public HomePage get() {
		driver.get(config.getBaseUrl());
		return this;
	}

	public PricingPage navToFreeTrial() {
		if (freeTrial != null) {
			freeTrial.click();
		}
		return new PricingPage();
	}

	public LoginPage navToLogin() {
		if (login != null) {
			login.click();
		}

		return new LoginPage();
	}

}
