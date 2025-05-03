package model;

import java.time.LocalDate;

public class Doctor extends Person{

    private Specialization specialization;
    private LocalDate employmentDate;

    public Doctor(String id, String name, LocalDate birthDate, String gender,  LocalDate employmentDate, Specialization specialization) {
        super(id, name, birthDate, gender);
        this.specialization = specialization;
        this.employmentDate = employmentDate;
    }

    @Override
    public String getInfo() {
        return toString();
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public String toString() {
        return "ID:" + id +
                " | Name:" + name +
                " | BirthDate:" + birthDate +
                " | Gender:" + gender +
                " | EmploymentDate:" + employmentDate +
                " | Specialization:" +  specialization;
    }

    public static Doctor fromString(String line) {
        String[] fields = line.split("\\|");
        String id = fields[0].split(":")[1].trim();
        String name = fields[1].split(":")[1].trim();
        LocalDate birthDate = LocalDate.parse(fields[2].split(":")[1].trim());
        String gender = fields[3].split(":")[1].trim();
        LocalDate employmentDate = LocalDate.parse(fields[4].split(":")[1].trim());
        Specialization specialization = Specialization.valueOf(fields[5].split(":")[1].trim());
        return new Doctor(id, name, birthDate, gender, employmentDate, specialization);
    }
}
