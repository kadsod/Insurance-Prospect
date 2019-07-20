package com.prospect.model;

public class Form {

    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String emailId;
    private String zip;
    private String enquiryMessage;
    private String gender;
	public String response;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEnquiryMessage() {
		return enquiryMessage;
	}
	public void setEnquiryMessage(String enquiryMessage) {
		this.enquiryMessage = enquiryMessage;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "Form [firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", zip=" + zip + ", enquiryMessage=" + enquiryMessage + ", gender=" + gender
				+ ", setResponse=" + response + "]";
	}	
    
}