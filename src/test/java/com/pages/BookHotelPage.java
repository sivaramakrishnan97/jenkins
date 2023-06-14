package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookHotelPage extends BaseClass {
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[@class='px-3 py-2']")
	private WebElement bookHotelSucsMsg;
	
	@FindBy(id="own")
	private WebElement mySelfRadBtn;
	
	@FindBy(id="user_title")
	private WebElement selectSalutation;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="user_phone")
	private WebElement phone;
	
	@FindBy(id="user_email")
	private WebElement email;
	
	@FindBy(id="step1next")
	private WebElement nextBtnOne;
	
	@FindBy(id="step2next")
	private WebElement nextBtnTwo;
	
	@FindBy(xpath="//p[text()='Pay Directly From Your Bank Account']")
	private WebElement selectUpiMode;
	
	@FindBy(id="upi_id")
	private WebElement upi;
	
	@FindBy(id="invalid-upi")
	private WebElement upiErrorMsg;
	
	@FindBy(id="invalid-card_no")
	private WebElement invalidCardErrorMsg;
	
	@FindBy(id="submitBtn")
	private WebElement submitBtn;

	@FindBy(xpath="//h5[contains(text(),'Credit')]")
	private WebElement selectCardPaymentMode;
	
	public WebElement getSelectCardPaymentMode() {
		return selectCardPaymentMode;
	}

	@FindBy(xpath = "//select[@name='payment_type']")
	private WebElement selectCardType;
	
	//@FindBy(id="card_type")
	@FindBy(xpath = "//select[@name='card_type']")
	private WebElement selectCard;
	
	@FindBy(id="card_no")
	private WebElement cardNo;
	
	@FindBy(id="card_name")
	private WebElement nameOnCard;
	
	@FindBy(id="card_month")
	private WebElement cardExpMonth;
	
	@FindBy(id="card_year")
	private WebElement cardExpYear;
	
	@FindBy(id="cvv")
	private WebElement cvvOnCard;
	
	
	
	public WebElement getSelectCardType() {
		return selectCardType;
	}
	public WebElement getSelectCard() {
		return selectCard;
	}
	public WebElement getCardNo() {
		return cardNo;
	}
	public WebElement getNameOnCard() {
		return nameOnCard;
	}
	public WebElement getCardExpMonth() {
		return cardExpMonth;
	}
	public WebElement getCardExpYear() {
		return cardExpYear;
	}
	public WebElement getCvvOnCard() {
		return cvvOnCard;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getNextBtnOne() {
		return nextBtnOne;
	}
	public WebElement getNextBtnTwo() {
		return nextBtnTwo;
	}
	public WebElement getSelectUpiMode() {
		return selectUpiMode;
	}
	public WebElement getUpi() {
		return upi;
	}
	public WebElement getUpiErrorMsg() {
		return upiErrorMsg;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getSelectCardMode() {
		return selectCardPaymentMode;
	}
	public WebElement getInvalidCardErrorMsg() {
		return invalidCardErrorMsg;
	}
	
	public WebElement getBookHotelSucsMsg() {
		return bookHotelSucsMsg;
	}
	public WebElement getMySelfRadBtn() {
		return mySelfRadBtn;
	}
	public WebElement getSelectSalutation() {
		return selectSalutation;
	}
	
	
    // 1.Book Hotel W/O including GST - card(credit card-VISA) - W/O special request
	// 3. Enter Invalid card details and verify error message
	public void enterGuestDetails(String salutation, String firstName, String lastName, String mobileNo, String email) {
			btnclick(getMySelfRadBtn());
			selectByTextOf(getSelectSalutation(), salutation);
			jsInsert(firstName, getFirstName());
			jsInsert(lastName, getLastName());
			jsInsert(mobileNo, getPhone());
			jsInsert(email, getEmail());
			btnclick(getNextBtnOne());
			btnclick(getNextBtnTwo());
	}
	
	public void enterCardDetails(String cardType, String cardName, String cardNo, String name, String month,
			String year, String cvv) {
		btnclick(getSelectCardPaymentMode());
		selectByTextOf(getSelectCardType(), cardType);
		selectByTextOf(getSelectCard(), cardName);
		enterText(getCardNo(), cardNo);
		enterText(getNameOnCard(), name);
		selectByTextOf(getCardExpMonth(), month);
		selectByTextOf(getCardExpYear(), year);
		enterText(getCvvOnCard(), cvv);
		btnclick(getSubmitBtn());	
	}
	
	
	public void enterCardDetails2( String cardName, String cardNo, String name, String month,
			String year, String cvv) {
		btnclick(getSelectCardPaymentMode());
		//selectByTextOf(getSelectCardType(), cardType);
		selectByTextOf(getSelectCard(), cardName);
		enterText(getCardNo(), cardNo);
		enterText(getNameOnCard(), name);
		selectByTextOf(getCardExpMonth(), month);
		selectByTextOf(getCardExpYear(), year);
		enterText(getCvvOnCard(), cvv);
		btnclick(getSubmitBtn());
		
	}
	
	/* public static String bookingId = "";
	public void saveBookingId() {
		String bookId = convertToText(getBookingID());
		String id = bookId.replace("#", "");
		bookingId = id;
	}*/
	
	
	
	// 2. Enter invalid UPI Id and verify error message
	
	public void enterUpiId(String upiId) {
		btnclick(getSelectUpiMode());
		jsInsert(upiId, getUpi());
		btnclick(getSubmitBtn());
	}
	
	/*public boolean verifyBooking(String bookingConfirmation) {
		boolean isEqual = false;
	//	String bookingMsg = convertToText(getBookingConfirmationMsg());
	//	String bookedHtlName = convertToText(getBookedHotelName());
	//	if (bookingMsg.contains(bookingConfirmation) && R__SelectHotelPage.hotelName.contains(bookedHtlName)) {
			isEqual = true;
		}
		return isEqual;
	}*/
	

	
		
		public String saveHotelName() {
			WebElement selectedHotelName =getBookHotelSucsMsg();
			String act = getTheText(selectedHotelName);
			String actSelectedHotelName = act.substring(18, act.length()-1);
			System.out.println(actSelectedHotelName);
			return actSelectedHotelName;
		}

	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	

