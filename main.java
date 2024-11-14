// DSSMain.java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DSSMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> actions = new ArrayList<>();
        HashSet<String> uniqueDecisions = new HashSet<>(); // To ensure uniqueness
        final int MAX_DECISIONS = 256;

        System.out.println("Welcome to the Decision Support Aid.");

        while (true) {
            if (actions.size() >= MAX_DECISIONS) {
                System.out.println("Maximum limit of 256 unique decisions reached. Cannot add more actions.");
                break;
            }

            System.out.print("What do you want to do today? (Type 'exit' to quit): ");
            String userInput = scanner.nextLine().trim();

            // Exit condition
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            // Add user input if it's unique and limit has not been reached
            if (!uniqueDecisions.contains(userInput)) {
                actions.add(userInput);
                uniqueDecisions.add(userInput); // Track unique inputs
                System.out.println("Added: " + userInput);
            } else {
                System.out.println("This action has already been added. Please enter a different action.");
            }
        }

        // Print all stored actions
        System.out.println("\nSummary of unique actions:");
        for (String action : actions) {
            System.out.println(" - " + action);
        }

        scanner.close();
        System.out.println("Thank you for using the Decision Support Aid.");
    }
}
