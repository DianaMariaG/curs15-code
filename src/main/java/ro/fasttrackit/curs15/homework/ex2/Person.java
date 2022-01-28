package ro.fasttrackit.curs15.homework.ex2;

import java.util.Objects;

import static ro.fasttrackit.curs15.homework.ex2.StringUtils.*;

public class Person {
    private int id;
    private final String name;
    private final int age;

    public Person (String name, int age) {
        this.id = 0;
        this.name = ensureNotEmpty(name);
        this.age = validAge(age);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
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
