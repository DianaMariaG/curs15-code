package ro.fasttrackit.curs15.homework.ex2;

import java.util.Objects;

import static ro.fasttrackit.curs15.homework.ex2.StringUtils.*;

public class Person {
    private final int id;
    private final String name;
    private final int age;

    public Person (int id, String name, int age) {
        this.id = ensureNotNegative(id);
        this.name = ensureNotEmpty(name);
        this.age = validAge(age);
    }
//    public Person(String name, int age) {
//        this(null, name, age);
//    }
//    public Person(){
//        this(0, null, 0);
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
