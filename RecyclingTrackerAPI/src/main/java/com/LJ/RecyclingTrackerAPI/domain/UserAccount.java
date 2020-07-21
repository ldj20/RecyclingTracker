package com.LJ.RecyclingTrackerAPI.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserAccount {
	
	@Id
	String id;
	String email;
	String password;
	String userType;
	Map<Date, Integer> frequency;
	String employerCode;
	List<String> connectedCodes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Map<Date, Integer> getFrequency() {
		return frequency;
	}
	public void setFrequency(Map<Date, Integer> frequency) {
		this.frequency = frequency;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployerCode() {
		return employerCode;
	}
	public void setEmployerCode(String employerCode) {
		this.employerCode = employerCode;
	}
	public List<String> getConnectedCodes() {
		return connectedCodes;
	}
	public void setConnectedCodes(List<String> connectedCodes) {
		this.connectedCodes = connectedCodes;
	}
}
