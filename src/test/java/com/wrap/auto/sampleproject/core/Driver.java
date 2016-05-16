package com.wrap.auto.sampleproject.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Driver {

	public static WebDriver driver;
	static EnvironmentConfig config;

	public static WebDriver getWebDriver() {

		/* Currently I have hardcoded driver instantiation as chrome. In real projects, it needs to be handled based on system input
		using factory pattern or simple switch statements.*/		
		try {

			System.setProperty("webdriver.chrome.driver", "src/test/resource/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			initConfig();

		} catch (Exception e) { 
			throw new RuntimeException("Web driver failed to initialize" + e.getMessage());
		}

		return driver;
	}

	public static EnvironmentConfig getEnvConfig() {
		initConfig();
		return config;
	}

	private static void initConfig() {
		if (config == null)
			config = EnvironmentConfigLoader.getInstance().getConfig();
	}

	public void quit() {
		driver.quit();
	}

}
