package ro.fasttrackit.curs15.homework;
//    T(°C) = (T(°F) - 32) × 5/9
//    T(°F) = T(°C) x 9/5 + 32
public class TemperatureConvertor {

    public double fahrenheitToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    public double celsiusToFahrenheit(double temperature) {
        return temperature * 9 / 5 + 32;
    }
}
