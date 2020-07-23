package com.LJ.RecyclingTrackerAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LJ.RecyclingTrackerAPI.domain.UserAccount;
import com.LJ.RecyclingTrackerAPI.service.TrackerService;

@RestController
@RequestMapping("/users")
public class TrackerController {

	@Autowired
	TrackerService trackerService;
	
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
	
	@PutMapping
	public ResponseEntity<?> createOrUpdateUser(@RequestBody UserAccount user) {
		trackerService.createOrUpdateUser(user);
		return new ResponseEntity("Input user succesfully", HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteUser(@RequestParam("id") String id) {
		trackerService.deleteUser(id);
	}
	
}
