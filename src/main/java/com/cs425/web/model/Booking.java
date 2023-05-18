package com.cs425.web.model;

import java.util.Date;

public class Booking {
	
	private long bookingID;
	private long userID;
	private long CCID;
	private long propertyID;
	private Date startDate;
	private Date endDate;
	
	
	
	
	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public void setCCID(long cCID) {
		CCID = cCID;
	}
	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getBookingID() {
		return bookingID;
	}
	public long getUserID() {
		return userID;
	}
	public long getCCID() {
		return CCID;
	}
	public long getPropertyID() {
		return propertyID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	
	
	@Override
	public String toString() {
		return String.format("Booking [bookingID=%s, userID=%s, CCID=%s, propertyID=%s, startDate=%s, endDate=%s]",
				bookingID, userID, CCID, propertyID, startDate, endDate);
	}
	
	
	
	

}
