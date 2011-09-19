package tenacity.Core;

import java.io.IOException;
import java.util.Vector;

import tenacity.Entity.*;
import tenacity.Entity.Mind.Data.*;
import tenacity.Places.*;


public class World {
	public static PlayerServer player;
	public static StartPlace startPlace;
	public static Place defaultPlace;
	public static DynamicBeing useEnt;
	public static DynamicBeing obsEnt;
	
	public static void setupWorld() throws IOException, CloneNotSupportedException {
		startPlace = new StartPlace();
		defaultPlace = startPlace;
		useEnt = new DynamicBeing("ActionEnt");
		obsEnt = new DynamicBeing("ObservedEnt");
		
		System.out.println(obsEnt.getDataByType("being"));
		/*Data cloneData = obsEnt.getDataByType("appearance").clone();
		System.out.println(cloneData);
		Vector<Data> v = cloneData.children;
		for (int i = 0; i < v.size(); i++) {
            Object element = v.elementAt(i);
            System.out.println("   " + i + " (" +
                element.getClass().getName() + "): " +
                element);
        }
        System.out.println();*/
		//Too damn complicated for now, ignoring
		
		System.out.println(obsEnt.getDataByType("being").getChildrenByType("appearance"));
		/*v = obsEnt.getDataByType("appearance").children;
		for (int i = 0; i < v.size(); i++) {
            Object element = v.elementAt(i);
            System.out.println("   " + i + " (" +
                element.getClass().getName() + "): " +
                element);
        }
        System.out.println();*/
		
		obsEnt.getDataByType("appearance").getChildrenByType("skin").addDataChild(new Color("white"));
		useEnt.performAction("observeskin", obsEnt);
		System.out.println(obsEnt.getDataVector());
		useEnt.getMind().printDataArraysHash();
	}
}
