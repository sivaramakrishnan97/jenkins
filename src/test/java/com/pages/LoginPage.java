package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtuser;
	@FindBy(id = "pass")
	private WebElement txtpass;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;
	@FindBy(xpath = "//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement verifyInvalidMessage;

	public WebElement getTxtuser() {
		return txtuser;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getVerifyInvalidMessage() {
		return verifyInvalidMessage;
	}

	// 1.verifying login with valid credentials
	// 2.verifying login with invalid credentials
	public void login(String username, String password) {
		enterText(txtuser, username);
		enterText(txtpass, password);
		btnclick(btnLogin);
	}

	public void errorMsg(String errorMsg) {
		Assert.assertEquals(getTheText(getVerifyInvalidMessage()), errorMsg);
	}

	// 3.verifying login with robot using keyboard actions
	public void loginWithRobotClass(String username, String password) throws AWTException {
		Robot r = new Robot();
		implicitWaits(40);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		sendkeysViaActiveElement(username);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		sendkeysViaActiveElement(password);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

}
