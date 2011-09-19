
package tenacity.Entity;

import java.util.Hashtable;

import tenacity.Combat.Stance;
import tenacity.Entity.Mind.Mind;
import tenacity.Entity.Mind.Action.Action;
import tenacity.Places.Place;

public class DynamicBeing extends Being {
	
	int placeX = 0;
	int placeY = 0;
	int placeZ = 0;
	int stat_strength = 10;
	int stat_dexterity = 10;
	int stat_agility = 10;
	int health = 100;
	
	Mind mind = new Mind();
	
	Hashtable<String, Integer> stats = new Hashtable<String,Integer>();
	
	public DynamicBeing() {
		super();
		initStrings();
	}
	
	public DynamicBeing(String name) {
		super(name);
		initStrings();
	}
	
	public DynamicBeing(String name, Place place) {
		super(name, place);
		initStrings();
	}
	
	public DynamicBeing(String name, Place place, int x, int y, int z) {
		super(name, place, x, y, z);
		initStrings();
	}
	
	public void initStrings() {
		className = "DynamicBeing";
		descShort = "A dynamic-looking being";
		descPlace = "A dynamic-looking being named \\_being\\"+getName();
	}
	
	public Mind getMind() {
		return mind;
	}
	
	public int getPlaceX() {
		return placeX;
	}
	
	public int getPlaceY() {
		return placeY;
	}
	
	public int getPlaceZ() {
		return placeZ;
	}
	
	public int getStrength() {
		return stat_strength;
	}
	
	public int getDexterity() {
		return stat_dexterity;
	}
	
	public int getAgility() {
		return stat_agility;
	}
	
	public int getHealth() {
		return health;
	}
	
	public Stance getStance() {
		return body().getStance();
	}
	
	public Inventory getInv() {
		return inventory;
	}
	
	public void performAction(String action, Entity target) {
		Action.createAction(action, this, target);
	}
	
	// used for getTraitValue, getTraitIndex, and firstOrSecondary
	
	
}
