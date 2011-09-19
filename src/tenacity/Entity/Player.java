
package tenacity.Entity;

public class Player extends DynamicBeing {
	
	public Player(String name) {
		this.name = name;
		placeX = 0;
		placeY = 0;
		placeZ = 0;
		stat_strength = 10;
		stat_dexterity = 10;
		stat_agility = 10;
		className = "Player";
		descPlace = "A player named \\_player\\"+getName();
	}
	

	
	// used for getTraitValue, getTraitIndex, and firstOrSecondary
	
	
}
