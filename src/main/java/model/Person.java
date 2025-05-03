package model;

import java.time.LocalDate;

public abstract class Person {

    protected String id;
    protected String name;
    protected LocalDate birthDate;
    protected String gender;

    public Person(String id, String name, LocalDate birthDate, String gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public abstract String getInfo();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }
}
