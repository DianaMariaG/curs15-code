package ro.fasttrackit.curs15.calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("WHEN sum of 2 integers THEN return sum")
    void testSum() {
        //SETUP
        Calculator calculator = new Calculator();
        //RUN
        int actual = calculator.sum(2,3);
        //ASSERT
        assertThat(actual).isEqualTo(5);
    }
}
