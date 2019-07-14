package com.prospect.model;

public class WolframMapping {
	
	private String Location;
    private Double degrePercentage;
    private Double medianIncome;
    private Double percapitaIncome;
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Double getDegrePercentage() {
		return degrePercentage;
	}
	public void setDegrePercentage(Double degrePercentage) {
		this.degrePercentage = degrePercentage;
	}
	public Double getMedianIncome() {
		return medianIncome;
	}
	public void setMedianIncome(Double medianIncome) {
		this.medianIncome = medianIncome;
	}
	public Double getPercapitaIncome() {
		return percapitaIncome;
	}
	public void setPercapitaIncome(Double percapitaIncome) {
		this.percapitaIncome = percapitaIncome;
	}
	@Override
	public String toString() {
		return "WolframMapping [Location=" + Location + ", degrePercentage=" + degrePercentage + ", medianIncome="
				+ medianIncome + ", percapitaIncome=" + percapitaIncome + "]";
	}
	
	

}