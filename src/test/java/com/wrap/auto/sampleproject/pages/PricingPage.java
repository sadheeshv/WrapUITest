package com.wrap.auto.sampleproject.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PricingPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//a[@class='pricing-cta ng-scope ng-isolate-scope']")
	private WebElement signUp;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "//button[@class='o-auth-button']")
	private WebElement submitBtn;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Create a username']")
	private WebElement userName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='First Name *']")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Last Name *']")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Company *']")
	private WebElement company;

	PricingPage() {
		System.out.println("page url in pricing page" + driver.getCurrentUrl()); // logger info
	}

	public PricingPage signupUsingEmail(String emailID) {
		if (signUp != null) {
			signUp.click();
			email.sendKeys(emailID);
			submitBtn.click();

		}
		return this;
	}

	public PricingPage withUser(String user) {
		if (userName != null) {
			userName.sendKeys(user);

		}
		return this;
	}

	public PricingPage withPassword(String pwd) {
		if (password != null) {
			password.sendKeys(pwd);
			submitBtn.click();
			pause(6);
			submitBtn.click();
		}
		return this;
	}

	public PricingPage and() {
		return this;
	}

	public PricingPage createAccount(Map<String, String> accountDetails) {
		if (firstName != null) {
			firstName.sendKeys(accountDetails.get("firstName"));
			lastName.sendKeys(accountDetails.get("lastName"));
			company.sendKeys(accountDetails.get("company"));
			submitBtn.click();
		}

		return this;
	}

}
