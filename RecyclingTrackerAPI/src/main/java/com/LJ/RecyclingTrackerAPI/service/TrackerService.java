package com.LJ.RecyclingTrackerAPI.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.LJ.RecyclingTrackerAPI.domain.DisplayData;
import com.LJ.RecyclingTrackerAPI.domain.UserAccount;

public interface TrackerService {

	List<UserAccount> findAll();
	
	DisplayData getDisplayData(String id);
	
	void createUser(UserAccount user);
	
	void updateUserInfo(UserAccount user);
	
	void updateInputs(Map<Date, Integer> frequency);
	
	void deleteUser(String id);
}
