package com.weather;

public class WeatherData {
	
	    private Main main;
	    private Weather[] weather;

	    public static class Main {
	        private double temp;
	        private double feels_like;

	        // Getters and setters
	        public double getTemp() {
	            return temp;
	        }

	        public void setTemp(double temp) {
	            this.temp = temp;
	        }

	        public double getFeelsLike() {
	            return feels_like;
	        }

	        public void setFeelsLike(double feels_like) {
	            this.feels_like = feels_like;
	        }
	    }

	    public Weather[] getWeather() {
	        return weather;
	    }

	    public void setWeather(Weather[] weather) {
	        this.weather = weather;
	    }

	    public static class Weather {
	        private String main;

	        public String getMain() {
	            return main;
	        }

	        public void setMain(String main) {
	            this.main = main;
	        }
	    }

	    public Main getMain() {
	        return main;
	    }

	    public void setMain(Main main) {
	        this.main = main;
	    }

		public int getDt() {
			// TODO Auto-generated method stub
			return 0;
		}
	}



