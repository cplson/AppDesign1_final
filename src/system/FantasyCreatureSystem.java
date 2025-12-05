package system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import creatureLibrary.*;

public class FantasyCreatureSystem {

    // List to hold all creatures
    private List<Creature> creatures;

    // Constructor
    public FantasyCreatureSystem() {
        creatures = new ArrayList<>();
    }

    // 1. Add Creature
    public void addCreature(Scanner scanner) {
        int choice = 0;

        // Creature type selection
        while (true) {
            System.out.println("\n--- Select Creature Type ---");
            System.out.println("1. Hydra");
            System.out.println("2. Basilisk");
            System.out.println("3. Golem");
            System.out.print("Enter choice (1-3): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine(); // consume invalid input
            }
        }

        // --- Prompt for creature properties ---
        int health = promptForInt(scanner, "Enter health (integer): ");
        int speed = promptForInt(scanner, "Enter speed (integer): ");
        System.out.print("Enter element type (e.g., Fire, Water): ");
        String elementType = scanner.nextLine();

        // --- Create the chosen creature ---
        Creature newCreature = null;

        switch (choice) {
            case 1:
                newCreature = new Hydra(health, speed, elementType);
                break;
            case 2:
                newCreature = new Basilisk(health, speed, elementType);
                break;
            case 3:
                newCreature = new Golem(health, speed, elementType);
                break;
        }

        creatures.add(newCreature);
        System.out.println(newCreature.getClass().getSimpleName() + " added to the system!");
    }

    // Helper method to prompt for integers with validation
    private int promptForInt(Scanner scanner, String message) {
        int value = 0;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // consume invalid input
            }
        }
        return value;
    }


    // 2. Remove Creature by index (or name, you can adjust)
    public void removeCreature(int index) {
        if (index >= 0 && index < creatures.size()) {
            Creature removed = creatures.remove(index);
            System.out.println(removed.getClass().getSimpleName() + " removed from the system.");
        } else {
            System.out.println("Invalid index. No creature removed.");
        }
    }

    // 3. Display all creatures
    public void displayCreatures() {
        if (creatures.isEmpty()) {
            System.out.println("No creatures in the system.");
        } else {
            for (int i = 0; i < creatures.size(); i++) {
                System.out.println("Index " + i + ":");
                creatures.get(i).displayInfo();
            }
        }
    }

    // 4. Filter by Element Type
    public void filterByType(String elementType) {
        boolean found = false;
        for (Creature c : creatures) {
            if (c.getElementType().equalsIgnoreCase(elementType)) {
                c.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No creatures found with element type: " + elementType);
        }
    }

    // 5. Show basic statistics (count, optional more later)
    public void showStatistics() {
        System.out.println("Total creatures: " + creatures.size());
        // Optional: add more statistics later (e.g., average health)
    }

    // 6. Save Data (placeholder)
    public void saveData() {
        System.out.println("Saving creatures... (functionality not implemented yet)");
    }

    // 7. Load Data (placeholder)
    public void loadData() {
        System.out.println("Loading creatures... (functionality not implemented yet)");
    }

    // Optional getter for list (if needed in main)
    public List<Creature> getCreatures() {
        return creatures;
    }
}