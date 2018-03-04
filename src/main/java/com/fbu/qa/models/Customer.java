package com.fbu.qa.models;

public class Customer {

	private String fName;
	private String lName;
	private String emailAddressOrMobileNumber;
	private String newPassword;
	private String birthMonth;
	private String birthDay;
	private String birthYear;
	private String gender;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmailAddressOrMobileNumber() {
		return emailAddressOrMobileNumber;
	}
	public void setEmailAddressOrMobileNumber(String emailAddressOrMobileNumber) {
		this.emailAddressOrMobileNumber = emailAddressOrMobileNumber;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
