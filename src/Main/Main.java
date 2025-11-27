import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<User> users = new ArrayList<>();
    private static final List<CoffeeBean> marketProducts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String USER_FILE = "users.txt"; // file to store users

    public static void main(String[] args) {
        loadUsersFromFile(); // load users on startup

        while (true) {
            System.out.println("\n«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»");
            System.out.println("       /  /  /                                 ");
            System.out.println("      _________                                ");
            System.out.println("     |         |---                            ");
            System.out.println("     |   JAZ   |   |     K A P E ☕ L I N K    ");
            System.out.println("     |_________|---                            ");
            System.out.println("\n«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> registerUser();
                case "2" -> loginUser();
                case "3" -> {
                    System.out.println("Goodbye! 👋");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ---------------- REGISTER -----------------
    private static void registerUser() {
        System.out.println("\n--- User Registration ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Choose username: ");
        String username = scanner.nextLine();

        if (usernameExists(username)) {
            System.out.println("❌ Username already exists. Try a different one.");
            return;
        }

        String password;
        while (true) {
            System.out.print("Choose password (min 4 characters): ");
            password = scanner.nextLine();
            if (password.length() < 4) System.out.println("Error. Password too short.");
            else break;
        }

        String contact;
        while (true) {
            System.out.print("Contact number (11 digits): ");
            contact = scanner.nextLine();
            if (!contact.matches("\\d{11}")) System.out.println("Error. Must be 11 digits.");
            else break;
        }

        String location;
        while (true) {
            System.out.print("Location: ");
            location = scanner.nextLine();
            if (location.isBlank()) System.out.println("Error. Cannot be empty.");
            else break;
        }

        System.out.println("Select role:");
        System.out.println("1. Buyer");
        System.out.println("2. Farmer");
        System.out.print("Enter: ");
        String roleChoice = scanner.nextLine();

        User newUser;
        switch (roleChoice) {
            case "1" -> newUser = new Buyer(name, username, password, contact, location);
            case "2" -> newUser = new Farmer(name, username, password, contact, location);
            default -> {
                System.out.println("❌ Invalid role.");
                return;
            }
        }

        users.add(newUser);
        saveUserToFile(newUser); // save to file for persistence
        System.out.println("\nYasss! Registration successful! You can now login.");
    }

    private static boolean usernameExists(String username) {
        return users.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    // ---------------- LOGIN -----------------
    private static void loginUser() {
        System.out.println("\n--- Login ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User loggedInUser = authenticate(username, password);

        if (loggedInUser == null) {
            System.out.println("❌ Incorrect username or password.");
            return;
        }

        while (true) {
            System.out.println("\nLogged in as: " + loggedInUser.getRole());
            System.out.println("1. Continue to Menu");
            System.out.println("2. Delete My Account");
            System.out.println("3. Logout");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    if (loggedInUser instanceof Farmer farmer) farmerMenu(farmer);
                    if (loggedInUser instanceof Buyer buyer) buyerMenu(buyer);
                }
                case "2" -> {
                    System.out.print("Are you sure you want to delete your account? (yes/no): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        users.remove(loggedInUser);
                        saveAllUsersToFile(); // update file after deletion
                        System.out.println("✅ Account deleted successfully.");
                        return;
                    } else {
                        System.out.println("Deletion canceled.");
                    }
                }
                case "3" -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static User authenticate(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) return u;
        }
        return null;
    }

    // ---------------- FARMER MENU -----------------
    private static void farmerMenu(Farmer farmer) {
        while (true) {
            System.out.println("\n--- Farmer Menu ---");
            System.out.println("1. Add Coffee Product");
            System.out.println("2. View My Products");
            System.out.println("3. Logout");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Type/Variety: ");
                    String variety = scanner.nextLine();
                    System.out.print("Quality: ");
                    String quality = scanner.nextLine();
                    System.out.print("Quantity (kg): ");
                    int qty = Integer.parseInt(scanner.nextLine());
                    System.out.print("Price per kg: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Availability: ");
                    String availability = scanner.nextLine();

                    CoffeeBean bean = new CoffeeBean(name, variety, quality, qty, price, availability);
                    farmer.addProduct(bean);
                    marketProducts.add(bean);

                    System.out.println("\n✅ Product added!");
                }
                case "2" -> {
                    System.out.println("\n--- Your Products ---");
                    if (farmer.getProducts().isEmpty()) System.out.println("No products yet.");
                    else farmer.getProducts().forEach(CoffeeBean::display);
                }
                case "3" -> {
                    System.out.println("Logging out... 👋");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ---------------- BUYER MENU -----------------
    private static void buyerMenu(Buyer buyer) {
        while (true) {
            System.out.println("\n--- Buyer Menu ---");
            System.out.println("1. View Available Coffee Products");
            System.out.println("2. Logout");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("\n--- Coffee Products ---");
                    if (marketProducts.isEmpty()) System.out.println("No products available yet.");
                    else marketProducts.forEach(CoffeeBean::display);
                }
                case "2" -> {
                    System.out.println("Logging out... 👋");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ---------------- FILE HANDLING -----------------
    private static void saveUserToFile(User user) {
        try (FileWriter fw = new FileWriter(USER_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(user.getUsername() + "," + user.getPassword() + "," + user.getName() + "," + user.getRole());
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    private static void saveAllUsersToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter(USER_FILE))) {
            for (User u : users) {
                out.println(u.getUsername() + "," + u.getPassword() + "," + u.getName() + "," + u.getRole());
            }
        } catch (IOException e) {
            System.out.println("Error updating users: " + e.getMessage());
        }
    }

    private static void loadUsersFromFile() {
        File file = new File(USER_FILE);
        if (!file.exists()) return; // no users yet

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                String name = parts[2];
                String role = parts[3];

                User user;
                if (role.equals("Buyer")) user = new Buyer(name, username, password, "", "");
                else user = new Farmer(name, username, password, "", "");

                users.add(user);
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }
}
