package com.cs425.web.model;

public class Person {
	private String name;
	private String emailID;
	
	
	public Person() {
		
	}
	public Person(String name, String emailID) {
		super();
		this.name = name;
		this.emailID = emailID;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	@Override
	public String toString() {
		return String.format("Person [name=%s, emailID=%s]", name, emailID);
	}
	
	

}
