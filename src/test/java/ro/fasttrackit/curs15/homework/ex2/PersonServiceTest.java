package ro.fasttrackit.curs15.homework.ex2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {

    @Test
    @DisplayName("WHEN a person is given THEN add an id for it and add person to List<Person>")
    void testAddPerson() {
        //SETUP
        PersonService personService = new PersonService(List.of());
        //RUN
        Person personTest = new Person("Mara",33);
        Person actual = personService.addPerson(personTest);
        personTest.setId(1);
        //ASSERT
        assertThat(actual).isEqualTo(personTest);
    }


    @Test
    @DisplayName("WHEN person with given id doesn't exist THEN throw MyUncheckedException")
    void testNoPersonForId() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        //RUN
        MyUncheckedException exc1 = assertThrows(MyUncheckedException.class,
                () -> personService.removePerson(4));
        //ASSERT
        assertThat(exc1.getMessage()).isEqualTo("This person doesn't exist!");
    }

    @Test
    @DisplayName("WHEN person with given id exists THEN return it")
    void testReturnPerson() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));

        Person tom = new Person("Tom", 51);
        tom.setId(1);
        //RUN
        Person removedPerson = personService.removePerson(1);

        //ASSERT
        assertThat(removedPerson).isEqualTo(tom);

    }

    @Test
    @DisplayName("WHEN invalid age THEN throw exception")
    void testGetInvalidAge() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        //RUN
        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class,
                () -> personService.getPersonsOlderThan(130));
        //ASSERT
        assertThat(exc1.getMessage()).isEqualTo("The age is not valid!");
    }
    @Test
    @DisplayName("WHEN no persons with bigger age THEN return empty list")
    void testNoPersonsForAge() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        //RUN
        List<Person> actual = personService.getPersonsOlderThan(55);
        //ASSERT
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isEmpty();
    }

    @Test
    @DisplayName("WHEN no person THEN return empty list")
    void testNoPerson() {
        //SETUP
        PersonService personService = new PersonService(List.of());
        //RUN
        List<Person> actual = personService.getAllPersons();
        //ASSERT
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isEmpty();
    }
    @Test
    @DisplayName("WHEN all persons are requested THEN return them all")
    void testGetAllPersons() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        Person person1 = new Person( "Tom", 51);
        person1.setId(1);
        Person person2 = new Person( "Samuel", 38);
        person2.setId(2);
        Person person3 = new Person( "Carla", 14);
        person3.setId(3);

        //RUN
        List<Person> actual = personService.getAllPersons();
        //ASSERT
        Assertions.assertThat(actual).hasSize(3)
                .containsExactlyInAnyOrder(person1, person2, person3);

    }

    @Test
    @DisplayName("WHEN we have persons with age bigger than the given one THEN return them all")
    void testPersonsBiggerThanAge() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        Person tom = new Person("Tom",51);
        tom.setId(1);
        Person samuel = new Person("Samuel",38);
        samuel.setId(2);
        //RUN
        List<Person> actual = personService.getPersonsOlderThan(15);
        //ASSERT
        Assertions.assertThat(actual).hasSize(2)
                .containsExactlyInAnyOrder(tom, samuel);
    }

    @Test
    @DisplayName("WHEN no person THEN return empty list")
    void testNoPersonForName() {
        PersonService personService = new PersonService(List.of());
        //RUN
        List<String> actual = personService.getAllPersonsNames();
        //ASSERT
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isEmpty();
    }
    @Test
    @DisplayName("WHEN persons are given THEN return all their names")
    void testNamesForPersons() {
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        //RUN
        List<String> actual = personService.getAllPersonsNames();
        //ASSERT
        Assertions.assertThat(actual).containsExactly("Tom","Samuel","Carla");
    }

    @Test
    @DisplayName("WHEN null name is given THEN throw exception")
    void testGetNullName() {
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        //RUN
        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class,
                () -> personService.getPerson(null));
        //ASSERT
        assertThat(exc1.getMessage()).isEqualTo("There is no given name");
    }
    @Test
    @DisplayName("WHEN inexistent name is given THEN return null")
    void testInexistentNameForPerson() {
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        //RUN
        Person actual1 = personService.getPerson("Lili");
        Person actual2 = personService.getPerson("");
        //ASSERT
        assertThat(actual1).isNull();
        assertThat(actual2).isNull();
    }
    @Test
    @DisplayName("WHEN given an existent name THEN return corespondent person")
    void testNameForPerson() {
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        Person carla = new Person("Carla",14);
        carla.setId(3);
        //RUN
        Person actual = personService.getPerson("Carla");
        //ASSERT
        Assertions.assertThat(actual).isEqualTo(carla);
    }

    @Test
    @DisplayName("WHEN no person with given id THEN return null")
    void testInexistentId() {
        PersonService personService = new PersonService(List.of(
                new Person("Tom", 51),
                new Person("Samuel", 38),
                new Person( "Carla", 14)
        ));
        //RUN
        Person actual = personService.getPersonById(6);
        //ASSERT
        assertThat(actual).isNull();
    }
    @Test
    @DisplayName("WHEN person with given id exists THEN return person")
    void testIdForPerson() {
        PersonService personService = new PersonService(List.of(
                new Person( "Tom", 51),
                new Person( "Samuel", 38),
                new Person( "Carla", 14)
        ));
        Person samuel = new Person("Samuel",38);
        samuel.setId(2);
        //RUN
        Person actual = personService.getPersonById(2);
        //ASSERT
        Assertions.assertThat(actual).isEqualTo(samuel);
    }
}
