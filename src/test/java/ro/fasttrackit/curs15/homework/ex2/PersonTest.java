package ro.fasttrackit.curs15.homework.ex2;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    @Test
    @DisplayName("WHEN null or empty name THEN return n/a")
    public void testGetName() {
        //SETUP
        Person person1 = new Person(1, null, 13);
        Person person2 = new Person(2, "", 44);
        //RUN
        String result1 = person1.getName();
        String result2 = person2.getName();
        //ASSERT
        assertThat(result1).isEqualTo("n/a");
        assertThat(result2).isEqualTo("n/a");
    }

    @Test
    @DisplayName("WHEN invalid age THEN return 1")
    public void testGetAge() {
        //SETUP
        Person person1 = new Person(1, "Ana", 133);
        //RUN + ASSERT
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class,
                () -> person1.getAge());
        assertThat(exc.getMessage()).isEqualTo("Age is not valid");
    }

    @Test
    @DisplayName("WHEN negative id THEN return 0")
    public void testGetId() {
        //SETUP
        Person person1 = new Person(-6, "Ana", 13);
        //RUN
        int actual = person1.getId();
        //ASSERT
        assertThat(actual).isEqualTo(0);
    }


}
