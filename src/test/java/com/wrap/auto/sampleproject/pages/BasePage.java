package com.wrap.auto.sampleproject.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wrap.auto.sampleproject.core.Driver;
import com.wrap.auto.sampleproject.core.EnvironmentConfig;

public class BasePage {

	static WebDriver driver;
	protected static EnvironmentConfig config;

	public BasePage() {
		init();
		PageFactory
				.initElements(new AjaxElementLocatorFactory(driver, 1), this);
	}

	private void init() {
		if (driver == null) {
			System.out.println("driver is null hence creating..."
					+ this.getClass().getName());
			driver = Driver.getWebDriver();
			config = Driver.getEnvConfig();
		}
	}
	
	// Helper Methods
	public boolean isElementExists(By by) {
		boolean isExists = true;
		try {
			driver.findElement(by);
		} catch (NoSuchElementException e) {
			isExists = false;
		}
		return isExists;
	}

	public WebElement customfindElement(By by, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement webElement = wait.until(ExpectedConditions
				.presenceOfElementLocated(by));
		return webElement;
	}

	public boolean isTargetPageLoaded(String title, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.titleContains(title));
	}

	protected void pause(int sec) {

		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public void quit() {
		driver.quit();
	}

}
