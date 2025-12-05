package creatureLibrary;

public class Wyvern extends Creature implements Ability {

    public Wyvern(int health, int speed, String elementType) {
        super(health, speed, elementType);

        this.canFly = true;
        this.resistances = new String[] { "fire", "wind" };
        this.vulnerabilities = new String[] { "ice", "earth" };
    }

    @Override
    void move() {
        System.out.println("The Wyvern flies swiftly across the sky.");
    }

    @Override
    void makeSound() {
        System.out.println("The Wyvern screeches sharply from above.");
    }

    @Override
    public void useAbility() {
        System.out.println("The Wyvern unleashes a fiery breath attack!");
    }
}
