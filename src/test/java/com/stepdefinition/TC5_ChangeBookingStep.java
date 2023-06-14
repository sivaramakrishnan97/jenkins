package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC5_ChangeBookingStep extends BaseClass {
       PageObjectManager pom= new PageObjectManager();
	
	@Then("User navigate to my booking and enter order Id")
	public void userNavigateToMyBookingAndEnterOrderId() throws InterruptedException {
	pom.getBookingConfiramation().clickMyBooking();
	pom.getMyBookingPage().enterOrderIdInSearchBox();
	Thread.sleep(3000);
	}
	
	@Then("User should verify the Order Id and Hotel Name")
	public void userShouldVerifyTheOrderIdAndHotelName() {
		
		

	}
	@When("User edit booking {string}")
	public void userEditBooking(String dateCheckIn) throws InterruptedException {
		pom.getMyBookingPage().clickEditAndUpdateBooking(dateCheckIn);

	
	}
	@Then("User should verify after Edit Booking success message {string}")
	public void userShouldVerifyAfterEditBookingSuccessMessage(String expUpdateBookingSuccessMsg) {
		String actUpdateBookingSuccessMsg = getTheText(pom.getMyBookingPage().getUpdateBookingSuccessMsg());
       Assert.assertEquals(expUpdateBookingSuccessMsg, actUpdateBookingSuccessMsg);
	
	}



	
	
	
	
	
	
	

}
