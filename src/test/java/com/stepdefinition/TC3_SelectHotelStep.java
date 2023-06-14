package com.stepdefinition;

import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC3_SelectHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
    String HotelName;
	// 1
	@When("User select the first hotel and save the hotel name")
	public void userSelectTheFirstHotelAndSaveTheHotelName() {
		pom.getSelectHotel().selectHotelWithOK();
		String firstHotelName = pom.getSelectHotel().saveTheHotelName();
		HotelName=firstHotelName;
	}

	// 1
	@Then("User should verify success message after Select hotel {string}")
	public void userShouldVerifySuccessMessageAfterSelectHotel(String expBookHotelSuccessMsg) {
		boolean isEqual = false;
		WebElement bookHotelMsg = pom.getBookHotelPage().getBookHotelSucsMsg();
		String bookHotelSuccMsgTxt = getTheText(bookHotelMsg);
		if (bookHotelSuccMsgTxt.contains(expBookHotelSuccessMsg)
				&& bookHotelSuccMsgTxt.contains(getTheText(pom.getSelectHotel().getFirstHotelName()))) {
			isEqual = true;
		} else {
			isEqual = false;
		}
		Assert.assertEquals(true, isEqual);
	}

	// 2
	@When("User select the first hotel name and dismiss the alert")
	public void userSelectTheFirstHotelNameAndDismissTheAlert() {
		pom.getSelectHotel().selectHotelWithCancel();

	}

	// 2
	@Then("User should remain in same page and verify success message in select hotel {string}")
	public void userShouldRemainInSamePageAndVerifySuccessMessageInSelectHotel(String expSelectHotelMsg) {
		WebElement afterExpHotelSuccessMsg = pom.getSelectHotel().getAfterExpHotelSuccessMsg();
		String actAfterExpHotelSuccessMsg = getTheText(afterExpHotelSuccessMsg);
		Assert.assertEquals(expSelectHotelMsg, actAfterExpHotelSuccessMsg);

	}

	// 3
	@When("User click the sort by name ascending")
	public void userClickTheSortByNameAscending() throws InterruptedException {
		pom.getSelectHotel().clickAscRbtBtn();

	}

	// 3
	@Then("User should verify hotel names are displayed in ascending order")
	public void userShouldVerifyHotelNamesAreDisplayedInAscendingOrder() {
		boolean verifyHotelNameByAsc = pom.getSelectHotel().verifyHotelNameByAsc();
		System.out.println(verifyHotelNameByAsc);
		Assert.assertEquals(true, verifyHotelNameByAsc);

	}

	// 4
	@When("User unselect room type")
	public void userUnselectRoomType() {
       btnclick(pom.getSelectHotel().getDeluxeRdoBtn());
	}

	// 4
	@Then("User should verify all hotel names should be displayed")
	public void userShouldVerifyAllHotelNamesShouldBeDisplayed() throws InterruptedException {
  boolean hotelNamesAfterUnSelectRoomType = pom.getSelectHotel().verifyHotelNamesAfterUnSelectRoomType();
 System.out.println(hotelNamesAfterUnSelectRoomType);
  Assert.assertEquals(true, hotelNamesAfterUnSelectRoomType);
	}

}
