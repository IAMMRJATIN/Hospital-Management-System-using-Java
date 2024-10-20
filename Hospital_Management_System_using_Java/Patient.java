import java.util.ArrayList;
import java.util.Scanner;

public class Patient extends User {
    private String name;
    private String contactInfo;
    private String medicalRecord;
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public Patient(String hospitalID, String password, String name, String medicalRecord) {
        super(hospitalID, password);
        this.name = name;
        this.medicalRecord = medicalRecord;
        this.contactInfo = "Not Provided";
    }

    public void viewMedicalRecord() {
        System.out.println("Medical Record for " + name + ": " + medicalRecord);
    }

    public void updateContactInfo(String newContact) {
        this.contactInfo = newContact;
        System.out.println("Contact information updated.");
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment appt : appointments) {
                System.out.println(appt);
            }
        }
    }

    public void scheduleAppointment(Doctor doctor, String timeSlot) {
        Appointment appointment = new Appointment(this, doctor, timeSlot);
        appointments.add(appointment);
        doctor.addAppointment(appointment);
        System.out.println("Appointment scheduled with Dr. " + doctor.getName() + " at " + timeSlot);
    }

    public void rescheduleAppointment(int index, String newTimeSlot) {
        if (index < appointments.size()) {
            Appointment appointment = appointments.get(index);
            appointment.setTimeSlot(newTimeSlot);
            System.out.println("Appointment rescheduled to " + newTimeSlot);
        } else {
            System.out.println("Invalid appointment selection.");
        }
    }

    public void cancelAppointment(int index) {
        if (index < appointments.size()) {
            Appointment appointment = appointments.remove(index);
            appointment.getDoctor().removeAppointment(appointment);
            System.out.println("Appointment canceled.");
        } else {
            System.out.println("Invalid appointment selection.");
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\nPatient Menu:");
        System.out.println("1. View Medical Record");
        System.out.println("2. Update Contact Information");
        System.out.println("3. View Scheduled Appointments");
        System.out.println("4. Schedule an Appointment");
        System.out.println("5. Reschedule an Appointment");
        System.out.println("6. Cancel an Appointment");
        System.out.println("7. Logout");
    }

    @Override
    public void handleUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                viewMedicalRecord();
                break;
            case 2:
                System.out.print("Enter new contact information: ");
                String newContact = scanner.nextLine();
                updateContactInfo(newContact);
                break;
            case 3:
                viewAppointments();
                break;
            case 4:
                System.out.print("Enter doctor ID: ");
                String docID = scanner.nextLine(); // Assume doctor exists
                System.out.print("Enter time slot: ");
                String timeSlot = scanner.nextLine();
                // Assume doctor object is fetched based on docID
                scheduleAppointment(new Doctor(docID, "password", "Dr. Smith"), timeSlot);
                break;
            case 5:
                System.out.print("Enter appointment index to reschedule: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new time slot: ");
                String newTimeSlot = scanner.nextLine();
                rescheduleAppointment(index, newTimeSlot);
                break;
            case 6:
                System.out.print("Enter appointment index to cancel: ");
                int cancelIndex = scanner.nextInt();
                cancelAppointment(cancelIndex);
                break;
            case 7:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
