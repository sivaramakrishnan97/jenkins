package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SelectHotel extends BaseClass {
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement btnContinueFirstHotel;

	@FindBy(xpath = "(//div[@class='col-md-5 hotel-suites']//h5)[1]")
	private WebElement firstHotelName;

	

	@FindBy(xpath = "//label[text()='Name Ascending']")
	private WebElement ascRdoBtn;

	@FindBy(xpath = "//label[text()='Deluxe']")
	private WebElement deluxeRdoBtn;

	@FindBy(xpath = "//h5[contains(text(),'Select Hotel')]")
	private WebElement afterExpHotelSuccessMsg;

	@FindBy(xpath = "//strong[@class='total-prize']")
	private List<WebElement> priceList;

	@FindBy(xpath = "//h3[text()='Hotel Booking']") // 3
	private WebElement slctHotelBooking;

	@FindBy(xpath = "(//div[@class='filter_box box_css']//h2)[2]")
	private WebElement roomTypeLable;

	@FindBy(xpath = "(//div[@class='checkbox_comman'])[2]//input[@checked]")
	private List<WebElement> checkedRoomType;

	@FindBy(xpath = "//div[@class='row explore-hotels']//h5")
	private WebElement verifySelectHotelsMsg;

	@FindBy(xpath = "//a[@id='room_type']")
	private WebElement verifyFiltersInHeader;

	@FindBy(xpath = "//div[@class='fliter_box_inner mb-4']//h5")
	private List<WebElement> hotelNamesListed;

	public WebElement getBtnContinueFirstHotel() {
		return btnContinueFirstHotel;
	}

	public WebElement getAscrdoBtn() {
		return ascRdoBtn;
	}

	public WebElement getDeluxe() {
		return deluxeRdoBtn;
	}

	public WebElement getAscRdoBtn() {
		return ascRdoBtn;
	}

	public WebElement getDeluxeRdoBtn() {
		return deluxeRdoBtn;
	}

	public WebElement getAfterExpHotelSuccessMsg() {
		return afterExpHotelSuccessMsg;
	}

	public WebElement getSlctHotelBooking() {
		return slctHotelBooking;
	}

	public WebElement getRoomTypeLable() {
		return roomTypeLable;
	}

	public List<WebElement> getCheckedRoomType() {
		return checkedRoomType;
	}

	public WebElement getVerifySelectHotelsMsg() {
		return verifySelectHotelsMsg;
	}

	public WebElement getVerifyFiltersInHeader() {
		return verifyFiltersInHeader;
	}

	public List<WebElement> getHotelNamesListed() {
		return hotelNamesListed;
	}

	public List<WebElement> getPriceList() {
		return priceList;
	}

	public WebElement getFirstHotelName() {
		return firstHotelName;
	}
	
	public String getHotelName() {
		return hotelName;
	}

	// 1. select hotel and verify navigate to book hotel upon accepting the alert
	// and Save first hotel name
	public void selectHotelWithOK() {
		btnclick(getBtnContinueFirstHotel());
		alertAccept();
	}

	String hotelName = "";

	public String saveTheHotelName() {
		String firstHotelName = getTheText(getFirstHotelName());
		return hotelName = firstHotelName;
	}
	
	public void savedHotelName() {
		
	}

	// 2. select hotel and verify navigating in same page upon dismiss the alert
	public void selectHotelWithCancel() {
		btnclick(getBtnContinueFirstHotel());
		alertDismiss();
	}

	// 3. sort name ascending
	public void clickAscRbtBtn() throws InterruptedException {
		btnclick(getAscrdoBtn());
		//implicitWaits(5);
		Thread.sleep(1000);
	}

	public boolean verifyHotelNameByAsc() {
		
		List<String> lstHotelBeforSort = new ArrayList<String>();
		for (WebElement eachHotelElement : getHotelNamesListed()) {
			String eachHotelName = getTheText(eachHotelElement);
			lstHotelBeforSort.add(eachHotelName);
		}
		
		List<String> lstHotelAfterSort = new ArrayList<String>();
		lstHotelAfterSort.addAll(lstHotelBeforSort);
		Collections.sort(lstHotelAfterSort);
		boolean isHotelNameAsc = lstHotelBeforSort.equals(lstHotelAfterSort);
		return isHotelNameAsc;
	}

	// 4. unSelecting room type and verify listing all hotels

	public boolean verifyHotelNamesAfterUnSelectRoomType() throws InterruptedException {
		boolean isRoomTypeCount=false;
		List<WebElement> hotelNamesListedBefore = getHotelNamesListed();
			int sizeCount = hotelNamesListedBefore.size();
			btnclick(getDeluxeRdoBtn());
			Thread.sleep(1000);
		List<WebElement> hotelNamesListedAfter = getHotelNamesListed();	
		int sizeCountAfter = hotelNamesListedAfter.size();
		if (sizeCount==sizeCountAfter) {
			isRoomTypeCount=true;
		}
				
		return isRoomTypeCount;

	}

}
