import React, { useState } from "react";
import { getWeatherData } from '../services/api';

function Weather() {
    //state variables for city input, weather data, loading state, and error message
    const [city, setCity] = useState("");
    const [weather, setWeather] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    //function to fetch weather data when button is clicked
    const handleFetchWeather = async () => {
        if (!city){
            setError("Please enter a city name.");
            return;
        }
        setLoading(true); //show loading state
        setError(""); // clear previous errors
        const data = await getWeatherData(city);
        setLoading(false); // hide loading state

        if(data){
            setWeather(data); //store the fetched data in state
        }
        else{
            setError("Failed to fetch weather data. Please try again.");
        }
    };

    return(
        <div style={{textAlign: 'center', marginTop: '50px'}}>
            <h1>⛅ Simple Weather App</h1>

            {/* inpute field for city name */}
            <input
                type="text"
                value={city}
                onChange={(e) => setCity(e.target.value)}
                placeholder="Enter city name"
                style={{padding: '10px', fontSize: '16px'}}
            />
            <button 
                onClick={handleFetchWeather} 
                style={{padding: '10px', marginLeft: '10px', fontSize: '16px'}}>
                    Get Weather
            </button>

            {/* Display loading message */}
            {loading && <p>Loading weather data...</p>}

            {/* Display error message */}
            {error && <p style={{ color: 'red' }}>{error}</p>}

            {/* Display weather info if available */}
            {weather && (
                <div style={{marginTop: '20px'}}>
                    <h2>Weather in {weather.name}</h2>
                    <p>Temperature: {weather.main.temp} °C</p>
                    <p>Condition: {weather.weather[0].description}</p>
                    <p>Wind Speed: {weather.wind.speed} m/s</p>
                </div>
            )}
        </div>
    )
}

export default Weather;

