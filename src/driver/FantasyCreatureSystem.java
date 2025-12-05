package driver;
import creatureLibrary.*;

public class FantasyCreatureSystem {

	public static void main(String[] args) {
		Golem creature = new Golem(100, 20, "fire");
		Golem golem = new Golem();
		golem.displayInfo();
		creature.displayInfo();
	}

}
