package tenacity.Entity.Mind.Data;

import java.util.Vector;

import tenacity.Entity.Entity;

public class DataSystem {
	Entity parent;
	Vector<Data> dataVector = new Vector<Data>();
	
	public DataSystem(Entity ent) {
		parent = ent;
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
}
