package tenacity.Network;

import java.io.*;
import java.net.*;

import tenacity.Core.World;
import tenacity.Entity.Player;
import tenacity.Entity.PlayerClient;
import tenacity.Entity.PlayerServer;

public class ClientSession extends Thread {
	String username;
	Player player;
	
	private Socket socket = null;
	
	int sessionID;
	private int port;
	private InetAddress address;
	
	static int sessionCount = 1;
	
	ClientSession(Socket socket) throws UnknownHostException {
		this.socket = socket;
		sessionID = sessionCount++;
		NetworkCore.networkManager.sessions.add(this);
		player = new PlayerClient("client", this);
		this.setName("clientsession_"+sessionID);
		address = socket.getInetAddress();
		
		System.out.println("Client session initiated with values:");
		System.out.println("SessionID: "+sessionID);
		System.out.println("Player: "+player.getName());
	}
	
	ClientSession(Socket socket, boolean server) throws UnknownHostException {
		this.socket = socket;
		sessionID = sessionCount++;
		NetworkCore.networkManager.sessions.add(this);
		if (!server) {
			player = new PlayerClient("Client", this);
			System.out.println("Player ClientSession initialized with false server constructor. Why?");
		} else {
			player = new PlayerServer("Server", this);
		}
		this.setName("clientsession_"+sessionID);
		World.playerServer = player;
		
		System.out.println("Client session initiated with values:");
		System.out.println("SessionID: "+sessionID);
		System.out.println("Player: "+player.getName());
	}
	
	public void run() {
		PrintWriter out;
		
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			
	        BufferedReader in = new BufferedReader(
	                    new InputStreamReader(
	                    socket.getInputStream()));
	 
	        String inputLine, outputLine;
	        while ((inputLine = in.readLine()) != null) {
	            System.out.println("CLIENT ["+address.getHostAddress()+"]: "+inputLine);
	        }
	        out.close();
	        in.close();
	        socket.close();
	            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(String string) {
		
	}
	
	public Player getClientPlayer() {
		return player;
	}
	
	public String getClientUsername() {
		return username;
	}
	
	public Socket getClientSocket() {
		return socket;
	}
}
