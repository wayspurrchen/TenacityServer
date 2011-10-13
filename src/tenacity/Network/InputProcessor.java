package tenacity.Network;

import java.net.Socket;
import java.util.regex.Pattern;

import tenacity.Core.PlayerActions;
import tenacity.Core.World;
import tenacity.Entity.Player;
import tenacity.Entity.PlayerClient;

public class InputProcessor extends Thread {
	Socket socket;
	String inputText;
	String[] splitText;
	Player clientPlayer;
	ClientSession clientSession;
	boolean serverSide = false;
	
	public InputProcessor(String cmd, ClientSession clientSession) {
		this.clientSession = clientSession;
		this.clientPlayer = clientSession.getClientPlayer();
		this.socket = clientSession.getClientSocket();
		
		/*for (int i=0;i<NetworkCore.sessions.size();i++) {
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
		}*/
		
		inputText = cmd;
		splitText = splitInputText();
		this.setName("InputProcessor");
		System.out.println("Input processor created via client-received input");
	}
	
	public InputProcessor(String cmd) {
		this.setName("InputProcessor");
		inputText = cmd;
		splitText = splitInputText();
		clientPlayer = World.playerServer;
		System.out.println("Input processor created via server-side input");
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
		System.out.println("Input processor running command \"" + inputText + "\"");
		
		String[] input = splitInputText();
		
		if (input[0].equals("send") && input.length>2) {
			
		} else if (input[0].equals("look")) {
			PlayerActions.look(clientPlayer);
			System.out.println("InputProcessor sent look with "+clientPlayer);
		} else if (input[0].equals("say") && input.length>1) {
			PlayerActions.say(clientPlayer, stringAfter(input,0));
			System.out.println("InputProcessor sent look with "+clientPlayer);
		} else if (input[0].equals("emote") || input[0].equals("me") || input[0].equals("em") && input.length>1) {
			PlayerActions.emote(clientPlayer, stringAfter(input,0));
			System.out.println("InputProcessor sent emote with "+clientPlayer);
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
