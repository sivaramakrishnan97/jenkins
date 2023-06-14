package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseclass.BaseClass;
import com.stepdefinition.TC4_BookHotelStep;

public class MyBookingPage extends BaseClass {
	public MyBookingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="search")
	private WebElement txtSearchBox;
	
	@FindBy(xpath="//div[@class='room-code']//span")
	private WebElement bookingIdInMyBookingPage;
	
	
	@FindBy(xpath="//button[@class='edit btn filter_btn']")
	private WebElement editBtnInMyBooking;
	
	
	@FindBy(xpath="//input[@name='check_in']")
	private WebElement updateCheckInTxtBox;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement confirmBtn;
	
	@FindBy(xpath="//li[@class='alertMsg']")
	private WebElement updateAndCancelBookingSuccessMsg;
	
	@FindBy(xpath="//a[@class='cancle btn filter_btn']")
	private WebElement cancelBookingBtn;
	
	
	
	
	
	
	
	public WebElement getUpdateAndCancelBookingSuccessMsg() {
		return updateAndCancelBookingSuccessMsg;
	}


	public WebElement getCancelBookingBtn() {
		return cancelBookingBtn;
	}


	public WebElement getUpdateBookingSuccessMsg() {
		return updateAndCancelBookingSuccessMsg;
	}


	public WebElement getEditBtnInMyBooking() {
		return editBtnInMyBooking;
	}


	public WebElement getUpdateCheckInTxtBox() {
		return updateCheckInTxtBox;
	}


	public WebElement getConfirmBtn() {
		return confirmBtn;
	}


	public WebElement getBookingIdInMyBookingPage() {
		return bookingIdInMyBookingPage;
	}


	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}
	
	
	public void enterOrderIdInSearchBox() {
		TC4_BookHotelStep h= new TC4_BookHotelStep();
		String bookingId1 = h.bookingId;
		System.out.println(bookingId1);
		enterText(getTxtSearchBox(), bookingId1);
		
	}
	
	public void verifyBookingIdInMyBookingPage() {
		String orderId = getTheText(getBookingIdInMyBookingPage());
		
			
	}
	
	public void clickEditAndUpdateBooking(String dateCheckIn) throws InterruptedException {
			btnclick(getEditBtnInMyBooking());
			jsInsert(dateCheckIn, getUpdateCheckInTxtBox());
			Thread.sleep(3000);
			btnclick(getConfirmBtn());
	}
	

	
	
	
	
	
	
	
	
	
	
}
