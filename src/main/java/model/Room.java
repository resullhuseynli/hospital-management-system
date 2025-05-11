package model;

import exception.RoomOccupiedException;
import manager.HospitalManager;

public class Room {

    private final int roomNumber;
    private boolean isOccupied;
    private Patient patient;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void assignPatient(Patient patient) throws RoomOccupiedException {
        if (patient == null) {
            throw new NullPointerException("Patient is null");
        }
        if (this.patient != null) {
            throw new RoomOccupiedException("This room is already given to another patient!");
        }
        this.patient = patient;
        System.out.println("Patient added successfully!");
        isOccupied = true;
    }

    public void clearRoom() {
        this.patient = null;
        isOccupied = false;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber +
                " | Occupied:  " + isOccupiedToString() +
                ifOccupied();
    }

    private String ifOccupied() {
        if (isOccupied) {
            return " | PatientID: " + patient.getId();
        }
        return "";
    }

    private String isOccupiedToString() {
        if (isOccupied) {
            return "YES";
        }
        return "NO";
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Patient getPatient() {
        return patient;
    }

    public static Room fromString(String line) throws RoomOccupiedException {
        String[] fields = line.split("\\|");
        int roomNumber = Integer.parseInt(fields[0].split(":")[1].trim());
        String isOccupiedString = fields[1].split(":")[1].trim();

        boolean isOccupied = isOccupiedString.equals("YES");

        String patientID = null;
        if (isOccupied) {
            patientID = fields[2].split(":")[1].trim();
        }
        Room room = new Room(roomNumber);
        room.setOccupied(isOccupied);

        Patient patient = null;

        if (patientID != null && HospitalManager.patients != null) {
            for (Patient p : HospitalManager.patients) {
                if (p.getId().equals(patientID)) {
                    patient = p;
                }
            }
        }

        if (patient != null) room.assignPatient(patient);
        return room;
    }
}
