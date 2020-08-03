package com.LJ.RecyclingTrackerAPI.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LJ.RecyclingTrackerAPI.domain.DisplayData;
import com.LJ.RecyclingTrackerAPI.domain.UserAccount;
import com.LJ.RecyclingTrackerAPI.request.model.OverallUpdateModel;
import com.LJ.RecyclingTrackerAPI.request.model.UpdateUserModel;
import com.LJ.RecyclingTrackerAPI.service.TrackerService;

@RestController
@RequestMapping("/users")
public class TrackerController {
	
	@Autowired
	private TrackerService trackerService;
	@Autowired
	private UserAccount testUser;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		List<UserAccount> result = trackerService.findAll();
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id) {
		UserAccount result = trackerService.findById(id);
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@GetMapping("/display/{id}")
	public ResponseEntity<?> getDisplayData(@PathVariable("id") String id) {
		UserAccount result = trackerService.findById(id);
		
		//uncomment below line and comment above line to test various different values for UserAccount
		//UserAccount result = testUser;
		
		String message = "You still have some habits to build up, but you'll get there eventually!";
		Boolean background = false;
		if (result.getPoints() > 0) {
			message = "You've been recycling well and reaching your goal! Keep it up!";
			background = true;
		}
		
		DisplayData returnData = new DisplayData(result.getFrequency(), message, background, result.getPoints());
		
		return new ResponseEntity(returnData, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserAccount user) {
		String pw_hash = passwordEncoder.encode(user.getPassword());
		user.setPassword(pw_hash);
		trackerService.createOrUpdateUser(user);
		return new ResponseEntity("Input user succesfully", HttpStatus.OK);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> updateUser(@PathVariable String id, @Valid @RequestBody OverallUpdateModel update) {
		UserAccount user = trackerService.findById(id);
		if (update.getUpdatedDetails() != null) {
			user = updateUserDetails(user, update.getUpdatedDetails());
		} else if (update.getUpdatedPassword() != null) {
			user = updateUserPassword(user, update.getUpdatedPassword());
		} else {
			user = updateUserFrequency(user, update.getUpdatedFrequency());
		}
		
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	public UserAccount updateUserDetails(UserAccount user, UpdateUserModel updatedDetails) {
		user.setfName(updatedDetails.getfName());
		user.setlName(updatedDetails.getlName());
		user.setGoal(updatedDetails.getGoal());
		
		trackerService.createOrUpdateUser(user);
		return user;
	}
	
	public UserAccount updateUserPassword(UserAccount user, String updatedPassword)
	{
		user.setPassword(updatedPassword);
		
		trackerService.createOrUpdateUser(user);
		return user;
	}
	
	public UserAccount updateUserFrequency(UserAccount user, Map<Date, Integer> updatedFrequency)
	{
		user.setFrequency(updatedFrequency);
		
		trackerService.createOrUpdateUser(user);
		return user;
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteUser(@RequestParam("id") String id) {
		trackerService.deleteUser(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
