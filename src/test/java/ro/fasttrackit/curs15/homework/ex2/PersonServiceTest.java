package ro.fasttrackit.curs15.homework.ex2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {
    @Test
    @DisplayName("WHEN negativ or 0 id is given THEN throw exception")
    void testGetId() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person(1, "John", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
        ));
        //RUN
        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class,
                () -> personService.removePerson(-5));
        IllegalArgumentException exc2 = assertThrows(IllegalArgumentException.class,
                () -> personService.removePerson(0));

        //ASSERT
        assertThat(exc1.getMessage()).isEqualTo("A negative or 0 id is not accepted!");
        assertThat(exc2.getMessage()).isEqualTo("A negative or 0 id is not accepted!");
    }

    @Test
    @DisplayName("WHEN person with given id doesn't exist THEN throw MyUncheckedException")
    void testNoPersonForId() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
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
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
        ));
        //RUN
        Person removedPerson = personService.removePerson(1);

        //ASSERT
        assertThat(removedPerson).isEqualTo(new Person(1, "Tom", 51));
//        assertThat(personService).containsExactly
    }

    @Test
    @DisplayName("WHEN invalid age THEN throw exception")
    void testGetInvalidAge() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
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
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
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
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
        ));
        //RUN
        List<Person> actual = personService.getAllPersons();
        //ASSERT
        Assertions.assertThat(actual).hasSize(3)
                .containsExactlyInAnyOrder(
                        new Person(1, "Tom", 51),
                        new Person(2, "Samuel", 38),
                        new Person(3, "Carla", 14));
    }

    @Test
    @DisplayName("WHEN we have persons with age bigger than the given one THEN return them all")
    void testPersonsBiggerThanAge() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
        ));
        //RUN
        List<Person> actual = personService.getPersonsOlderThan(15);
        //ASSERT
        Assertions.assertThat(actual).hasSize(2)
                .containsExactlyInAnyOrder(
                        new Person(1,"Tom",51),
                        new Person(2,"Samuel",38));
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
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
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
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
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
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
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
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
        ));
        //RUN
        Person actual = personService.getPerson("Carla");
        //ASSERT
        Assertions.assertThat(actual).isEqualTo(new Person(3,"Carla",14));
    }

    @Test
    @DisplayName("WHEN no person with given id THEN return null")
    void testInexistentId() {
        PersonService personService = new PersonService(List.of(
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
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
                new Person(1, "Tom", 51),
                new Person(2, "Samuel", 38),
                new Person(3, "Carla", 14)
        ));
        //RUN
        Person actual = personService.getPersonById(2);
        //ASSERT
        Assertions.assertThat(actual).isEqualTo(new Person(2,"Samuel",38));
    }
}
