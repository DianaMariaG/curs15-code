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
}
