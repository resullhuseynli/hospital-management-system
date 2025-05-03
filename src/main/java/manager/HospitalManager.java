package manager;

import model.Appointment;
import model.Doctor;
import model.Patient;
import model.Room;

import java.util.ArrayList;
import java.util.List;

public class HospitalManager {

    public static List<Patient> patients = new ArrayList<>();
    public static List<Doctor> doctors = new ArrayList<>();
    public static List<Appointment> appointments = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();

    public String addPatient(Patient patient) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(patient.getId())) {
                throw new IllegalArgumentException("Patient already exists");
            }
        }
        patients.add(patient);
        return "Patient " + patient.getId() + " has been added";
    }

    public String listAllPatients() {
        StringBuilder list = new StringBuilder();
        for (Patient p : patients) {
            System.out.println(p);
            list.append(p);
        }
        return list.toString();
    }
}
