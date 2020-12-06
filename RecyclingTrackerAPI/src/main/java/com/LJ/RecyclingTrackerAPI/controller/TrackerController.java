package com.LJ.RecyclingTrackerAPI.controller;

import java.util.Date;
import java.util.HashMap;
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
import com.LJ.RecyclingTrackerAPI.model.User;
import com.LJ.RecyclingTrackerAPI.request.model.OverallUpdateModel;
import com.LJ.RecyclingTrackerAPI.request.model.UpdateUserModel;
import com.LJ.RecyclingTrackerAPI.service.TrackerService;

@RestController
@RequestMapping("/users")
public class TrackerController {
	
	@Autowired
	private TrackerService trackerService;
	@Autowired
	private User testUser;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		List<User> result = trackerService.findAll();
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id) {
		User result = trackerService.findById(id);
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		String pw_hash = passwordEncoder.encode(user.getPassword());
		user.setPassword(pw_hash);
		user.setPoints(0);
		user.setCreationDate(new Date());
		user.setFrequency(new HashMap<Date, Integer>());
		trackerService.createOrUpdateUser(user);
		return new ResponseEntity("Input user succesfully", HttpStatus.OK);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> updateUser(@PathVariable String id, @Valid @RequestBody OverallUpdateModel update) {
		User user = trackerService.findById(id);
		if (update.getUpdatedDetails() != null) {
			user = updateUserDetails(user, update.getUpdatedDetails());
		} else if (update.getUpdatedPassword() != null) {
			user = updateUserPassword(user, update.getUpdatedPassword());
		} else {
			user = updateUserFrequency(user, update.getUpdatedFrequency());
		}
		
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	public User updateUserDetails(User user, UpdateUserModel updatedDetails) {
		user.setfName(updatedDetails.getfName());
		user.setlName(updatedDetails.getlName());
		user.setGoal(updatedDetails.getGoal());
		
		trackerService.createOrUpdateUser(user);
		return user;
	}
	
	public User updateUserPassword(User user, String updatedPassword) {
		user.setPassword(updatedPassword);
		
		trackerService.createOrUpdateUser(user);
		return user;
	}
	
	public User updateUserFrequency(User user, Map<Date, Integer> updatedFrequency) {
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
