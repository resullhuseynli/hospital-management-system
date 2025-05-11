import exception.RoomOccupiedException;
import manager.HospitalManager;
import statics.Statics;

public class Main {
    public static void main(String[] args) throws RoomOccupiedException {

        HospitalManager hospitalManager = new HospitalManager();

        hospitalManager.addDoctor(Statics.doctor1);
        hospitalManager.addDoctor(Statics.doctor2);

        hospitalManager.addPatient(Statics.patient1);
        hospitalManager.addPatient(Statics.patient2);

        hospitalManager.addRoom(Statics.room1);
        hospitalManager.addRoom(Statics.room2);

        hospitalManager.scheduleAppointment(Statics.appointment1);
        hospitalManager.scheduleAppointment(Statics.appointment2);

        Statics.room1.assignPatient(Statics.patient1);

        System.out.println();

        System.out.println("------------------------- LISTING ALL COMPONENTS -------------------------");
        hospitalManager.listAllPatients();
        System.out.println("---------------------------------------------------------------------------");
        hospitalManager.listAllDoctors();
        System.out.println("---------------------------------------------------------------------------");
        hospitalManager.listAllRooms();
        System.out.println("---------------------------------------------------------------------------");
        hospitalManager.listAllAppointments();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println();

        System.out.println();

        System.out.println("------------------------- SAVING TO FILE ----------------------------------");
        hospitalManager.saveAppointmentsToFile(Statics.appointmentFilePath);
        System.out.println("---------------------------------------------------------------------------");
        hospitalManager.saveDoctorsToFile(Statics.doctorFilePath);
        System.out.println("---------------------------------------------------------------------------");
        hospitalManager.savePatientsToFile(Statics.patientFilePath);
        System.out.println("---------------------------------------------------------------------------");
        hospitalManager.saveRoomsToFile(Statics.roomFilePath);
        System.out.println("------------------------------------------------------------------------");

        System.out.println();

        System.out.println("------------------------ LOAD FROM FILE ---------------------------------");
        hospitalManager.loadAppointmentsFromFile(Statics.appointmentFilePath);
        System.out.println("-------------------------------------------------------------------");
        hospitalManager.loadDoctorsFromFile(Statics.doctorFilePath);
        System.out.println("---------------------------------------------------------------------");
        hospitalManager.loadRoomsFromFile(Statics.roomFilePath);
        System.out.println("------------------------------------------------------------------");
        hospitalManager.loadPatientFromFile(Statics.patientFilePath);
        System.out.println("------------------------------------------------------------------");

        System.out.println();

        System.out.println("------------------------ TRYING GIVE THE PATIENT TO ROOM --------------------");
        System.out.println(Statics.room1);
        System.out.println(Statics.room2);

        Statics.room1.assignPatient(Statics.patient2);
    }
}
