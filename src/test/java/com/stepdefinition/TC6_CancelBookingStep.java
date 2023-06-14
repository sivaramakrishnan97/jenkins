package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC6_CancelBookingStep extends BaseClass {
	
PageObjectManager pom= new PageObjectManager();

	@When("User Cancel the booking")
	public void userCancelTheBooking() throws InterruptedException {
		Thread.sleep(2000);
		btnclick(pom.getMyBookingPage().getCancelBookingBtn());
		alertAccept();
		
		
	
	}
	@Then("User should verify after cancel success message {string}")
	public void userShouldVerifyAfterCancelSuccessMessage(String expCancelBookingSuccessMsg) {
      String actCancelBookingSuccessMsg = getTheText( pom.getMyBookingPage().getUpdateAndCancelBookingSuccessMsg());
	 Assert.assertEquals(expCancelBookingSuccessMsg, actCancelBookingSuccessMsg);
	}



	






	
	
	
	
	
	
	
	
	
	

}
