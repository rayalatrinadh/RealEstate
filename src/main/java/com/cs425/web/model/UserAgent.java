package com.cs425.web.model;

public class UserAgent {
	
	private String email;
	private String jobTitle;
	private String agencyName;
	private String phoneNumber;
	private long userID;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	
	@Override
	public String toString() {
		return String.format("UserAgent [email=%s, jobTitle=%s, agencyName=%s, phoneNumber=%s, userID=%s]", email,
				jobTitle, agencyName, phoneNumber, userID);
	}
	
	
	

}
