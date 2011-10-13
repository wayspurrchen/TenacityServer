
package tenacity.Entity;

import tenacity.Network.ClientSession;

public class Player extends DynamicBeing {
	
	ClientSession session = null;
	
	public Player(String name, ClientSession session) {
		this.name = name;
		this.session = session;
		placeX = 0;
		placeY = 0;
		placeZ = 0;
		stat_strength = 10;
		stat_dexterity = 10;
		stat_agility = 10;
		className = "Player";
		descPlace = "A player named \\_player\\"+getName();
	}
	
	public ClientSession getClientSession() {
		return session;
	}

	
	// used for getTraitValue, getTraitIndex, and firstOrSecondary
	
	
}
