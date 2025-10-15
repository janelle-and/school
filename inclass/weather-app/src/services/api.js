import axios from 'axios';

export const getWeatherData = async (city) => {
    const API_KEY = "de86f4608844ceab8440ad1252244427";
    const URL = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}&units=metric`;
    try {
        const response = await axios.get(URL);
        return response.data; // Return the weather data
    } catch (error) {
        console.error("Error fetching weather data:", error);
        return null; // Return null in case of error
    }
};