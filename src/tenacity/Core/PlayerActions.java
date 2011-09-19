package tenacity.Core;

import tenacity.Entity.Entity;
import tenacity.Entity.PlayerClient;
import tenacity.Network.ClientSession;
import tenacity.Places.*;

public class PlayerActions {
	
	public static void look(PlayerClient player) {
		System.out.println("Running PlayerAction [look]");
		Area area = player.getCurrentArea();
		ClientSession playerThread = player.getClientSession();
		playerThread.send("COLPRNT You are in \\_place\\"+area.getLocationName()+".");
		playerThread.send("COLPRNT "+area.getLongDesc()+" You look around the area and see: "
				+area.getEntityDescs());
		//GUI.printColor("place",area.getLocationName());
		//GUI.print(". "+area.getLongDesc(), true);
		//GUI.printParseColor("You look around the area and see: "+area.getEntityDescs(), true);
	}
	
	public static void say(PlayerClient player, String message) {
		System.out.println("Running PlayerAction [say]");
		Area area = player.getCurrentArea();
		ClientSession playerThread = player.getClientSession();
		for (int i=0;i<area.getEntities().size();i++) {
			Entity entity = area.getEntities().get(i);
			if (entity instanceof PlayerClient && !entity.equals(player)) {
				PlayerClient playerEntity = (PlayerClient) entity;
				playerEntity.getClientSession().send("COLPRNT "+player.getName()+" says, \""+message+"\"");
			}
		}
		playerThread.send("COLPRNT You say, \""+message+"\"");
	}
	
	public static void emote(PlayerClient player, String message) {
		System.out.println("Running PlayerAction [emote]");
		Area area = player.getCurrentArea();
		ClientSession playerThread = player.getClientSession();
		for (int i=0;i<area.getEntities().size();i++) {
			Entity entity = area.getEntities().get(i);
			if (entity instanceof PlayerClient && !entity.equals(player)) {
				PlayerClient playerEntity = (PlayerClient) entity;
				playerEntity.getClientSession().send("COLPRNT "+player.getName()+" "+message);
			}
		}
		playerThread.send("COLPRNT "+player.getName()+" "+message);
	}
	
	/*public static void age() {
		GUI.println(World.getAgeFormattedStrings());
	}
	
	public static void age(String entity) {
		Place place = World.location[World.player.getPlaceX()][World.player.getPlaceY()][World.player.getPlaceZ()];
		Vector<Entity> entities = place.getEntities();
		boolean found = false;
		for (int i=0;i<entities.size();i++) {
			System.out.println(entities.get(i).getName());
			if (entities.get(i).getName().toLowerCase().equals(entity)) {
				found = true;
				GUI.println(String.valueOf(entities.get(i).getAgeFormattedStrings()));
			}
		}
		if (!found) {
			GUI.println("There's nothing around that goes by that name.");
		}
	}*/

}
