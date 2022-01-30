package ro.fasttrackit.curs15.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureConvertorTest {
    @Test
    @DisplayName("WHEN temperature in Fahrenheit THEN return temperature in Celsius")
    void testGetCelsius() {
        //SETUP
        TemperatureConvertor temperatureConvertor = new TemperatureConvertor();
        //RUN
        double actual1 = temperatureConvertor.fahrenheitToCelsius(14);
        //ASSERT
        assertThat(actual1).isEqualTo(-10);
    }

    @Test
    @DisplayName("WHEN temperature in Celsius THEN return temperature in Fahrenheit")
    void testGetFahrenheit() {
        //SETUP
        TemperatureConvertor temperatureConvertor = new TemperatureConvertor();
        //RUN
        double actual2 = temperatureConvertor.celsiusToFahrenheit(10);
        //ASSERT
        assertThat(actual2).isEqualTo(50);
    }
    @Test
    @DisplayName("WHEN temperature is extreme THEN return converted temperature")
    void testExtremeTemperature() {
        //SETUP
        TemperatureConvertor temperatureConvertor = new TemperatureConvertor();
        //RUN
        double actual1 = temperatureConvertor.fahrenheitToCelsius(10000000);
        double actual2 = temperatureConvertor.celsiusToFahrenheit(-150000000);
        //ASSERT
        assertThat(actual1).isEqualTo(5555537.777777778);
        assertThat(actual2).isEqualTo(-269999968);
    }
    @Test
    @DisplayName("WHEN temperature is Integer.MAX_VALUE THEN return converted temperature")
    void testMaximumTemperature() {
        //SETUP
        TemperatureConvertor temperatureConvertor = new TemperatureConvertor();
        //RUN
        double actual1 = temperatureConvertor.fahrenheitToCelsius(Integer.MAX_VALUE);
        double actual2 = temperatureConvertor.celsiusToFahrenheit(Integer.MAX_VALUE);
        //ASSERT
        assertThat(actual1).isEqualTo(1.1930464527777777E9);
        assertThat(actual2).isEqualTo(3.8654705966E9);
    }
    @Test
    @DisplayName("WHEN temperature is Integer.MIN_VALUE THEN return converted temperature")
    void testMinimumTemperature() {
        //SETUP
        TemperatureConvertor temperatureConvertor = new TemperatureConvertor();
        //RUN
        double actual1 = temperatureConvertor.fahrenheitToCelsius(Integer.MIN_VALUE);
        double actual2 = temperatureConvertor.celsiusToFahrenheit(Integer.MIN_VALUE);
        //ASSERT
        assertThat(actual1).isEqualTo(-1.1930464888888888E9);
        assertThat(actual2).isEqualTo(-3.8654705344E9);
    }
}
