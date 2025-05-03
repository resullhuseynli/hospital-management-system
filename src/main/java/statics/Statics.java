package statics;

import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Statics {

    public static final String appointmentFilePath = "data/appointments.txt";
    public static final String doctorFilePath = "data/doctors.txt";
    public static final String patientFilePath = "data/patients.txt";
    public static final String roomFilePath = "data/rooms.txt";
    private static final LocalDate birthDay = LocalDate.of(2005, 2, 8);
    private static final LocalDate employeeDate = LocalDate.now();

    public static Doctor doctor1 = new Doctor(
            "D001",
            "Resul Huseynli",
            birthDay,
            "MALE",
            employeeDate,
            Specialization.CARDIOLOGIST);

    public static Doctor doctor2 = new Doctor(
            "D002",
            "Nicat Khanaliyev",
            LocalDate.of(2005,10,7),
            "MALE",
            employeeDate,
            Specialization.GENERAL_PRACTITIONER
    );

    public static Patient patient1 = new Patient(
            "P001",
            "Mansura Badalova",
            LocalDate.of(2006, 5, 29),
            "FEMALE",
            "Flue"
    );

    public static Patient patient2 = new Patient(
            "P002",
            "Shaiq",
            LocalDate.of(2006, 5, 29),
            "MALE",
            "Lung Cancer"
    );

    public static Room room1 = new Room(331);
    public static Room room2 = new Room(325);

    public static Appointment appointment1 = new Appointment(
            "A001",
            patient1,
            doctor1,
            LocalDateTime.now(),
            "Be careful"
    );

    public static Appointment appointment2 = new Appointment(
            "A002",
            patient2,
            doctor2,
            LocalDateTime.now(),
            "Do not ignore use drugs"
    );

}
