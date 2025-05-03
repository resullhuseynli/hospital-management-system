package model;

import manager.HospitalManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private String note;

    public Appointment(String id, Patient patient, Doctor doctor, LocalDateTime dateTime, String note) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | PatientID: " + patient.getId() +
                " | DoctorID: " + doctor.getId() +
                " | DateTime: " + dateTime +
                " | Note: " + note;
    }

    public static Appointment fromString(String line) {
        String[] fields = line.split("\\|");
        String id = fields[0].split(":")[1].trim();
        String patientID = fields[1].split(":")[1].trim();
        String doctorID = fields[2].split(":")[1].trim();
        String dateTimePart = fields[3].replace("DateTime: ", "").trim();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimePart);
        String note = fields[4].split(":")[1].trim();

        Doctor doctor = null;
        Patient patient = null;

        if (HospitalManager.patients != null) {
            for (Patient p : HospitalManager.patients) {
                if (p.getId().equals(patientID)) {
                    patient = p;
                }
            }

        }

        if (HospitalManager.doctors != null) {
            for (Doctor d : HospitalManager.doctors) {
                if (d.getId().equals(doctorID)) {
                    doctor = d;
                }
            }
        }
        return new Appointment(id, patient, doctor, dateTime, note);
    }
}
