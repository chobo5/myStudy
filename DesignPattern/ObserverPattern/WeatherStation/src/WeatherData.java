import java.util.ArrayList;
import java.util.List;

public final class WeatherData implements Subject{
    private List<Observer> observerList;
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;
    public WeatherData() {
//        this.weatherData = new WeatherData();
        observerList = new ArrayList<Observer>();
    }

//    public WeatherData getWeatherData() {
//        if (weatherData == null) {
//            this.weatherData = new WeatherData();
//            return weatherData;
//        } else {
//            return this.weatherData;
//        }
//    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeOberver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observerList) {
            observer.update(this.temperature, this.humidity, this.pressure);
        }
    }

    public void measurementChanged() {
        notifyObserver();
    }

    public void setMeasurement(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}
