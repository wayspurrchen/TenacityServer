package tenacity.Network;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.*;



public class NetworkCore {
	
	public static Vector<ClientSession> sessions;
	public static DatagramSocket socket;
	public static int port = 4444;
	
	public NetworkCore() {
		sessions = new Vector<ClientSession>();
		
		try {
			socket = new DatagramSocket(port);
			new DatagramReceiver().start();
		} catch (SocketException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
