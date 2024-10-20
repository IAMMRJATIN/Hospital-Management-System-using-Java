import java.util.ArrayList;
import  java.util.Scanner;

public class Pharmacist extends User {
    private ArrayList<String> medicationInventory = new ArrayList<>();

    public Pharmacist(String hospitalID, String password) {
        super(hospitalID, password);
    }

    public void viewInventory() {
        if (medicationInventory.isEmpty()) {
            System.out.println("No medications in inventory.");
        } else {
            for (String med : medicationInventory) {
                System.out.println(med);
            }
        }
    }

    public void updatePrescriptionStatus(String prescriptionID, String status) {
        System.out.println("Prescription " + prescriptionID + " updated to " + status);
    }

    @Override
    public void displayMenu() {
        System.out.println("\nPharmacist Menu:");
        System.out.println("1. View Medication Inventory");
        System.out.println("2. Update Prescription Status");
        System.out.println("3. Logout");
    }

    @Override
    public void handleUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                viewInventory();
                break;
            case 2:
                System.out.print("Enter prescription ID: ");
                String prescriptionID = scanner.nextLine();
                System.out.print("Enter new status: ");
                String status = scanner.nextLine();
                updatePrescriptionStatus(prescriptionID, status);
                break;
            case 3:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
