package com.weather;



	public class WeatherSummary {
	    private double averageTemp;
	    private double maxTemp;
	    private double minTemp;
	    private String dominantCondition;

	    public WeatherSummary(double averageTemp, double maxTemp, double minTemp, String dominantCondition) {
	        this.averageTemp = averageTemp;
	        this.maxTemp = maxTemp;
	        this.minTemp = minTemp;
	        this.dominantCondition = dominantCondition;
	    }

	    // Getters
	    public double getAverageTemp() {
	        return averageTemp;
	    }

	    public double getMaxTemp() {
	        return maxTemp;
	    }

	    public double getMinTemp() {
	        return minTemp;
	    }

	    public String getDominantCondition() {
	        return dominantCondition;
	    }
	}



