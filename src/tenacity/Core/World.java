package tenacity.Core;

import java.io.IOException;

import tenacity.Entity.*;
import tenacity.Entity.Mind.Data.*;
import tenacity.Places.*;
import tenacity.Lexicon.Expressions.*;


public class World {
	public static StartPlace startPlace;
	public static Place defaultPlace;
	public static DynamicBeing useEnt;
	public static DynamicBeing obsEnt;
    public static Player playerServer;
	
    //Returns true if the world is set up without any errors
	public static boolean setupWorld() throws IOException, CloneNotSupportedException {
		startPlace = new StartPlace();
		defaultPlace = startPlace;
		useEnt = new DynamicBeing("ActionEnt");
		obsEnt = new DynamicBeing("ObservedEnt");
		
		Expression expr = new SimpleDeclarativeStatement();
		System.out.println(expr.getExpressedString());
		// Pretty sure this is not a proper way of handling errors; will fix later - 10/12/11
		return true;
	}
}
