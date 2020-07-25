package com.LJ.RecyclingTrackerAPI.request.model;

import java.util.Date;
import java.util.Map;

public class OverallUpdateModel {
	private UpdateUserModel updatedDetails;
	private String updatedPassword;
	private Map<Date, Integer> updatedFrequency;
	
	public UpdateUserModel getUpdatedDetails() {
		return updatedDetails;
	}
	public void setUpdatedDetails(UpdateUserModel updatedDetails) {
		this.updatedDetails = updatedDetails;
	}
	public String getUpdatedPassword() {
		return updatedPassword;
	}
	public void setUpdatedPassword(String updatedPassword) {
		this.updatedPassword = updatedPassword;
	}
	public Map<Date, Integer> getUpdatedFrequency() {
		return updatedFrequency;
	}
	public void setUpdatedFrequency(Map<Date, Integer> updatedFrequency) {
		this.updatedFrequency = updatedFrequency;
	}
}
