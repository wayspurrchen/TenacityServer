package tenacity.Entity;

import java.util.Vector;

import tenacity.Core.Core;
import tenacity.Core.World;
import tenacity.Entity.Mind.Data.Color;
import tenacity.Entity.Mind.Data.Data;
import tenacity.GUI.GUI;
import tenacity.Places.Area;
import tenacity.Places.Place;

public abstract class Entity {
	private static Vector<Entity> entityVector = new Vector<Entity>();
	
	protected String className = "Entity"; // Basically the name of the class
	protected String name; // "informal" name for objects, most often used to refer to them through the entry field
	protected String formalName; // "formal" name, with a capital, used for referring to Beings. this will always be First + Last Name
	protected String descShort = "Short desc for abstract item class."; // This is a short description of an item while in an inventory.
	protected String descLong = "Still a blank, but longer description for abstract item class."; // This is a longer in-inventory description.
	protected String descPlace = "An abstract concept of an entity that shouldn't even be here."; // Defines a description of an object as it is located within a place/location

	public Vector<Data> dataVector = new Vector<Data>();
	
	int[] placeXYZ = { 0, 0, 0 };
	
	Place currentPlace;
	Area currentArea;
	
	//private long currentMotion = 0;
	//private long lastMotion = 0;
	private int baseAge = 10; // Age when entity was initiated
	private int totalAge; // Total age in years
	//private int totalAgeDays; // Total age in days
	private long baseAgeMot; // Age in motions when entity was initiated
	private long totalAgeMot; // Total age in motions

	private long totalAgeMill;
	private long baseAgeMill;

	protected Entity() {
		totalAge = baseAge;
		baseAgeMot = baseAge*365*24*60*60; //base age in motions, which are roughly equivalent to seconds
		totalAgeMot = baseAgeMot;
		currentPlace = World.defaultPlace;
		placeXYZ[0] = World.defaultPlace.getDefaultAreaXYZ()[0];
		placeXYZ[1] = World.defaultPlace.getDefaultAreaXYZ()[1];
		placeXYZ[2] = World.defaultPlace.getDefaultAreaXYZ()[2];
		currentArea = currentPlace.getAreaByCoords(placeXYZ[0], placeXYZ[1], placeXYZ[2]);
		currentArea.addEntity(this);
		getEntityVector().add(this);
	}
	
	protected Entity(String name) {
		this.name = name;
		totalAge = baseAge;
		baseAgeMot = baseAge*365*24*60*60; //base age in motions, which are roughly equivalent to seconds
		totalAgeMot = baseAgeMot;
		currentPlace = World.defaultPlace;
		placeXYZ[0] = World.defaultPlace.getDefaultAreaXYZ()[0];
		placeXYZ[1] = World.defaultPlace.getDefaultAreaXYZ()[1];
		placeXYZ[2] = World.defaultPlace.getDefaultAreaXYZ()[2];
		currentArea = currentPlace.getAreaByCoords(placeXYZ[0], placeXYZ[1], placeXYZ[2]);
		currentArea.addEntity(this);
		getEntityVector().add(this);
	}
	
	protected Entity(String name, Place place) {
		this.name = name;
		totalAge = baseAge;
		baseAgeMot = baseAge*365*24*60*60; //base age in motions, which are roughly equivalent to seconds
		totalAgeMot = baseAgeMot;
		currentPlace = place;
		placeXYZ[0] = currentPlace.getDefaultAreaXYZ()[0];
		placeXYZ[1] = currentPlace.getDefaultAreaXYZ()[1];
		placeXYZ[2] = currentPlace.getDefaultAreaXYZ()[2];
		currentArea = currentPlace.getAreaByCoords(placeXYZ[0], placeXYZ[1], placeXYZ[2]);
		currentArea.addEntity(this);
		getEntityVector().add(this);
	}
	
	protected Entity(String name, Place place, int x, int y, int z) {
		this.name = name;
		totalAge = baseAge;
		baseAgeMot = baseAge*365*24*60*60; //base age in motions, which are roughly equivalent to seconds
		totalAgeMot = baseAgeMot;
		currentPlace = place;
		placeXYZ[0] = x;
		placeXYZ[1] = y;
		placeXYZ[2] = z;
		currentArea = currentPlace.getAreaByCoords(x, y, z);
		currentArea.addEntity(this);
		getEntityVector().add(this);
	}
	
	public void update() {
		/*totalAgeMot += motionsAvailable;
		totalAge = (int) totalAgeMot/(365*24*60*60);*/
		//System.out.println(this+" updated");
		//System.out.println("totalAgeMill of "+this+": "+totalAgeMill);
		long add = Core.elapsedTime();
		totalAge = baseAge+(int) add/(365*24*60*60*1000);
		totalAgeMill = baseAgeMill+add;
		//System.out.println("totalAge of "+this+": "+totalAge);
	}
	
	//BEWARE--MOST LIKELY RESOURCE INTENSIVE
	//NEED TO FIX
	public Data searchDataByType(String string) {
		return new Color("green");
	}
	
	public Data getDataByType(String typeString) {
		return iterateData(typeString);
	}
	
	public void removeDataByType(String string) {
		dataVector.remove(iterateDataToIndex(string));
	}
	
	Data iterateData(String string) {
		boolean initialFound = false;
		Data foundData = null;
		for (int i = 0;i<dataVector.size();i++) {
			if (dataVector.get(i).type().equals(string)) {
				if (initialFound == false) {
					initialFound = true;
					foundData = dataVector.get(i);
				} else {
					System.out.println("Duplicate value found for data type "+string+" in "+this+"!");
					return null;
				}
			}
		}
		if (initialFound == true) return foundData;
		else return null;
	}
	
	int iterateDataToIndex(String string) {
		boolean initialFound = false;
		int foundDataIndex = -1;
		for (int i = 0;i<dataVector.size();i++) {
			if (dataVector.get(i).type().equals(string)) {
				if (initialFound == false) {
					initialFound = true;
					foundDataIndex = i;
				} else {
					System.out.println("Duplicate value found for data type "+string+" in "+this+"!");
					return -1;
				}
			}
		}
		if (initialFound == true) return foundDataIndex;
		else return -1;
	}
	
	public Vector<Data> getDataVector() {
		return dataVector;
	}
	
	public void addData(Data data) {
		if (data!=null) dataVector.add(data);
		else System.out.println("ERROR: DATA IS NULL");
	}
	
	public int getBaseAge() {
		return baseAge;
	}
	
	public long getBaseAgeMill() {
		return baseAgeMill;
	}
	
	public void setBaseAge(int age) {
		baseAge = age;
	}
	
	public int[] getAgeFormatted() { // Returns the age of an Entity in an int array in seconds, minutes, hours, days, and years
		int x = (int) totalAgeMot;
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
	
	public String getAgeFormattedStrings() {
		int[] ints = getAgeFormatted();
		return getName()+" is: "+ints[0]+" seconds, "+ints[1]+" minutes, "+ints[2]+" hours, "+ints[3]+" days, and "+ints[4]+" years old.";
	}
	
	public int getTotalAge() {
		return totalAge;
	}
	
	public long getTotalAgeMill() {
		return totalAgeMill;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String string) {
		name = string;
	}
	
	public String getFormalName() {
		return formalName;
	}
	
	public String getDescShort() {
		return descShort;
	}
	
	public String getDescLong() {
		return descLong;
	}
	
	public String getDescPlace() {
		return descPlace;
	}

	public static void setEntityVector(Vector<Entity> entityVector) {
		Entity.entityVector = entityVector;
	}

	public static Vector<Entity> getEntityVector() {
		return entityVector;
	}
	
	public Place getCurrentPlace() {
		return currentPlace;
	}
	
	public Area getCurrentArea() {
		return currentArea;
	}
	
	public Area getCurrentAreaViaIntDEP() {
		return currentPlace.getAreaMap()[placeXYZ[0]][placeXYZ[1]][placeXYZ[2]];
	}
	
	public int getPlaceX() {
		return placeXYZ[0];
	}
	
	public int getPlaceY() {
		return placeXYZ[1];
	}
	
	public int getPlaceZ() {
		return placeXYZ[2];
	}
	
	public void goDirection(String direction) {
		if (direction.equals("n") || direction.equals("north"))
			if (getCurrentArea().exitExistsN()) placeXYZ[1]--;
			else GUI.print("There is no exit to the north.",true);
		else if (direction.equals("s") || direction.equals("south"))
			if (getCurrentArea().exitExistsN()) placeXYZ[1]--;
			else GUI.print("There is no exit to the north.",true);
		else if (direction.equals("w") || direction.equals("west"))
			if (getCurrentArea().exitExistsW()) placeXYZ[0]--;
			else GUI.print("There is no exit to the west.",true);
		else if (direction.equals("e") || direction.equals("east"))
			if (getCurrentArea().exitExistsE()) placeXYZ[0]++;
			else GUI.print("There is no exit to the east.",true);
		else if (direction.equals("ne") || direction.equals("northeast"))
			if (getCurrentArea().exitExistsNE()) { placeXYZ[1]--; placeXYZ[0]++; }
			else GUI.print("There is no exit to the northeast.",true);
		else if (direction.equals("nw") || direction.equals("northwest"))
			if (getCurrentArea().exitExistsNW()) { placeXYZ[1]--; placeXYZ[0]--; }
			else GUI.print("There is no exit to the northwest.",true);
		else if (direction.equals("sw") || direction.equals("southwest"))
			if (getCurrentArea().exitExistsSW()) { placeXYZ[1]++; placeXYZ[0]++; }
			else GUI.print("There is no exit to the southwest.",true);
		else if (direction.equals("se") || direction.equals("southeast"))
			if (getCurrentArea().exitExistsSE()) { placeXYZ[1]++; placeXYZ[0]--; }
			else GUI.print("There is no exit to the southeast.",true);
		else if (direction.equals("u") || direction.equals("up"))
			if (getCurrentArea().exitExistsU()) { placeXYZ[2]++; }
			else GUI.print("There is no exit upwards.",true);
		else if (direction.equals("d") || direction.equals("down"))
			if (getCurrentArea().exitExistsD()) { placeXYZ[2]--; }
			else GUI.print("There is no exit downwards.",true);
		else System.out.println("Invalid direction specified!");
	}
		
	public void goNorth() {
			if (getCurrentArea().exitExistsN()) placeXYZ[1]--;
			else GUI.print("There is no exit to the north.",true);
	}
	
	public void goSouth() {
		if (getCurrentArea().exitExistsS()) placeXYZ[1]++;
		else GUI.print("There is no exit to the south.",true);
	}
	
	public void goWest() {
		if (getCurrentArea().exitExistsW()) placeXYZ[0]--;
		else GUI.print("There is no exit to the west.",true);
	}
	
	public void goEast() {
		if (getCurrentArea().exitExistsE()) placeXYZ[0]++;
		else GUI.print("There is no exit to the east.",true);
	}
	
	public void goNorthEast() {
		if (getCurrentArea().exitExistsNE()) { placeXYZ[1]--; placeXYZ[0]++; }
		else GUI.print("There is no exit to the northeast.",true);
	}
	
	public void goNorthWest() {
		if (getCurrentArea().exitExistsNW()) { placeXYZ[1]--; placeXYZ[0]--; }
		else GUI.print("There is no exit to the northwest.",true);
	}
	
	public void goSouthWest() {
		if (getCurrentArea().exitExistsSW()) { placeXYZ[1]++; placeXYZ[0]++; }
		else GUI.print("There is no exit to the southwest.",true);
	}
	
	public void goSouthEast() {
		if (getCurrentArea().exitExistsSE()) { placeXYZ[1]++; placeXYZ[0]--; }
		else GUI.print("There is no exit to the southeast.",true);
	}
	
	public void goUp() {
		if (getCurrentArea().exitExistsU()) { placeXYZ[2]++; }
		else GUI.print("There is no exit upwards.",true);
	}
	
	public void goDown() {
		if (getCurrentArea().exitExistsD()) { placeXYZ[2]--; }
		else GUI.print("There is no exit downwards.",true);
	}

}
