package com.weather;



	public class AlertService {
	    private double temperatureThreshold;

	    public AlertService(double temperatureThreshold) {
	        this.temperatureThreshold = temperatureThreshold;
	    }

	    public boolean checkAlert(double currentTemp) {
	        return currentTemp > temperatureThreshold;
	    }
	}



