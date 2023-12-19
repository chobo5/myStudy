public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        System.out.println("------------------------------------------------");
        weatherData.setMeasurement(80, 65, 30.4f);
        System.out.println("------------------------------------------------");
        weatherData.setMeasurement(82, 70, 29.2f);
        System.out.println("------------------------------------------------");
        weatherData.setMeasurement(78, 90, 29.2f);
        System.out.println("------------------------------------------------");


    }
}