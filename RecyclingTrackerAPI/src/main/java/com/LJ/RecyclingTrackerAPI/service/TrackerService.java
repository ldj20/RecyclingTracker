package com.LJ.RecyclingTrackerAPI.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.LJ.RecyclingTrackerAPI.domain.DisplayData;
import com.LJ.RecyclingTrackerAPI.model.User;

public interface TrackerService {

	List<User> findAll();
	
	User findByEmail(String email);
	
	User findById(String id);
	
	DisplayData getDisplayData(String id);
	
	void createOrUpdateUser(User user);
		
	void deleteUser(String id);
}
