package com.LJ.RecyclingTrackerAPI.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.LJ.RecyclingTrackerAPI.domain.DisplayData;
import com.LJ.RecyclingTrackerAPI.domain.UserAccount;

public interface TrackerService {

	List<UserAccount> findAll();
	
	UserAccount findByEmail(String email);
	
	UserAccount findById(String id);
	
	DisplayData getDisplayData(String id);
	
	void createOrUpdateUser(UserAccount user);
		
	void deleteUser(String id);
}
