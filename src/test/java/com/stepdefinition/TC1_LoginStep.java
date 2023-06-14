package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC1_LoginStep extends BaseClass {
	
	PageObjectManager pom= new PageObjectManager();
	
	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() {

	}
	@When("User login {string},{string}")
	public void userLogin(String userName, String passWord) {
		pom.getLoginPage().login(userName, passWord);
		
		
	}
	@Then("User should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expLoginSuccessMsg) {
		WebElement txtLoginSuccessMsg = pom.getExploreHotel().getVerifyLoginSuccessMsg();
		String actLoginSuccessMsg = getTheText(txtLoginSuccessMsg);
		Assert.assertEquals("Verify After Login Sucess Msg", expLoginSuccessMsg, actLoginSuccessMsg);
		
	}


	@When("User login with keyboard actions {string},{string}")
	public void userLoginWithKeyboardActions(String userName, String password) {
		pom.getLoginPage().login(userName, password);
		
		
	}

	@Then("User should verify error message after login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String expErrorMsg) {
		WebElement txtInvalidLoginSuccessMsg = pom.getLoginPage().getVerifyInvalidMessage();
		String actInvalidLoginMsg = getTheText(txtInvalidLoginSuccessMsg);
		//Assert.assertEquals("Verify Invalid Login Success Msg", expErrorMsg, actInvalidLoginMsg);
		Assert.assertEquals("Verify Invalid Login Success Msg", expErrorMsg, actInvalidLoginMsg);
	
		
	}






	
	
		




	

}
