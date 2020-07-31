package com.LJ.RecyclingTrackerAPI.domain;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DisplayData {
	private Map<Date, Integer> frequency;
	private String message;
	private boolean background;
	private int points;
	
	public DisplayData(Map<Date, Integer> frequency, String message) {
		this.frequency = frequency;
		this.message = message;
	}
	
	public DisplayData(Map<Date, Integer> frequency, String message, boolean background, int points) {
		this.frequency = frequency;
		this.message = message;
		this.background = background;
		this.points = points;
	}
	
	public DisplayData() {
		
	}
	
	public Map<Date, Integer> getFrequency() {
		return frequency;
	}

	public void setFrequency(Map<Date, Integer> frequency) {
		this.frequency = frequency;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public boolean isBackground() {
		return background;
	}

	public void setBackground(boolean background) {
		this.background = background;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
}
