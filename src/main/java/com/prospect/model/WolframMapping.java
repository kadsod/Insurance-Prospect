package com.prospect.model;

public class WolframMapping {
	
	private String Location;
    private Double peoplePerHousehold;
    private Double medianHouseholdIncomeAvg;
    private Double perCapitaIncomeAvg;
    private Double collegeDegreeAvg;
    private Double highSchoolDiplomaAvg;
    private Double lessThanHighSchoolDiplomaAvg;
    
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Double getPeoplePerHousehold() {
		return peoplePerHousehold;
	}
	public void setPeoplePerHousehold(Double peoplePerHousehold) {
		this.peoplePerHousehold = peoplePerHousehold;
	}
	public Double getMedianHouseholdIncomeAvg() {
		return medianHouseholdIncomeAvg;
	}
	public void setMedianHouseholdIncomeAvg(Double medianHouseholdIncomeAvg) {
		this.medianHouseholdIncomeAvg = medianHouseholdIncomeAvg;
	}
	public Double getPerCapitaIncomeAvg() {
		return perCapitaIncomeAvg;
	}
	public void setPerCapitaIncomeAvg(Double perCapitaIncomeAvg) {
		this.perCapitaIncomeAvg = perCapitaIncomeAvg;
	}
	public Double getCollegeDegreeAvg() {
		return collegeDegreeAvg;
	}
	public void setCollegeDegreeAvg(Double collegeDegreeAvg) {
		this.collegeDegreeAvg = collegeDegreeAvg;
	}
	public Double getHighSchoolDiplomaAvg() {
		return highSchoolDiplomaAvg;
	}
	public void setHighSchoolDiplomaAvg(Double highSchoolDiplomaAvg) {
		this.highSchoolDiplomaAvg = highSchoolDiplomaAvg;
	}
	public Double getLessThanHighSchoolDiplomaAvg() {
		return lessThanHighSchoolDiplomaAvg;
	}
	public void setLessThanHighSchoolDiplomaAvg(Double lessThanHighSchoolDiplomaAvg) {
		this.lessThanHighSchoolDiplomaAvg = lessThanHighSchoolDiplomaAvg;
	}
	@Override
	public String toString() {
		return "WolframMapping [Location=" + Location + ", peoplePerHousehold=" + peoplePerHousehold
				+ ", medianHouseholdIncomeAvg=" + medianHouseholdIncomeAvg + ", perCapitaIncomeAvg="
				+ perCapitaIncomeAvg + ", collegeDegreeAvg=" + collegeDegreeAvg + ", highSchoolDiplomaAvg="
				+ highSchoolDiplomaAvg + ", lessThanHighSchoolDiplomaAvg=" + lessThanHighSchoolDiplomaAvg + "]";
	}
	
	
    
}