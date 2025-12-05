package creatureLibrary;

public class Golem extends Creature implements Ability {

    public Golem(int health, int speed, String elementType) {
        super(health, speed, elementType);

        this.canFly = false;
        this.resistances = new String[] { "physical", "earth" };
        this.vulnerabilities = new String[] { "water", "lightning" };
    }
    
    public Golem(){};

    @Override
    void move() {
        System.out.println("The Golem trudges forward heavily, each step shaking the ground.");
    }

    @Override
    void makeSound() {
        System.out.println("The Golem rumbles with grinding stone noises.");
    }

    @Override
    public void useAbility() {
        System.out.println("The Golem uses Stone Skin, hardening its body to reduce damage!");
    }
}
