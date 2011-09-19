package tenacity.Places;

import java.util.Vector;
import tenacity.Entity.Entity;

public class Area {
	int level;
	String locationName;
	String shortDesc;
	String longDesc;
	Area parent; // If this place is inside another place, then this is its parent.
	Vector<Entity> entities = new Vector<Entity>(); // Objects held within the place
	/*NOTE TO SELF REGARDING ENTITIES:
	 * 
	 * When adding entities to the entities vector, make sure that the Entity itself
	 * accesses the chosen Place and adds itself, not any other weird way.
	 * 
	 * THOUGHTS:
	 * Different segments of "places" should be made within their own Place constructs/maps--
	 * i.e., instead of singular places for every location in the World's location array,
	 * make them have specific entry points (these would have to be manually hooked up or something,
	 * have to think about it) to entire Place segments that -then- break down into particular Areas.
	 * 
	 */
	boolean exitN = false;
	boolean exitW = false;
	boolean exitE = false;
	boolean exitS = false;
	boolean exitNW = false;
	boolean exitNE = false;
	boolean exitSW = false;
	boolean exitSE = false;
	boolean exitU = false;
	boolean exitD = false;
	
	Area areaN = null;
	Area areaE = null;
	Area areaW = null;
	Area areaS = null;
	Area areaNW = null;
	Area areaNE = null;
	Area areaSW = null;
	Area areaSE = null;
	Area areaU = null;
	Area areaD = null;
	
	public void createEntity() {
		
	}
	
	void setAdjacentAreaByIndex(int integer, Area connectingArea) {
		switch (integer) {
		case 1:
			areaN = connectingArea;
			break;
		case 2:
			areaE = connectingArea;
			break;
		case 3:
			areaW = connectingArea;
			break;
		case 4:
			areaS = connectingArea;
			break;
		case 5:
			areaNW = connectingArea;
			break;
		case 6:
			areaNE = connectingArea;
			break;
		case 7:
			areaSW = connectingArea;
			break;
		case 8:
			areaSE = connectingArea;
			break;
		case 9:
			areaU = connectingArea;
			break;
		case 10:
			areaD = connectingArea;
			break;
		default:
			break;
		}
	}
	
	Area getAreaByIndex(int integer) {
		switch (integer) {
		case 1:
			return areaN;
		case 2:
			return areaE;
		case 3:
			return areaW;
		case 4:
			return areaS;
		case 5:
			return areaNW;
		case 6:
			return areaNE;
		case 7:
			return areaSW;
		case 8:
			return areaSE;
		case 9:
			return areaU;
		case 10:
			return areaD;
		default:
			return null;
		}
	}
	
	boolean getExitBoolByIndex(int integer) {
		switch (integer) {
		case 1:
			return exitN;
		case 2:
			return exitE;
		case 3:
			return exitW;
		case 4:
			return exitS;
		case 5:
			return exitNW;
		case 6:
			return exitNE;
		case 7:
			return exitSW;
		case 8:
			return exitSE;
		case 9:
			return exitU;
		case 10:
			return exitD;
		default:
			return false;
		}
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public String getShortDesc() {
		return shortDesc;
	}
	
	public String getLongDesc() {
		return longDesc;
	}
	
	public String getEntityDescs() {
		if (entities.size()>0) {
			String tmp = "";
			for (int i=0;i<entities.size();i++) {
				tmp += entities.get(i).getDescPlace()+"\\_regular\\. ";
				System.out.println(tmp);
			}
			return tmp;
		} else return "Nothing of particular interest.";
	}
	
	public Vector<Entity> getEntities() {
		return entities;
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		if (entities.contains(entity)) entities.remove(entity);
	}
	
	public int getLevel() {
		return level;
	}
	
	public Area getAreaN() {
		return areaN;
	}
	
	public Area getAreaW() {
		return areaW;
	}
	
	public Area getAreaE() {
		return areaE;
	}
	
	public Area getAreaS() {
		return areaS;
	}
	
	public Area getAreaNW() {
		return areaNW;
	}
	
	public Area getAreaNE() {
		return areaNE;
	}
	
	public Area getAreaSW() {
		return areaSW;
	}
	
	public Area getAreaSE() {
		return areaSE;
	}
	
	public Area getAreaU() {
		return areaU;
	}
	
	public Area getAreaD() {
		return areaD;
	}
	
	public boolean exitExistsN() {
		return exitN;
	}
	
	public boolean exitExistsW() {
		return exitW;
	}
	
	public boolean exitExistsE() {
		return exitE;
	}
	
	public boolean exitExistsS() {
		return exitS;
	}
	
	public boolean exitExistsNW() {
		return exitNW;
	}
	
	public boolean exitExistsNE() {
		return exitNE;
	}
	
	public boolean exitExistsSW() {
		return exitSW;
	}
	
	public boolean exitExistsSE() {
		return exitSE;
	}
	
	public boolean exitExistsU() {
		return exitU;
	}
	
	public boolean exitExistsD() {
		return exitD;
	}
}
