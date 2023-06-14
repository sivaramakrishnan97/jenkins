package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookingConfirmation  extends BaseClass{

	public BookingConfirmation() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//strong[contains(text(),'#')]")
	private WebElement txtOrderId;
	
	@FindBy(xpath="//button[contains(text(),'My Booking')]")
	private WebElement btnMyBooking;
	
	@FindBy(xpath="//p[text()='Hotel ']//strong")
	private WebElement hotelNameinConfirmationpage;
	
	@FindBy(xpath="//h2[contains(text(),'Booking is Confirmed')]")
	private WebElement bookingConfirmationMsg;
	
	
	
	public WebElement getBookingConfirmationMsg() {
		return bookingConfirmationMsg;
	}

	public WebElement getHotelNameinConfirmationpage() {
		return hotelNameinConfirmationpage;
	}

	public WebElement getBtnMyBooking() {
		return btnMyBooking;
	}

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}
	
	public void clickMyBooking() {
		btnclick(getBtnMyBooking());
	}
	
	
	//Get orderId and return it
	public String getOrderId() {
		String orderId = getTxtOrderId().getText();
		return orderId;
	}
	
	
}
