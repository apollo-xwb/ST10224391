// Book:
// Bloch, J. (2008). Effective Java (2nd ed.). Addison-Wesley Professional.

// Journal Article:
// Nguyen, T. T., Nguyen, T. N., Nguyen, Q. V., & Nguyen, T. H. (2019). A novel approach for intelligent tutoring systems based on cognitive load theory. IEEE Access, 7, 125384-125397.

// Conference Proceedings:
// Tan, X., Wang, T., & Wu, C. (2019, July). Application of Java language in computer science teaching. In 2019 International Conference on Educational Innovation and Philosophical Inquiries (ICEIPI 2019) (pp. 192-195). Atlantis Press.

import java.util.Scanner;

public class EasyKanban {

    private static String name;
    private static String surname;
    private static String username;
    private static String password;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to EasyKanban!\n");

        boolean isRegistered = false;

        while (!isRegistered) {
            System.out.println("\nIn order to use EasyKanban, you need to be logged in.");

            while (true) {
                System.out.print("\nChoose a Username (must be more than 5 letters and contain an underscore)\nEnter Username: ");
                username = scanner.nextLine();

                if (checkUserName()) {
                    break;
                } else {
                    System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
                }
            }

            while (true) {
                System.out.print("\n\n\nChoose a Password \n- Must contain a capital letter \n- Minimum of 8 characters \n- Must Contain A Number \n- Contains Atleast 1 Special Character\n\nEnter Password: ");
                password = scanner.nextLine();

                if (checkPasswordComplexity()) {
                    break;
                } else {
                    System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
                }
            }

            System.out.print("\nEnter Your Name: ");
            name = scanner.nextLine();

            System.out.print("Enter Your Surname: ");
            surname = scanner.nextLine();

            if (registerUser()) {
                isRegistered = true;
                System.out.println("Registration successful. Welcome to EasyKanban, " + name + " " + surname + "!");
            } else {
                System.out.println("Failed to register user. Please try again.");
            }
        }

        System.out.println("\nPlease sign in:");

        boolean isSignedIn = false;

        while (!isSignedIn) {
            System.out.print("Enter username: ");
            String logOnUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String logOnPassword = scanner.nextLine();

            if (loginUser(logOnUsername, logOnPassword)) {
                isSignedIn = true;
                System.out.println("Login successful. Welcome back " + name + " " + surname + "!");
            } else {
                System.out.println("Username or password incorrect, please try again.");
            }
        }

        scanner.close();
    }

    public static boolean checkUserName() {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        }
        return false;
    }

    public static boolean checkPasswordComplexity() {
        if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[^a-zA-Z0-9].*")) {
            return true;
        }
        return false;
    }

    public static boolean registerUser() {
        if (!checkUserName()) {
            return false;
        } else if (!checkPasswordComplexity()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean loginUser(String loginUsername, String logOnPassword) {
        if (loginUsername.equals(username) && logOnPassword.equals(password)) {
            return true;
        }
        return false;
    }
}
