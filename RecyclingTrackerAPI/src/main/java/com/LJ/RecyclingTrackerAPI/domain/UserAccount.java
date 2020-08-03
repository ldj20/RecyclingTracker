package com.LJ.RecyclingTrackerAPI.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Document
@Component
public class UserAccount {
	
	@Id
	String id;
	String fName;
	String lName;
	String email;
	String password;
	Map<Date, Integer> frequency;
	Date creationDate;
	int goal;
	int points;
	
	//autowired constructor for testing
	@Autowired
	public UserAccount() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		Date currDate = new Date();
		fName = "example";
		lName = "example";
		email = "ex@ex.ex";
		password = passwordEncoder.encode("fdsbasd");
		Map<Date, Integer> frequency = new HashMap<Date, Integer>();
		for (int i = 4; i > 0; i--) {
			frequency.put(new Date(currDate.getTime() - i*24*3600*1000l), i+1);
		}
		Date creationDate = currDate;
		goal = 3;
		points = 0;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
}
