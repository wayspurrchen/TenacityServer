package tenacity.Core;

import java.util.*;

import tenacity.Entity.*;
import tenacity.GUI.GUI;
import tenacity.Network.NetworkCore;


public class Core {
	
	public static NetworkCore networkCore;
	public static boolean gameRunning = true;
	
	public static long startTime = System.currentTimeMillis();
	static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	
	final static int FRAMES_PER_SECOND = 1;
    final static int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
    
    static long next_game_tick = elapsedTime();
    static long sleep_time = 0;
	
	public static void main(String args[]) throws Exception {
		//networkCore = new NetworkCore();
		GUI.initGUI();
		GUI.println("Server app");
		World.setupWorld();
		
		while (gameRunning) {
	    	Iterator<Entity> evIterator = Entity.getEntityVector().iterator();
	    	//Update
	    	while (evIterator.hasNext()) {
	    		Entity element = evIterator.next();
	    		element.update();
	    	}
	    	next_game_tick += SKIP_TICKS;
	    	sleep_time = next_game_tick - elapsedTime();
	    	if (sleep_time >= 0) {
	            try {
					Thread.sleep( sleep_time );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
	}
	
    public static long startTime() {
    	return startTime;
    }
    
    public static long currentTime() {
    	return System.currentTimeMillis();
    }
    
    public static long elapsedTime() {
    	return System.currentTimeMillis() - startTime;
    }
    
	public static String getAgeFormattedStrings() {
		int[] ints = getAgeFormatted();
		return "This game is: "+ints[0]+" seconds, "+ints[1]+" minutes, "+ints[2]+" hours, "+ints[3]+" days, and "+ints[4]+" years old.";
	}
	
	public static int[] getAgeFormatted() {
		int x = (int) elapsedTime();
		int seconds = x % 60;
		x /= 60;
		int minutes = x % 60;
		x /= 60;
		int hours = x % 24;
		x /= 24;
		int days = x % 365;
		x /= 365;
		int years = x;
		int[] ageFormatted = { seconds, minutes, hours, days, years };
		return ageFormatted;
	}
	
}
