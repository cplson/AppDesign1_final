package creatureLibrary;

public class Hydra extends Creature implements Ability {

    public Hydra(int health, int speed, String elementType) {
        super(health, speed, elementType);

        this.canFly = false;
        this.resistances = new String[] { "water", "poison" };
        this.vulnerabilities = new String[] { "fire", "lightning" };
    }

    @Override
    void move() {
        System.out.println("The Hydra stomps forward, its many heads surveying the area.");
    }

    @Override
    void makeSound() {
        System.out.println("The Hydra roars, multiple voices echoing at once.");
    }

    @Override
    public void useAbility() {
        System.out.println("The Hydra regenerates its wounds and spits acidic venom!");
    }
}
