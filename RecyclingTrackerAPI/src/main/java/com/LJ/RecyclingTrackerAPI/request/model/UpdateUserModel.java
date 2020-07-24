package com.LJ.RecyclingTrackerAPI.request.model;

import java.util.Date;
import java.util.Map;

public class UpdateUserModel {
	private String fName;
	private String lName;
	private int goal;
	
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
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
}
