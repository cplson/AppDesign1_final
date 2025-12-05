package driver;
import creatureLibrary.*;
import system.FantasyCreatureSystem;
import java.util.Scanner;

public class CreatureManager {

	static void main(String[] args) {
        FantasyCreatureSystem creatureSystem = new FantasyCreatureSystem();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            System.out.println("\n====== Creature Management Menu ======");
            System.out.println("1. Add Creature");
            System.out.println("2. Remove Creature");
            System.out.println("3. Display Creature");
            System.out.println("4. Filter by Type");
            System.out.println("5. Show Statistics");
            System.out.println("6. Save Data");
            System.out.println("7. Load Data");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");

            // VALIDATION: ensure numeric input
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                // VALIDATION: ensure number 1–8
                if (choice < 1 || choice > 8) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    continue;   // restart loop
                }

            } else {
                // consume invalid input
                System.out.println("Invalid input. Please enter a NUMBER between 1 and 8.");
                scanner.next();
                continue;       // restart loop
            }

            // MENU ACTIONS (placeholders)
            switch (choice) {
                case 1:
                    System.out.println("You chose: Add Creature");
                    creatureSystem.addCreature(scanner);
                    break;

                case 2:
                    System.out.println("You chose: Remove Creature");
                    creatureSystem.removeCreature(scanner);
                    break;

                case 3:
                    System.out.println("You chose: Display Creature");
                    // TODO: display creature logic
                    break;

                case 4:
                    System.out.println("You chose: Filter by Type");
                    // TODO: filter logic
                    break;

                case 5:
                    System.out.println("You chose: Show Statistics");
                    // TODO: statistics logic
                    break;

                case 6:
                    System.out.println("You chose: Save Data");
                    // TODO: save logic
                    break;

                case 7:
                    System.out.println("You chose: Load Data");
                    // TODO: load data logic
                    break;

                case 8:
                    System.out.println("Exiting program... Goodbye!");
                    break;
            }
        }

        scanner.close();
	}

}
