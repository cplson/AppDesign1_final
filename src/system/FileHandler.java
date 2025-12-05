package system;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import creatureLibrary.Creature;
import creatureLibrary.Hydra;
import creatureLibrary.Basilisk;
import creatureLibrary.Golem;
import creatureLibrary.Wyvern;

public class FileHandler {

    // Save creatures to a file
    public static void saveCreatures(String filename, List<Creature> creatures) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Creature c : creatures) {
                String type = c.getClass().getSimpleName();
                writer.println(type + "," + c.getName() + "," + c.getHealth() + "," + c.getSpeed() + "," + c.getElementType());
            }
            System.out.println("Creatures saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load creatures from a file and return as a list
    public static List<Creature> loadCreatures(String filename, List<Creature> creatures) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File not found: " + filename);
            return creatures;
        }

        creatures.clear(); // clear current list

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length != 5) continue; // skip invalid lines

                String type = parts[0];
                String name = parts[1];
                int health = Integer.parseInt(parts[2]);
                int speed = Integer.parseInt(parts[3]);
                String elementType = parts[4];

                Creature c = null;
                switch (type) {
                    case "Hydra": c = new Hydra(name, health, speed, elementType); break;
                    case "Basilisk": c = new Basilisk(name, health, speed, elementType); break;
                    case "Golem": c = new Golem(name, health, speed, elementType); break;
                    case "Wyvern": c = new Wyvern(name, health, speed, elementType); break;
                    default: System.out.println("Unknown creature type: " + type); continue;
                }

                creatures.add(c);
            }
            System.out.println("Creatures loaded from file: " + filename);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        return creatures;
    }
}
