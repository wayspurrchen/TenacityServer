package tenacity.Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

import tenacity.Core.Constants;

public class DatagramReceiver extends Thread {
	ServerSocket server = null;
	Socket client = null;
	boolean listening = true;
	private DatagramSocket socket;
	
	public DatagramReceiver() throws IOException {
		socket = NetworkCore.socket;
	}
	
	public void run() {
		try{
			while (listening) {
				byte[] buf = new byte[Constants.NETWORK_BUFFER_INT];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                System.out.println(packet.getPort()+" "+packet.getAddress().getHostAddress());
                String cmd = new String(packet.getData(),0,packet.getLength());
                System.out.println("received "+packet+": "+cmd+", sending to InputProcessor");
                new InputProcessor(packet, cmd, packet.getAddress(), packet.getPort()).start();
			}
		} catch (IOException e) {
		System.out.println("Accept failed: 4444");
		System.exit(-1);
		}
		
		
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
