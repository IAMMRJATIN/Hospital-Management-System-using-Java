import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends User {
    private String name;
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public Doctor(String hospitalID, String password, String name) {
        super(hospitalID, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No upcoming appointments.");
        } else {
            for (Appointment appt : appointments) {
                System.out.println(appt);
            }
        }
    }

    public void updatePatientRecord(Patient patient, String newRecord) {
        patient.viewMedicalRecord();
        System.out.println("Updating medical record...");
        System.out.println("New entry: " + newRecord);
        // In a real system, this would modify the patient's record in the database
    }

    @Override
    public void displayMenu() {
        System.out.println("\nDoctor Menu:");
        System.out.println("1. View Appointments");
        System.out.println("2. Update Patient Medical Records");
        System.out.println("3. Logout");
    }

    @Override
    public void handleUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                viewAppointments();
                break;
            case 2:
                // Sample patient to update records for
                Patient samplePatient = new Patient("P001", "password", "John Doe", "Initial record");
                System.out.print("Enter new medical record: ");
                String newRecord = scanner.nextLine();
                updatePatientRecord(samplePatient, newRecord);
                break;
            case 3:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
