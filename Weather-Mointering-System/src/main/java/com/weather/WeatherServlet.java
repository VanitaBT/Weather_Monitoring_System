package com.weather;


import com.fasterxml.jackson.databind.ObjectMapper;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.web.client.RestTemplate;
	import java.io.IOException;
	import java.util.Date;
	import java.text.SimpleDateFormat;

	@WebServlet("/weather")
	public class WeatherServlet extends HttpServlet {
	   
	    private WeatherAggregator aggregator = new WeatherAggregator();
	    private AlertService alertService = new AlertService(35.0); // Example threshold

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String city = request.getParameter("city");
	        if (city == null || city.isEmpty()) {
	            city = "Delhi"; // Default city
	        }
	        final String API_KEY = "<your_api_key>";
		    final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric";

	        RestTemplate restTemplate = new RestTemplate();
	        String url = String.format(API_URL, city, API_KEY);
	        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);

	        // Add to aggregator
	        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(weatherData.getDt() * 1000));
	        aggregator.addWeatherData(date, weatherData);

	        // Check for alerts
	        if (alertService.checkAlert(weatherData.getMain().getTemp())) {
	            System.out.println("Alert: Temperature exceeded threshold!");
	        }

	        // Forward to the index page
	        request.setAttribute("weatherData", weatherData);
	        request.setAttribute("dailySummary", aggregator.getDailySummary(date));
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
	    }
	}


