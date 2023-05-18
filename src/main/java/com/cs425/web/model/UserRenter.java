package com.cs425.web.model;

import java.util.Date;

public class UserRenter {
	
	private String email;
	private Date moveInDate;
	private String location;
	private double budget;
	private String rewards;
	private long userID;
	
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getMoveInDate() {
		return moveInDate;
	}
	public void setMoveInDate(Date moveInDate) {
		this.moveInDate = moveInDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getRewards() {
		return rewards;
	}
	public void setRewards(String rewards) {
		this.rewards = rewards;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return String.format("UserRenter [email=%s, moveInDate=%s, location=%s, budget=%s, rewards=%s, userID=%s]",
				email, moveInDate, location, budget, rewards, userID);
	}
	
	
	
	

}
