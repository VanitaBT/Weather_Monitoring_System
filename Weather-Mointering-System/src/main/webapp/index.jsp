
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Weather Monitoring System</title>
</head>
<body>
    <h1>Weather Monitoring System</h1>
    <form method="get" action="weather">
        <label for="city">Enter City:</label>
        <input type="text" id="city" name="city">
        <button type="submit">Get Weather</button>
    </form>

    <div id="weather">
        <h2>Current Weather Data</h2>
        <p>Temperature: ${weatherData.main.temp} °C</p>
        <p>Feels Like: ${weatherData.main.feels_like} °C</p>
        <p>Condition: ${weatherData.weather[0].main}</p>
    </div>

    <div id="summary">
        <h2>Daily Summary</h2>
        <p>Average Temperature: ${dailySummary.averageTemp} °C</p>
        <p>Max Temperature: ${dailySummary.maxTemp} °C</p>
        <p>Min Temperature: ${dailySummary.minTemp} °C</p>
        <p>Dominant Condition: ${dailySummary.dominantCondition}</p>
    </div>
</body>
</html>
