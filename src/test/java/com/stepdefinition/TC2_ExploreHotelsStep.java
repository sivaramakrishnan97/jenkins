package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_ExploreHotelsStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User login {string} and {string}")
	public void userLoginAnd(String username, String password) {
		pom.getLoginPage().login(username, password);
	}

	@Then("user enters {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userEntersAnd(String state, String city, String roomType, String checkIn, String checkOut, String rooms,
			String adults, String child) throws InterruptedException {
		pom.getExploreHotel().exploreHotels2(state, city, roomType, checkIn, checkOut, rooms, adults, child);

	}

	@Then("User should verify success message after Explore hotel {string}")
	public void userShouldVerifySuccessMessageAfterExploreHotel(String expAfterExploreHotelSuccessMsg) {
		WebElement afterExpHotelSuccessMsg = pom.getSelectHotel().getAfterExpHotelSuccessMsg();
		String actAfterExpHotelSuccessMsg = getTheText(afterExpHotelSuccessMsg);
		//System.out.println(actAfterExpHotelSuccessMsg);
		Assert.assertEquals(actAfterExpHotelSuccessMsg, expAfterExploreHotelSuccessMsg);

	}

	@Then("User should verify success message selected room type is present  {string}")
	public void userShouldVerifySuccessMessageSelectedRoomTypeIsPresent(String expRoomTypeInHeader) {
			WebElement verifyFiltersInHeader = pom.getSelectHotel().getVerifyFiltersInHeader();
			String actVerifyFilterInHeader = getTheText(verifyFiltersInHeader);
	//		System.out.println(actVerifyFilterInHeader);
			//Assert.assertEquals(actVerifyFilterInHeader, verifyFiltersInHeader,"verify room type present in header");
		Assert.assertEquals(expRoomTypeInHeader, actVerifyFilterInHeader);
	}

	@Then("User should verify each hotel name ends with selected room type {string}")
	public void userShouldVerifyEachHotelNameEndsWithSelectedRoomType(String expHotelNameEndsWith) throws InterruptedException {
		boolean verifyHotelNameEndsWith = pom.getExploreHotel().verifyHotelNameEndsWith(expHotelNameEndsWith);
		Thread.sleep(5000);
		Assert.assertEquals(verifyHotelNameEndsWith, true);
	}

	@When("user click search button without entering any fields")
	public void userClickSearchButtonWithoutEnteringAnyFields() {
		pom.getExploreHotel().SearchBtnClick();

	}

	@Then("User should verify  error messages in explore hotel page {string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessagesInExploreHotelPageAnd(String expStateError, String expCityError,
			String expCheckInError, String expCheckOutError, String expNoOfRoomsError, String expNoOfAdultsError) throws InterruptedException {
		
		
		String actInalidstateErrorMsg = getTheText(pom.getExploreHotel().getInvalidState());
		String actInalidCityErrorMsg = getTheText(pom.getExploreHotel().getInvalidCity());
		String actInalidCheckInErrorMsg = getTheText(pom.getExploreHotel().getInvalidCheckIn());
		String actInalidCheckOutErrorMsg = getTheText(pom.getExploreHotel().getInvalidCheckOut());
		String actInalidRoomsErrorMsg = getTheText(pom.getExploreHotel().getInvalidNoOfRooms());
		String actInalidAdultsErrorMsg = getTheText(pom.getExploreHotel().getInvalidNoOfAdults());
		
		Assert.assertEquals(expStateError,actInalidstateErrorMsg);
		Assert.assertEquals(expCityError, actInalidCityErrorMsg);
		Assert.assertEquals(expCheckInError, actInalidCheckInErrorMsg);
		Assert.assertEquals(expCheckOutError, actInalidCheckOutErrorMsg);
		Assert.assertEquals(expNoOfRoomsError, actInalidRoomsErrorMsg);
		Assert.assertEquals(expNoOfAdultsError, actInalidAdultsErrorMsg);

	}

}
