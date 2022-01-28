package ro.fasttrackit.curs15.homework.ex2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    @Test
    @DisplayName("WHEN null or empty name THEN throw exception")
    public void testGetNullOrEmptyName() {

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class,
                () -> new Person("",22));
        assertThat(exc.getMessage()).isEqualTo("Name is not valid!");
        }

    @Test
    @DisplayName("WHEN name is given THEN return it")
    public void testGetName() {
        //SETUP
        Person person1 = new Person("Rose",12);
        //RUN
        String actual = person1.getName();
        //ASSERT
        assertThat(actual).isEqualTo("Rose");
    }

    @Test
    @DisplayName("WHEN invalid age THEN throw exception")
    public void testGetInvalidAge() {

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class,
                () -> new Person("Ana",133));
        assertThat(exc.getMessage()).isEqualTo("Age is not valid!");
    }

    @Test
    @DisplayName("WHEN valid age is given THEN return age")
    public void testGetAge() {
        //SETUP
        Person person1 = new Person("Rose",12);
        //RUN
        int actual = person1.getAge();
        //ASSERT
        assertThat(actual).isEqualTo(12);
    }

    @Test
    @DisplayName("WHEN id is set THEN return id")
    public void testGetId() {
        //SETUP
        Person person1 = new Person("Rose",12);
        person1.setId(1);
        Person person2 = new Person("Christine",89);
        person2.setId(2);
        //RUN
        int actual = person2.getId();
        //ASSERT
        assertThat(actual).isEqualTo(2);
    }
}
