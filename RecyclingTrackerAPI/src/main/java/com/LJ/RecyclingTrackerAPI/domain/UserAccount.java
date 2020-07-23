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
	String groupCode;
	String connectedCode;
	int goal;
	
	public UserAccount(String email, int goal) {
		this.email = email;
		this.goal = goal;
	}
	
	public UserAccount() {
		
	}
	
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
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getConnectedCode() {
		return connectedCode;
	}
	public void setConnectedCode(String connectedCode) {
		this.connectedCode = connectedCode;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
}
