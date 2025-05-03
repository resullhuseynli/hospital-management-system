package manager;

import model.Appointment;
import model.Doctor;
import model.Patient;
import model.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HospitalManager {

    public static List<Patient> patients = new ArrayList<>();
    public static List<Doctor> doctors = new ArrayList<>();
    public static List<Appointment> appointments = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();

    public void addPatient(Patient patient) {
        if (patients.contains(patient)) {
            throw new IllegalArgumentException("Patient already exists");
        }
        patients.add(patient);
        System.out.println( "Patient " + patient.getId() + " has been added");
    }

    public void listAllPatients() {
        StringBuilder list = new StringBuilder();
        for (Patient p : patients) {
            list.append(p);
            list.append("\n");
        }
        System.out.println(list);
    }

    public void savePatientsToFile(String filePath) {

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Patient p : patients) {
                fileWriter.write(p.toString() + "\n");
            }
            System.out.println("Patient has been saved to file");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadPatientFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                System.out.println("There is no patient!");
            }
            while (line != null) {
                Patient patient = Patient.fromString(line);
                System.out.println(patient);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addDoctor(Doctor doctor) {

        if (HospitalManager.doctors.contains(doctor)) {
            throw new IllegalArgumentException("Doctor already exists");
        }
        doctors.add(doctor);
        System.out.println( "Doctor " + doctor.getId() + " has been added");
    }

    public void listAllDoctors() {
        StringBuilder list = new StringBuilder();
        for (Doctor doctor : doctors) {
            list.append(doctor);
            list.append("\n");
        }
        System.out.println(list);
    }

    public void saveDoctorsToFile(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for(Doctor doctor : doctors) {
                fileWriter.write(doctor.toString() + "\n");
            }
            System.out.println( "Doctors have been saved to file!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadDoctorsFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                System.out.println("There is no doctor!");
            }
            while (line != null) {
                Doctor doctor = Doctor.fromString(line);
                System.out.println(doctor);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void scheduleAppointment(Appointment appointment) {
        if  (appointments.contains(appointment)) {
            throw new IllegalArgumentException("Appointment already exists");
        }
        appointments.add(appointment);
        System.out.println( "Appointment " + appointment.getId() + " has been scheduled");
    }

    public void listAllAppointments() {
        StringBuilder list = new StringBuilder();
        for (Appointment appointment : appointments) {
            list.append(appointment);
            list.append("\n");
        }
        System.out.println(list);
    }

    public void saveAppointmentsToFile(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Appointment appointment : appointments) {
                fileWriter.write(appointment.toString() + "\n");
            }
            System.out.println("Appointments have been saved to file!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadAppointmentsFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                System.out.println("There is no appointment!");
            }
            while (line != null) {
                Appointment appointment = Appointment.fromString(line);
                System.out.println(appointment);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addRoom(Room room) {
        if  (HospitalManager.rooms.contains(room)) {
            throw new IllegalArgumentException("Room already exists");
        }
        rooms.add(room);
        System.out.println("Room " + room.getRoomNumber() + " has been added");
    }

    public void listAllRooms() {
        StringBuilder list = new StringBuilder();
        for (Room room : rooms) {
            list.append(room);
            list.append("\n");
        }
        System.out.println(list);
    }

    public void saveRoomsToFile(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Room room : rooms) {
                fileWriter.write(room.toString() + "\n");
            }
            System.out.println( "Rooms have been saved to file!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadRoomsFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                System.out.println("There is no room!");
            }
            while (line != null) {
                Room room = Room.fromString(line);
                System.out.println(room);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


}
