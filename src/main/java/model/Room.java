package model;

public class Room {

    private int roomNumber;
    private boolean isOccupied;
    private Patient patient;

    Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void assignPatient(Patient patient) {
        if (patient == null) {
            throw new NullPointerException("Patient is null");
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
        if  (isOccupied) {
            return "YES";
        }
        return "NO";
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    //TAMAMLANMAYIBBBB
    public static Room fromString(String line, Patient patient) {
        String[] fields = line.split("\\|");
        int roomNumber = Integer.parseInt(fields[0].split(":")[1].trim());
        boolean isOccupied = Boolean.parseBoolean(fields[1].split(":")[1].trim());
        Room room = new Room(roomNumber);
        return null;
    }
}
