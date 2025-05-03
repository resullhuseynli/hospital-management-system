package model;

import java.time.LocalDate;

public class Patient extends Person{

    private String diagnosis;

    public Patient(String id, String name, LocalDate birthDate, String gender,  String diagnosis) {
        super(id, name, birthDate, gender);
        this.diagnosis = diagnosis;
    }

    @Override
    public String getInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "ID:" + id +
                " | Name:" + name +
                " | BirthDate:" + birthDate +
                " | Gender:" + gender +
                " | Diagnosis:" + diagnosis;
    }

    public static Patient fromString(String line) {
        String[] fields = line.split("\\|");
        String id = fields[0].split(":")[1].trim();
        String name = fields[1].split(":")[1].trim();
        LocalDate birthDate = LocalDate.parse(fields[2].split(":")[1].trim());
        String gender = fields[3].split(":")[1].trim();
        String diagnosis = fields[4].split(":")[1].trim();

        return new Patient(id, name, birthDate, gender, diagnosis);
    }
}
