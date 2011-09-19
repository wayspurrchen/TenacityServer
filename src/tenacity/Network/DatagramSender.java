package tenacity.Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import tenacity.Core.Constants;

public class DatagramSender {
	
	DatagramSocket socket;
	InetAddress address;
	int port;
	
	DatagramSender(String output, InetAddress address, int port) {
		byte[] buf = new byte[Constants.NETWORK_BUFFER_INT];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		this.address = address;
        this.port = port;
        buf = output.getBytes();
        packet = new DatagramPacket(buf, buf.length, address, port);
        socket = NetworkCore.socket;
        
        try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
