package com.wrap.auto.sampleproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@class='wraps']//button[@type='button']")
	private WebElement addNewWrapBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='modal-dialog']")
	private WebElement createFromScratchPanel;

	@FindBy(how = How.XPATH, using = "//button[@class='wrap-settings_from-scratch-button btn btn-success ng-binding']")
	private WebElement createFromScratchBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='wrap-settings_grouped-category ng-scope' and position()=1]")
	private WebElement template;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-success ng-binding'])[2]")
	private WebElement createWrapBtn;

	public LandingPage createWrap() {
		if (addNewWrapBtn != null)
			addNewWrapBtn.click();
		pause(5); //Can be handled using webdriver explicit wait
		return this;
	}

	public WrapDesignPage fromScratch() {

		if (createFromScratchBtn != null) {
			createFromScratchPanel.click();
			createFromScratchBtn.click();
			pause(10);
		}

		return (driver.getCurrentUrl().contains("design")) ? new WrapDesignPage()
				: null;

	}

	public WrapDesignPage fromTemplate() {
		if (template != null)
			template.click();
		createWrapBtn.click();
		pause(10);
		return new WrapDesignPage();
	}

}
