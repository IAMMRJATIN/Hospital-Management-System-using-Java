import java.util.ArrayList;
import java.util.Scanner;

public class Administrator extends User {
    private ArrayList<User> staffList = new ArrayList<>();
    private ArrayList<String> inventory = new ArrayList<>();

    public Administrator(String hospitalID, String password) {
        super(hospitalID, password);
    }

    public void addStaff(User user) {
        staffList.add(user);
        System.out.println(user.getClass().getSimpleName() + " added to staff.");
    }

    public void removeStaff(int index) {
        if (index < staffList.size()) {
            staffList.remove(index);
            System.out.println("Staff removed.");
        } else {
            System.out.println("Invalid staff index.");
        }
    }

    public void manageInventory(String item, int quantity, boolean add) {
        if (add) {
            inventory.add(item + " (" + quantity + ")");
            System.out.println(item + " added to inventory.");
        } else {
            inventory.remove(item);
            System.out.println(item + " removed from inventory.");
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\nAdministrator Menu:");
        System.out.println("1. View Staff List");
        System.out.println("2. Add Staff Member");
        System.out.println("3. Remove Staff Member");
        System.out.println("4. Manage Inventory");
        System.out.println("5. Logout");
    }

    @Override
    public void handleUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                for (int i = 0; i < staffList.size(); i++) {
                    System.out.println(i + ": " + staffList.get(i).getClass().getSimpleName());
                }
                break;
            case 2:
                System.out.println("1. Add Doctor\n2. Add Pharmacist");
                int type = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter hospital ID: ");
                String hospitalID = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (type == 1) {
                    addStaff(new Doctor(hospitalID, password, "New Doctor"));
                } else if (type == 2) {
                    addStaff(new Pharmacist(hospitalID, password));
                } else {
                    System.out.println("Invalid option.");
                }
                break;
            case 3:
                System.out.print("Enter staff index to remove: ");
                int index = scanner.nextInt();
                removeStaff(index);
                break;
            case 4:
                System.out.print("Enter item name: ");
                String item = scanner.nextLine();
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                System.out.print("Add to inventory? (true/false): ");
                boolean add = scanner.nextBoolean();
                manageInventory(item, quantity, add);
                break;
            case 5:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
