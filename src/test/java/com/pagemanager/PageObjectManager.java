package com.pagemanager;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmation;
import com.pages.ExploreHotel;
import com.pages.LoginPage;
import com.pages.MyBookingPage;
import com.pages.SelectHotel;

public class PageObjectManager {
	private LoginPage loginPage;
	private ExploreHotel exploreHotel;
	private SelectHotel selectHotel;
	private BookHotelPage bookHotelPage;
	private BookingConfirmation bookingConfirmation;
	private MyBookingPage myBookingPage;
	
	public LoginPage getLoginPage() {
		return (loginPage==null)? loginPage = new LoginPage(): loginPage ;
	}
	public ExploreHotel getExploreHotel() {
		return (exploreHotel==null)? exploreHotel =new ExploreHotel(): exploreHotel;
	}
	public SelectHotel getSelectHotel() {
		return (selectHotel==null)? selectHotel=new SelectHotel(): selectHotel;
	}
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage==null)? bookHotelPage=new BookHotelPage(): bookHotelPage;
	}
	
	public BookingConfirmation getBookingConfiramation() {
		return (bookingConfirmation==null)? bookingConfirmation=new BookingConfirmation():bookingConfirmation; 
	}
	public MyBookingPage getMyBookingPage() {
		return (myBookingPage==null)? myBookingPage=new MyBookingPage():myBookingPage;
	}

}
