package tenacity.Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkActions {
	static public void createClientSession(InetAddress address, int port, String name) throws UnknownHostException {
		new ClientSession(address,port,name);
	}
}
