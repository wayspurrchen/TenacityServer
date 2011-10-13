package tenacity.Network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;



public class NetworkCore{
	
	public static boolean listening = true;
	public static NetworkManager networkManager;
	
	public NetworkCore() throws IOException {
		networkManager = new NetworkManager();
		networkManager.start();
		//Socket serverClientSocket = new Socket(InetAddress.getLocalHost(), 4444); // Create server session
	}
	
}
