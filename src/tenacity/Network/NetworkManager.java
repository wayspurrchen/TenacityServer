package tenacity.Network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;



public class NetworkManager extends Thread{
	
	public Vector<ClientSession> sessions;
	public ServerSocket serverSocket = null;
	public int port = 4444;
	
	public NetworkManager() throws IOException {
		sessions = new Vector<ClientSession>();
		
	}
	
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Listening on port "+port);
			//new ConnectionManager().start();
			
			while (NetworkCore.listening) {
				NetworkActions.createClientSession(serverSocket.accept());
			}

			serverSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
			e.printStackTrace();
		}
	}
	
}
