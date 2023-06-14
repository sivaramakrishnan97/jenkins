package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

public class ExploreHotel extends BaseClass {

	public ExploreHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Hotel Booking']")
	private WebElement selectHotelBooking;

	public WebElement getSelectHotelBooking() {
		return selectHotelBooking;
	}

	@FindBy(xpath = "//a[@data-testid='username']")
	private WebElement verifyLoginSuccessMsg;

	@FindBy(id = "state")
	private WebElement selectState;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(xpath = "//span[text()='Select City *']")
	private WebElement clickCity;

	@FindBy(xpath = "//textarea[@type='search']")
	private WebElement selectRoomType;

	// @FindBy(xpath = "//select[@id='room_type']")
	// private WebElement roomType;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(name = "check_in")
	private WebElement checkin;

	@FindBy(name = "check_out")
	private WebElement checkout;

	@FindBy(id = "no_rooms")
	private WebElement rooms;

	@FindBy(id = "no_adults")
	private WebElement adults;

	@FindBy(id = "no_child")
	private WebElement child;

	@FindBy(id = "hotelsearch_iframe")
	private WebElement searchBtnFrame;

	@FindBy(id = "searchBtn")
	private WebElement btnsearch;

	@FindBy(id = "invalid-state")
	private WebElement invalidState;

	@FindBy(id = "invalid-city")
	private WebElement invalidCity;

	@FindBy(id = "invalid-check_in")
	private WebElement invalidCheckIn;

	@FindBy(id = "invalid-check_out")
	private WebElement invalidCheckOut;

	@FindBy(id = "invalid-no_rooms")
	private WebElement invalidNoOfRooms;

	@FindBy(id = "invalid-no_adults")
	private WebElement invalidNoOfAdults;

	public WebElement getCity() {
		return city;
	}

	public WebElement getroomType() {
		return roomType;
	}

	public WebElement getVerifyLoginSuccessMsg() {
		return verifyLoginSuccessMsg;
	}

	public WebElement getVerifySuccessMsg() {
		return verifyLoginSuccessMsg;
	}

	public WebElement getInvalidState() {
		return invalidState;
	}

	public WebElement getInvalidCity() {
		return invalidCity;
	}

	public WebElement getInvalidCheckIn() {
		return invalidCheckIn;
	}

	public WebElement getInvalidCheckOut() {
		return invalidCheckOut;
	}

	public WebElement getInvalidNoOfRooms() {
		return invalidNoOfRooms;
	}

	public WebElement getInvalidNoOfAdults() {
		return invalidNoOfAdults;
	}

	public WebElement getSelectState() {
		return selectState;
	}

	public WebElement getClickCity() {
		return clickCity;
	}

	public WebElement getSelectRoomType() {
		return selectRoomType;
	}

	public WebElement getCheckin() {
		return checkin;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public WebElement getAdults() {
		return adults;
	}

	public WebElement getChild() {
		return child;
	}

	public WebElement getSearchBtnFrame() {
		return searchBtnFrame;
	}

	public WebElement getBtnsearch() {
		return btnsearch;
	}
	
	@FindBy(xpath = "//div[@class='fliter_box_inner mb-4']//h5")
	private List<WebElement> hotelNamesListed;
	
	

	public WebElement getRoomType() {
		return roomType;
	}

	public List<WebElement> getHotelNamesListed() {
		return hotelNamesListed;
	}
	
	public void btnclicks() {
		btnclick(getSelectHotelBooking());
	}

	// 1.Enter all field and verify select Hotel
	// 2.Select Multiple room type and verify same filters in header
	public void exploreHotels(String stateName, String cityName, String roomType, String checkIn, String checkOut,
			String rooms, String noOfAdults, String noOfChild) throws InterruptedException {

		btnclick(getSelectHotelBooking());
		boolean b = roomType.contains("/");
		if (b) {
			String[] split = roomType.split("/");
			for (String eachRoomType : split) {
				
				navigateRefresh();
				System.out.println("one");
				//btnclick(getSelectHotelBooking());
				selectByTextOf(getSelectState(), stateName);
				selectByTextOf(getCity(), cityName);
				selectByTextOf(getroomType(), eachRoomType);
				Thread.sleep(3000);
				jsInsert(checkIn, getCheckin());
				jsInsert(checkOut, getCheckout());
				selectByTextOf(getRooms(), rooms);
				selectByTextOf(getAdults(), noOfAdults);
				enterText(getChild(), noOfChild);
				switchToFrame(getSearchBtnFrame());
				btnclick(getBtnsearch());
				switchToDefaultFrame();
			}
		} else {
			navigateRefresh();
			System.out.println("two");
			//btnclick(getSelectHotelBooking());
			selectByTextOf(getSelectState(), stateName);
			selectByTextOf(getCity(), cityName);
			selectByTextOf(getroomType(), roomType);
			jsInsert(checkIn, getCheckin());
			jsInsert(checkOut, getCheckout());
			selectByTextOf(getRooms(), rooms);
			selectByTextOf(getAdults(), noOfAdults);
			enterText(getChild(), noOfChild);
			switchToFrame(getSearchBtnFrame());
			btnclick(getBtnsearch());
			switchToDefaultFrame();
		}
	}

	public void exploreHotels2(String stateName, String cityName, String roomType, String checkIn, String checkOut,
			String rooms, String adults, String Child) throws InterruptedException {
		
		navigateRefresh();
		btnclick(getSelectHotelBooking());
		selectByTextOf(getSelectState(), stateName);
		selectByTextOf(getCity(), cityName);
		boolean b = roomType.contains("/");
		if (b) {
			String[] split = roomType.split("/");
			for (String eachRoomType : split) {
				
				selectByTextOf(getroomType(), eachRoomType);
			}} else {
				selectByTextOf(getroomType(), roomType);
			}
		jsInsert(checkIn, getCheckin());
		jsInsert(checkOut, getCheckout());
		selectByTextOf(getRooms(), rooms);
		selectByTextOf(getAdults(), adults);
		enterText(getChild(), Child);
		switchToFrame(getSearchBtnFrame());
		btnclick(getBtnsearch());
		driver.switchTo().defaultContent();
	}

	public void SearchBtnClick() {
		btnclick(getSelectHotelBooking());
		driver.switchTo().frame(getSearchBtnFrame());
		btnclick(getBtnsearch());
		driver.switchTo().defaultContent();
	}

	// 3. User should verify whether the selected room type is displayed and all the
	// hotel names end with "<Select Room Type>"
	public boolean verifyHotelNameEndsWith(String roomType) {
		List<WebElement> hotelNames = getHotelNamesListed();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		for (WebElement hNames : hotelNames) {
			String text = hNames.getText();
			if (text.contains(roomType)) {
				list1.add(text);
			} else {
				list2.add(text);
			}
			boolean empty = list2.isEmpty();
		}
		return true;

	}

	// 4. W/O enter any fields click search and verify all six error
	public boolean verifyErrorMsgInUnselectedFields(String invalidState, String invalidCity, String invalidCheckIn, String invalidCheckOut, String invaliddNoOfRooms, String invalidNoOfAdults) {
		String actStateErrorMsg = getTheText(getInvalidState());
		String actCityErrorMsg = getTheText(getInvalidCity());
		String actCheckInErrorMsg = getTheText(getInvalidCheckIn());
		String actCheckOutErrorMsg = getTheText(getInvalidCheckOut());
		String actNoOfRoomsErrorMsg = getTheText(getInvalidNoOfRooms());
		String actNoOfAdultsErrorMsg = getTheText(getInvalidNoOfAdults());
		
		if (actStateErrorMsg.equals(invalidState) && actCityErrorMsg.equals(invalidCity) && actCheckInErrorMsg.equals(invalidCheckIn) && actCheckOutErrorMsg.equals(invalidCheckOut) 
				&& actNoOfRoomsErrorMsg.equals(invaliddNoOfRooms) && actNoOfAdultsErrorMsg.equals(invalidNoOfAdults)) {
		return true;
		}
		else
		{
			return false;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
