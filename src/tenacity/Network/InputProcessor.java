package tenacity.Network;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import tenacity.Core.PlayerActions;
import tenacity.Entity.PlayerClient;

public class InputProcessor extends Thread {
	DatagramPacket packet;
	String inputText;
	String[] splitText;
	PlayerClient clientPlayer;
	ClientSession clientSession;
	boolean sessionExists = false;
	int port;
	InetAddress address;
	
	public InputProcessor(DatagramPacket packet, String cmd, InetAddress address, int port) {
		this.packet = packet;
		this.port = port;
		this.address = address;
		
		for (int i=0;i<NetworkCore.sessions.size();i++) {
			ClientSession compSession = NetworkCore.sessions.get(i);
			System.out.println("it "+i+" "+compSession);
			System.out.println(compSession.address.getHostAddress()+" vs "+packet.getAddress().getHostAddress());
			System.out.println(compSession.port+" vs "+packet.getPort()); // && compSession.port==packet.getPort()
			if (compSession.address.equals(address)) {
				sessionExists = true;
				clientSession = compSession;
				clientPlayer = clientSession.player;
				System.out.println("Input processor created, bound to "+clientSession);
				break;
			}
		}
		
		inputText = cmd;
		splitText = splitInputText();
		this.setName("InputProcessor");
		System.out.println("Input processor created, unbound");
	}
	
	String[] splitInputText() {
		String REGEX = " ";
		Pattern p = Pattern.compile(REGEX);
	    String[] line = p.split(inputText);
	    for (int i = 0; i < line.length; i++) {
	    	//line[i].toLowerCase();
	    	//System.out.print(line[i]+"="+i+":");
	    	//shows debug info about each item
	    }
	    System.out.println();
	    return line;
	}
	
	String stringAfter(String[] stringArray, int after) {
		String fullLine = "";
		for (int i = after+1;i<stringArray.length;i++) {
			fullLine += stringArray[i];
			if (i<stringArray.length-1) fullLine+=" ";
		}
		return fullLine;
	}
	
	public void run() {
		System.out.println("Input processor running");
		
		String[] input = splitInputText();
		
		if (input[0].equals("send") && input.length>2) {
			
		} else if (input[0].equals("CONREQ")) {
        	if (!sessionExists) {
        		try {
					NetworkActions.createClientSession(address,Integer.parseInt(input[1]),input[2]);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
	        } else System.out.println("Session already exists, clientSession not initialized");
		} else if (input[0].equals("look")) {
			if (sessionExists) {
				PlayerActions.look(clientPlayer);
				System.out.println("InputProcessor sent look with "+clientPlayer);
			} else System.out.println("[look] command received, client is not initiated!");
		} else if (input[0].equals("say") && input.length>1) {
			if (sessionExists) {
				PlayerActions.say(clientPlayer, stringAfter(input,0));
				System.out.println("InputProcessor sent look with "+clientPlayer);
			} else System.out.println("[say] command received, client is not initiated!");
		} else if (input[0].equals("emote") || input[0].equals("me") || input[0].equals("em") && input.length>1) {
			if (sessionExists) {
				PlayerActions.emote(clientPlayer, stringAfter(input,0));
				System.out.println("InputProcessor sent emote with "+clientPlayer);
			} else System.out.println("[emote] command received, client is not initiated!");
		}
		
		
		/*if (input[0].equals("send") && input.length>2) {
			System.out.println(input[0]+" "+input[1]+" "+input[2]);
			String fullLine = "";
			for (int i = 2;i<input.length;i++) {
				fullLine += input[i]+" ";
			}
			Core.connections.get(Integer.parseInt(input[1])).out.println(fullLine);
			GUI.println("You: "+fullLine);
			GUI.setEntryText(input[0]+" "+input[1]+" ");
		} else if (input[0].equals("users")) {
			System.out.println(Core.connections);
			GUI.clearEntry();
		} else if (input[0].equals("check") && input.length>1) {
			int tmp = Integer.parseInt(input[1]);
			System.out.println(tmp);
			System.out.println(Core.connections.get(tmp));
			GUI.clearEntry();
			GUI.getEntryField().setCaretPosition(GUI.getEntryText().length());
		} else if (input[0].equals("look") && input.length==1) {
			PlayerMethods.look();
			GUI.clearEntry();
			GUI.getEntryField().setCaretPosition(GUI.getEntryText().length());
		}*/
		
		
		try {
			this.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
