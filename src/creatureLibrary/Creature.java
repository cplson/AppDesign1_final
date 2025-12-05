package creatureLibrary;

public abstract class Creature {
	protected boolean canFly;
	protected int health;
	protected int speed;
	protected String elementType;
	protected String[] resistances;
	protected String[] vulnerabilities;
	
	Creature(int health, int speed, String elementType){

		this.health = health;
		this.speed = speed;
		this.elementType = elementType;
	}
	
	Creature(){}
	
	public void displayInfo() {
	    System.out.println("=== Creature Info ===");
	    System.out.println("Can Fly: " + canFly);
	    System.out.println("Health: " + health);
	    System.out.println("Speed: " + speed);
	    System.out.println("Element Type: " + elementType);

	    System.out.print("Resistances: ");
	    if (resistances != null && resistances.length > 0) {
	        for (String r : resistances) {
	            System.out.print(r + " ");
	        }
	    } else {
	        System.out.print("None");
	    }
	    System.out.println();

	    System.out.print("Vulnerabilities: ");
	    if (vulnerabilities != null && vulnerabilities.length > 0) {
	        for (String v : vulnerabilities) {
	            System.out.print(v + " ");
	        }
	    } else {
	        System.out.print("None");
	    }
	    System.out.println("\n=====================\n");
	}
	
	int takeDamage(int amount, String damageType) {
		int updatedHealth = health;
		boolean isVulnerable = false;
		
		for (String v: vulnerabilities) {
			if (v.equals(damageType)) {
				isVulnerable = true;
				break;
			}
		}
		
		if (damageType.equals(elementType)) {
			updatedHealth = updatedHealth - (amount / 2);
		} else if(isVulnerable) {
			updatedHealth = updatedHealth - (amount * 2);
		} else {
			updatedHealth = updatedHealth - amount;
		}
		
		this.health = updatedHealth;
		return this.health;
	}

    public String getElementType(){
        return this.elementType;
    }
	
	abstract void move();
	abstract void makeSound();
	abstract void useAbility();
	
}
