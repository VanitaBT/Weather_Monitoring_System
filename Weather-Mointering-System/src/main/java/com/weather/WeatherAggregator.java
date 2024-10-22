package com.weather;



	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class WeatherAggregator {
	    private Map<String, List<Double>> dailyTemperatures = new HashMap<>();
	    private Map<String, Integer> dominantWeatherCounts = new HashMap<>();

	    public void addWeatherData(String date, WeatherData data) {
	        dailyTemperatures.putIfAbsent(date, new ArrayList<>());
	        dailyTemperatures.get(date).add(data.getMain().getTemp());

	        String weatherCondition = data.getWeather()[0].getMain();
	        dominantWeatherCounts.put(weatherCondition, dominantWeatherCounts.getOrDefault(weatherCondition, 0) + 1);
	    }

	    public WeatherSummary getDailySummary(String date) {
	        List<Double> temps = dailyTemperatures.get(date);
	        if (temps == null || temps.isEmpty()) return null;

	        double sum = temps.stream().mapToDouble(Double::doubleValue).sum();
	        double avg = sum / temps.size();
	        double max = temps.stream().mapToDouble(Double::doubleValue).max().orElse(Double.NaN);
	        double min = temps.stream().mapToDouble(Double::doubleValue).min().orElse(Double.NaN);

	        String dominantCondition = dominantWeatherCounts.entrySet().stream()
	            .max(Map.Entry.comparingByValue())
	            .map(Map.Entry::getKey)
	            .orElse("Unknown");

	        return new WeatherSummary(avg, max, min, dominantCondition);
	    }
	}



