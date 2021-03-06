package com.LJ.RecyclingTrackerAPI.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.LJ.RecyclingTrackerAPI.domain.DisplayData;
import com.LJ.RecyclingTrackerAPI.model.User;
import com.LJ.RecyclingTrackerAPI.service.TrackerService;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;

@RestController
@RequestMapping("/services")
public class ServicesController {
	
	@Autowired
	private TrackerService trackerService;
	@Autowired 
	private CloudVisionTemplate cloudVisionTemplate;

	@RequestMapping("/getLabelDetection")
	public Map<String, Float> getLabelDetection(@RequestBody String img) {
		
		String imageDataBytes = img.substring(img.indexOf(",")+1);
		byte[] byteArray = Base64.getDecoder().decode(imageDataBytes);
		Resource imageResource = new ByteArrayResource(byteArray);
		AnnotateImageResponse results = this.cloudVisionTemplate.analyzeImage(
		                                    imageResource, Feature.Type.LABEL_DETECTION);
		Map<String, Float> imageLabels =
			    results
			        .getLabelAnnotationsList()
			        .stream()
			        .collect(
			            Collectors.toMap(
			                EntityAnnotation::getDescription,
			                EntityAnnotation::getScore,
			                (u, v) -> {
			                  throw new IllegalStateException(String.format("Duplicate key %s", u));
			                },
			                LinkedHashMap::new));
		return imageLabels;
	}
	
	//sends an object with only the necessary components for a dashboard
	@GetMapping("/{id}")
	public ResponseEntity<?> getDisplayData(@PathVariable("id") String id) {
		User result = trackerService.findById(id);
		//uncomment below line and comment above line to test various different values for UserAccount
		//UserAccount result = testUser;
		
		String message = "You still have some habits to build up. Keep at it!";
		Boolean background = false;
		if (result.getPoints() > 0) {
			message = "You've been recycling well and reaching your goal! Keep it up!";
			background = true;
		}
		
		DisplayData returnData = new DisplayData(result.getFrequency(), message, background, result.getPoints());
		
		return new ResponseEntity(returnData, HttpStatus.OK);
	}	
}
