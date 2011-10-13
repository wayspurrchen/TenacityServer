package tenacity.Entity;

import tenacity.Network.ClientSession;

public class PlayerServer extends Player {
	
	public PlayerServer(String name, ClientSession session) {
		super(name, session);
		className = "PlayerServer";
		this.session = session;
	}
	
}
