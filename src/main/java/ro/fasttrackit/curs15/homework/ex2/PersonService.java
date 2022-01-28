package ro.fasttrackit.curs15.homework.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();
    private int currentId;

    public PersonService (List<Person> persons) {
        this.currentId = 0;
        if (persons != null) {
            for (Person person : persons){
                this.addPerson(person);
            }
        }
    }
     //persoana primita NU are ID, isi va genera dupa adaugare. Persoana returnata are id-ul setat
    public Person addPerson (Person person) {
        persons.add(person);
        person.setId(++currentId);
        return person;
    }

    // sterge persoana cu id-ul respectiv si o returneaza. Arunca exceptie (unchecked) daca nu exista
    public Person removePerson (int id) throws IllegalArgumentException, MyUncheckedException {
        Person result = null; //e null acum
        for (Person person : persons) {
            if (person.getId() == id) {
                result = person;
                persons.remove(person);
                break;
            }
        }
        if (result == null) {
            throw new MyUncheckedException("This person doesn't exist!");
        }
        return result;
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
