package com.prospect.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.poiji.annotation.ExcelCell;

public class Form {
	
	@ExcelCell(0)
    private String firstName;
	@ExcelCell(1)
    private String lastName;
	@ExcelCell(2)
	private String gender;
	@ExcelCell(3)
    private Long mobileNumber;
	@ExcelCell(4)
    private String emailId;
	@ExcelCell(5)
    private String zip;
	@ExcelCell(6)
    private String enquiryMessage;
	@ExcelCell(7)
	@DateTimeFormat(iso = ISO.DATE_TIME)
    private Date userDate;
    
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	
    
}