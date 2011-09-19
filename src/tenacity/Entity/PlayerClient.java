package tenacity.Entity;

import tenacity.Network.ClientSession;

public class PlayerClient extends Player {
	
	ClientSession session;
	
	public PlayerClient(String name, ClientSession session) {
		super(name);
		className = "PlayerClient";
		this.session = session;
	}
	
	public ClientSession getClientSession() {
		return session;
	}
	
	
}
