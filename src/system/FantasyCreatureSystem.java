package system;

import java.util.ArrayList;
import java.util.List;
import creatureLibrary.*;

public class FantasyCreatureSystem {

    // List to hold all creatures
    private List<Creature> creatures;

    // Constructor
    public FantasyCreatureSystem() {
        creatures = new ArrayList<>();
    }

    // 1. Add Creature
    public void addCreature(Creature creature) {
        creatures.add(creature);
        System.out.println(creature.getClass().getSimpleName() + " added to the system.");
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