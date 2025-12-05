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
        System.out.print("\nEnter creature name: ");
        String name = scanner.next();

        // Creature type selection
        int choice = 0;
        while (true) {
            System.out.println("\n--- Select Creature Type ---");
            System.out.println("1. Hydra");
            System.out.println("2. Basilisk");
            System.out.println("3. Golem");
            System.out.println("4. Wyvern");
            System.out.print("Enter choice (1-4): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (choice >= 1 && choice <= 4) break;
                else System.out.println("Invalid choice. Enter 1, 2, 3, or 4.");
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine(); // consume invalid input
            }
        }

        // Prompt for properties
        int health = promptForInt(scanner, "Enter health (integer): ");
        int speed = promptForInt(scanner, "Enter speed (integer): ");
        System.out.print("Enter element type (e.g., Fire, Water): ");
        String elementType = scanner.nextLine();

        // Create creature based on type
        Creature newCreature = null;
        switch (choice) {
            case 1: newCreature = new Hydra(name, health, speed, elementType); break;
            case 2: newCreature = new Basilisk(name, health, speed, elementType); break;
            case 3: newCreature = new Golem(name, health, speed, elementType); break;
            case 4: newCreature = new Wyvern(name, health, speed, elementType); break;
        }

        creatures.add(newCreature);
        System.out.println(newCreature.getClass().getSimpleName() + " named \"" + name + "\" added!");
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
    public void removeCreature(Scanner scanner) {
        if (creatures.isEmpty()) {
            System.out.println("No creatures to remove.");
            return;
        }

        System.out.print("\nEnter the name of the creature to remove: ");
        String name = scanner.next();
        Creature toRemove = null;

        // Search for creature by name
        for (Creature c : creatures) {
            if (c.getName().equalsIgnoreCase(name)) {
                toRemove = c;
                break;
            }
        }

        if (toRemove != null) {
            creatures.remove(toRemove);
            System.out.println(toRemove.getClass().getSimpleName() + " named \"" + name + "\" removed!");
        } else {
            System.out.println("No creature found with the name \"" + name + "\". Returning to main menu.");
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