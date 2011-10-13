package tenacity.Entity;

import tenacity.Network.ClientSession;

public class PlayerClient extends Player {
	
	public PlayerClient(String name, ClientSession session) {
		super(name, session);
		className = "PlayerClient";
		this.session = session;
	}
	
}
