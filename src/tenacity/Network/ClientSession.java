package tenacity.Network;

import java.net.*;

import tenacity.Entity.PlayerClient;

public class ClientSession extends Thread {
	String username;
	PlayerClient player;
	
	int sessionID;
	int port;
	InetAddress address;
	
	static int sessionCount = 1;
	
	ClientSession(InetAddress address, int port, String name) throws UnknownHostException {
		sessionID = sessionCount++;
		NetworkCore.sessions.add(this);
		player = new PlayerClient(name, this);
		this.setName("clientsession_"+sessionID);
		
		this.port = port;
		this.address = address;
		System.out.println("Client session initiated with values:");
		System.out.println("Port: "+port);
		System.out.println("Address: "+address.getHostAddress());
		System.out.println("SessionID: "+sessionID);
		System.out.println("Name: "+name);
		new DatagramSender("SESSIONCREATE "+sessionID+" "+InetAddress.getLocalHost().getHostAddress()+" "+NetworkCore.port, address, port);
	}
	
	public void send(String string) {
		new DatagramSender(string, address, port);
	}
}
