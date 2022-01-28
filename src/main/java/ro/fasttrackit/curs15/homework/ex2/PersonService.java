package ro.fasttrackit.curs15.homework.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService (List<Person> persons) {
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }
     //persoana primita NU are ID, is e va genera dupa adaugare. Persoana returnata are id-ul setat
//    public Person addPerson (Person person) {
//        Scanner scanner = new Scanner(System.in);
//        person.getId()= scanner.nextInt();
//
//        persons.add(person);
//        return person;
//    }

    // sterge persoana cu id-ul respectiv si o returneaza. Arunca exceptie (unchecked) daca nu exista
    public Person removePerson (int id) throws IllegalArgumentException, MyUncheckedException {
        if (id <= 0) {
            throw new IllegalArgumentException("A negative or 0 id is not accepted!");
        }
        for (Person person : persons) {
            if (person.getId() == id) {
                persons.remove(person);
                return person;
            } else {
                throw new MyUncheckedException("This person doesn't exist!");
            }
        }
        return null;
    }

    public List<Person> getAllPersons() {
        return persons;
    }

    //validati age-ul (pozitiv, <120)
    public List<Person> getPersonsOlderThan(int age) throws IllegalArgumentException {
        if (!(age > 0 && age < 120)) {
            throw new IllegalArgumentException("The age is not valid!");
        }
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() > age) {
                result.add(person);
            }
        }
        return result;
    }
    public List<String> getAllPersonsNames() {
        List<String> result = new ArrayList<>();
        for (Person person : persons) {
            result.add(person.getName());
        }
        return result;
    }

    public Person getPerson(String name) {
        if (name == null) {
            throw new IllegalArgumentException("There is no given name");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
    public Person getPersonById(int id) { //nu poate fi null
        for (Person person : persons) {
            if (person.getId() == id){
                return person;
            }
        }
        return null;
    }
}
