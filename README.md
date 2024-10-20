# Hospital-Management-System-using-Java
Project Description:
The Hospital Management System (HMS) is a Java-based command-line interface (CLI) application designed to automate and streamline various operations within a hospital. It offers role-based access for different types of users, such as patients, doctors, pharmacists, and administrators, allowing each user to interact with the system according to their specific roles and privileges.

The system focuses on managing hospital operations like patient record management, appointment scheduling, staff management, and inventory control. The HMS adheres to core Object-Oriented Programming (OOP) principles like encapsulation, inheritance, polymorphism, and abstraction, ensuring a modular, scalable, and maintainable design.

Key Features:
Role-Based Access: The system supports four main user roles, each with its own set of capabilities:

Patients: View medical records, update personal information, schedule, reschedule, or cancel appointments.
Doctors: Manage patient records, view and update appointments, record treatment outcomes.
Pharmacists: View and fulfill prescription orders, monitor inventory, and request medication replenishment.
Administrators: Manage hospital staff (add/update/remove doctors or pharmacists), oversee appointments, and handle medication inventory.
Login System:

Each user must log in using their hospital ID and password. Depending on the credentials, the user is presented with role-specific menus and functionalities.
Patient Management:

Patients can view their medical records (e.g., past diagnoses, treatments, blood type) and schedule appointments with doctors.
Patients can update non-medical personal information such as their contact details.
Doctor Management:

Doctors can access the medical records of patients under their care, update records with new diagnoses or treatments, and manage their own appointment schedules.
Doctors can also accept or decline appointment requests from patients.
Inventory Management (Pharmacist/Administrator):

Pharmacists can view the list of prescribed medications and update the status (e.g., dispensed or pending).
Administrators can manage the stock levels of medications and approve replenishment requests from pharmacists.
Staff Management (Administrator):

Administrators can add, update, and remove hospital staff such as doctors and pharmacists.
They can also view and filter the list of staff members by role, gender, or other criteria.
Object-Oriented Concepts Used:
Encapsulation:

Data such as hospitalID, password, and medicalRecord are encapsulated in the User, Patient, and Doctor classes. These fields are private and only accessible via public getter and setter methods.
Inheritance:

The base class User provides common attributes and methods (e.g., login, change password) for the subclasses Patient, Doctor, Pharmacist, and Administrator. This reduces code duplication and ensures consistency across all user types.
Polymorphism:

The method displayMenu() is overridden in each subclass (Patient, Doctor, Administrator), allowing the system to present a different menu to each user based on their role.
The handleUserChoice() method is also polymorphic, handling user interactions according to their specific role.
Abstraction:

The abstract class User defines common functionality for all users but leaves the implementation of certain methods (like displayMenu() and handleUserChoice()) to be handled by the subclasses.
Workflow:
Login Process:

The program starts by prompting the user to enter their UserID and Password. Depending on the entered credentials, the user is logged in as either a patient, doctor, pharmacist, or administrator.
Role-Specific Menus:

After login, the user is presented with a menu tailored to their role.
For example, a patient might see options like "View Medical Record" or "Schedule an Appointment".
A doctor might see options to "View Patient Record" or "Record Appointment Outcome".
Performing Actions:

The user selects an option from the menu, and the system performs the corresponding action.
For instance, if a patient chooses to view their medical record, the system retrieves and displays it.
If a doctor updates a patient's record, the system stores the new diagnosis or treatment in the patient's medical history.
Logging Out:

Users can log out and return to the login prompt by selecting the "Logout" option from their menu.
System Design:
Class Hierarchy:

User (abstract class): Base class for all types of users.
Patient: Inherits from User and adds patient-specific functionality (e.g., view medical records, schedule appointments).
Doctor: Inherits from User and adds doctor-specific functionality (e.g., manage patient records, update appointments).
Pharmacist: Inherits from User and adds prescription management functionality.
Administrator: Inherits from User and adds staff and inventory management functionality.
Menus and Interaction:

Each class implements its own version of displayMenu() and handleUserChoice() methods, allowing for customized interactions based on the user's role.
Tools & Technologies:
Programming Language: Java (using JDK 8 or above).
Development Environment: IntelliJ IDEA / Eclipse IDE for code development.
Design Approach: Object-Oriented Programming principles with emphasis on encapsulation, inheritance, polymorphism, and abstraction.
User Interface: Command-Line Interface (CLI).
Possible Enhancements:
Graphical User Interface (GUI):

The system could be enhanced with a GUI using JavaFX or Swing for a more user-friendly experience.
Database Integration:

Currently, data is hardcoded for simplicity. The system can be extended by connecting to a database (e.g., MySQL) to handle persistent data storage for users, appointments, and medical records.
More Roles and Features:

Additional roles like Nurses or Technicians could be added to expand the system’s capabilities.
Features like billing and insurance management could also be integrated.
Security Enhancements:

Currently, the system uses basic string matching for password validation. This could be enhanced by implementing hashed passwords and stronger authentication mechanisms.
