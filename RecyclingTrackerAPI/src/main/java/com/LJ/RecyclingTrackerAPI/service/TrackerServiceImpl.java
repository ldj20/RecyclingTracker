package com.LJ.RecyclingTrackerAPI.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LJ.RecyclingTrackerAPI.domain.DisplayData;
import com.LJ.RecyclingTrackerAPI.model.User;
import com.LJ.RecyclingTrackerAPI.repositories.AccountRepository;

@Service
public class TrackerServiceImpl implements TrackerService {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	DisplayData testDisplay;
	
	@Override
	public
	List<User> findAll() {
		return accountRepository.findAll();
	}
	
	@Override
	public
	User findByEmail(String email) {
		return accountRepository.findByEmail(email);
	}
	
	@Override
	public
	User findById(String id) {
		Optional<User> returnContent = accountRepository.findById(id);
		if (returnContent.isPresent()) {
			return returnContent.get();
		} 
		return null;
	}
	
	@Override
	public
	DisplayData getDisplayData(String id) {
		return testDisplay;
	}
	
	@Override
	public
	void createOrUpdateUser(User user) {
		accountRepository.save(user);
	}
	
	@Override
	public
	void deleteUser(String id) {
		accountRepository.deleteById(id);
	}

}
