
import java.util.Scanner;

public abstract class User {
    protected String hospitalID;
    protected String password;
    protected boolean firstLogin = true;

    public User(String hospitalID, String password) {
        this.hospitalID = hospitalID;
        this.password = password;
    }

    public boolean login(String id, String pass) {
        return this.hospitalID.equals(id) && this.password.equals(pass);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password changed successfully.");
        firstLogin = false;
    }

    public void promptPasswordChange(Scanner scanner) {
        if (firstLogin) {
            System.out.println("Please change your default password:");
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            changePassword(newPassword);
        }
    }

    public abstract void displayMenu();
    public abstract void handleUserChoice(int choice, Scanner scanner);
}
