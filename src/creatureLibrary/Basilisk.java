package creatureLibrary;

public class Basilisk extends Creature implements Ability {

    public Basilisk(String name, int health, int speed, String elementType) {
        super(name, health, speed, elementType);

        this.name = name;
        this.canFly = false;
        this.resistances = new String[] { "poison", "earth" };
        this.vulnerabilities = new String[] { "ice", "holy" };
    }

    @Override
    void move() {
        System.out.println("The Basilisk slithers silently across the ground.");
    }

    @Override
    void makeSound() {
        System.out.println("The Basilisk hisses menacingly.");
    }

    @Override
    public void useAbility() {
        System.out.println("The Basilisk uses Petrifying Gaze! Its target begins turning to stone!");
    }
}
