package com.LJ.RecyclingTrackerAPI.domain;

import java.util.Date;
import java.util.Map;

public class DisplayData {
	private Map<Date, Integer> frequency;
	private String message;
	
	public Map<Date, Integer> getFrequency() {
		return frequency;
	}

	public String getMessage() {
		return message;
	}
	
}
