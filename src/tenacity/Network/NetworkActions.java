package tenacity.Network;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkActions {
	
	static public void createClientSession(Socket socket) throws UnknownHostException {
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		System.out.println(socket.getInetAddress().getHostAddress());
		//Commented out because I'll be doing testing with TenacityClient on the same machine
		/*if (InetAddress.getLocalHost().equals(socket.getInetAddress())) {
			System.out.println("Server session recognized");
			new ClientSession(socket, true).start(); //If the server is the one creating a connection, make a PlayerServer in ClientSession
		} else {
			System.out.println("Client session recognized");
			new ClientSession(socket).start(); //Otherwise, handle ClientSession creation normally
		}*/
		new ClientSession(socket).start();
	}
	
	
}
