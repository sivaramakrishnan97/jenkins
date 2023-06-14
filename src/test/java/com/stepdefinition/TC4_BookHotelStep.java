package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.checkerframework.checker.index.qual.SubstringIndexFor;
import org.checkerframework.checker.index.qual.SubstringIndexUnknown;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	public static String bookingId;

	@Then("User should verify after booking success message {string} and save the order id")
	public void userShouldVerifyAfterBookingSuccessMessageAndSaveTheOrderId(String expBookingConfirmation) {
		String bookingId1 = getTheText(pom.getBookingConfiramation().getTxtOrderId());
		String repBookingId = bookingId1.replace("#", "");
		bookingId = repBookingId;
		System.out.println(bookingId);
		String actBookingConfiramtionMsg = getTheText(pom.getBookingConfiramation().getBookingConfirmationMsg());
		String substring = actBookingConfiramtionMsg.substring(12,32);
		System.out.println(substring);
		Assert.assertEquals(expBookingConfirmation, substring);
		
	}
	
	@When("User enters the Guest details {string},{string},{string},{string} and {string}")
	public void userEntersTheGuestDetailsAnd(String string, String string2, String string3, String string4,
			String string5) {
		pom.getBookHotelPage().enterGuestDetails(string, string2, string3, string4, string5);

	}
	
	@When("User select should enter the payment details, proceed with card type")
	public void userSelectShouldEnterThePaymentDetailsProceedWithCardType(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		btnclick(pom.getBookHotelPage().getSelectCardMode());
		Thread.sleep(1000);
		List<Map<String, String>> data = dataTable.asMaps();
		Map<String, String> row = data.get(0);
		String cardType1 = row.get("cardType");
		String card = row.get("card");
		String cardNumber = row.get("cardNumber");
		String nameOnCard = row.get("nameOnCard");
		String month = row.get("month");
		String year = row.get("year");
		String cvv = row.get("cvv");

		pom.getBookHotelPage().enterCardDetails(cardType1, card, cardNumber, nameOnCard, month, year, cvv);

	}

	@Then("User should verify booked Hotel name")
	public void userShouldVerifyBookedHotelName() {
     
		//String saveHotelName = pom.getBookHotelPage().saveHotelName();
		//System.out.println(saveHotelName);
		//String hotelNameInConfirmPage = getTheText(pom.getBookingConfiramation().getHotelNameinConfirmationpage());
	//	System.out.println(hotelNameInConfirmPage);
	//	Assert.assertEquals(saveHotelName, hotelNameInConfirmPage);
	}
    //2
	@When("User enter UPI id {string}")
	public void userEnterUPIId(String upiId) {
		pom.getBookHotelPage().enterUpiId(upiId);
	}
	//2
	@Then("User should verify UPI id error message {string}")
	public void userShouldVerifyUPIIdErrorMessage(String expInvalidCardErrorMsg) {
		WebElement upiErrorMsg = pom.getBookHotelPage().getUpiErrorMsg();
		String actUpiErrorMsg = getTheText(upiErrorMsg);
		Assert.assertEquals(expInvalidCardErrorMsg, actUpiErrorMsg);
	}
	//3
	@Then("User should verify invalid card details error message {string}")
	public void userShouldVerifyInvalidCardDetailsErrorMessage(String invalidCardErrorMsg) {
		WebElement invalidCardErrorMsg2 = pom.getBookHotelPage().getInvalidCardErrorMsg();
		String actInvalidCardErrorMsg = getTheText(invalidCardErrorMsg2);
		Assert.assertEquals(invalidCardErrorMsg, actInvalidCardErrorMsg);

	}

	
	// 2

	/*
	 * @When("User select should enter the payment details, proceed with card type {string}"
	 * ) public void
	 * userSelectShouldEnterThePaymentDetailsProceedWithCardType(String string,
	 * io.cucumber.datatable.DataTable dataTable) throws InterruptedException { //
	 * Write code here that turns the phrase above into concrete actions // For
	 * automatic transformation, change DataTable to one of // E, List<E>,
	 * List<List<E>>, List<Map<K,V>>, Map<K,V> or // Map<K, List<V>>. E,K,V must be
	 * a String, Integer, Float, // Double, Byte, Short, Long, BigInteger or
	 * BigDecimal. // // For other transformations you can register a DataTableType.
	 * 
	 * btnclick(pom.getBookHotelPage().getSelectCardMode()); Thread.sleep(1000);
	 * selectByTextOf(pom.getBookHotelPage().getSelectCardType(), string);
	 * List<Map<String, String>> data = dataTable.asMaps(); Map<String, String> row
	 * = data.get(0); //String cardType1= row.get("cardType"); String card =
	 * row.get("card"); String cardNumber = row.get("cardNumber"); String nameOnCard
	 * = row.get("nameOnCard"); String month = row.get("month"); String year =
	 * row.get("year"); String cvv = row.get("cvv");
	 * 
	 * pom.getBookHotelPage().enterCardDetails( card, cardNumber, nameOnCard, month,
	 * year, cvv);
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 */

}
