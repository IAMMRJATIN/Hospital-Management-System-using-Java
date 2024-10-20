import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create sample users
        Patient patient = new Patient("P001", "password", "Mr. Unknown person", "Initial record");
        Doctor doctor = new Doctor("D001", "password", "Dr. C.N Sharma");
        Pharmacist pharmacist = new Pharmacist("PH001", "password");
        Administrator admin = new Administrator("A001", "password");

        User currentUser = null;

        while (true) {
            System.out.println("\n     --- Hospital Management System ---");
            System.out.println("--- ( Enter your Login ID and Password ) --- ");
            
            System.out.println("Enter User ID: ");
            String userID = scanner.nextLine();
            System.out.println("Enter Password: ");
            String password = scanner.nextLine();

            // Login validation
            if (patient.login(userID, password)) {
                currentUser = patient;
            } else if (doctor.login(userID, password)) {
                currentUser = doctor;
            } else if (pharmacist.login(userID, password)) {
                currentUser = pharmacist;
            } else if (admin.login(userID, password)) {
                currentUser = admin;
            } else {
                System.out.println("Invalid credentials. Try again.");
                continue;
            }

            currentUser.promptPasswordChange(scanner); // Prompt for password change if needed

            // User logged in, show menu
            while (currentUser != null) {
                currentUser.displayMenu();
                System.out.print("Choose an option: ");
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    currentUser.handleUserChoice(choice, scanner);
                    if (choice == 3 || choice == 7 || choice == 9) { // Logout option for all roles
                        currentUser = null;
                    }
                } else {
                    System.out.println("Invalid input, please enter a number.");
                    scanner.next(); // consume invalid input
                }
            }
        }
    }
}
