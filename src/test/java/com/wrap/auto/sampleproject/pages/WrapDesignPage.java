package com.wrap.auto.sampleproject.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WrapDesignPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@class='wrap-editor-body_tab is-active']")
	private WebElement designTab;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Wrap properties')]")
	private WebElement wrapPropTab;

	@FindBy(how = How.ID, using = "wrap-name")
	private WebElement wrapNameTxtBox;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-success']")
	private WebElement publishBtn;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-success btn-block']")
	private WebElement addImgBtn;

	@FindBy(how = How.XPATH, using = "//h4[@title='testimg.JPG']")
	private WebElement selectImg;

	@FindBy(how = How.XPATH, using = "//button[@class='image-upload_button ng-isolate-scope']")
	private WebElement browseImgBtn;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary ng-binding']")
	private WebElement addbtn;

	public WrapDesignPage saveWrap() {
		//To be implemented
		return this;
	}

	public WrapDesignPage addImage() {
		if (designTab != null) {
			designTab.click();
			addImgBtn.click();

			pause(5);
			addbtn.click();

		}
		return this;

	}

	private void addNewImg() {

		pause(2);
		browseImgBtn.click();
		pause(5);
		
		StringSelection ss = new StringSelection(
				"C:\\Users\\venkatachalams\\Pictures\\scenic\\testimg.JPG");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pause(5);
		addbtn.click();
	}

	public WrapDesignPage nameWrap(String wrapName) {
		if (wrapPropTab != null) {
			wrapPropTab.click();
			wrapNameTxtBox.clear();
			wrapNameTxtBox.sendKeys(wrapName + getCurrentTime());
		}
		return this;
	}

	public WrapDesignPage publishWrap() {
		if (publishBtn != null)
			publishBtn.click();
		return this;
	}

}
