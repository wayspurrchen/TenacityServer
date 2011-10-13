package tenacity.Entity.Mind;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Hashtable;

import tenacity.Entity.Mind.Data.Data;


public class Mind {
	Traits traits = new Traits();
	Needs needs = new Needs();
	Thoughtspace thoughtspace = new Thoughtspace();
	
	Data lastData;
	
	Hashtable<String, Vector<Data>> dataArraysHash = new Hashtable<String, Vector<Data>>();
	
	public Mind() {
		
	}
	
	public void update() {
		
	}
	
	public Traits traits() {
		return traits;
	}
	
	public Needs needs() {
		return needs;
	}
	
	public Thoughtspace thoughtspace() {
		return thoughtspace;
	}
	
	public Hashtable<String, Vector<Data>> getDataArraysHash() {
		return dataArraysHash;
	}
	
	public void printDataArraysHash() {
		Enumeration<String> e = dataArraysHash.keys();
		Collection<Vector<Data>> c = dataArraysHash.values(); 
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		System.out.println(c);
	}
	
	public void enterData(Data data) {
		String type = data.type();
		if (dataCategoryExists(type)) {
			if (!dataExists(data)) {
				dataArraysHash.get(type).add(data);
			} else {
				System.out.println("Data object already exists");
			}
		} else {
			dataArraysHash.put(type, new Vector<Data>());
			dataArraysHash.get(type).add(data);
		}
	}
	
	public boolean dataCategoryExists(String type) {
		if (dataArraysHash.containsKey(type)) return true;
		return false;
	}
	
	public boolean dataExists(Data data) {
		for (int i=0;i<dataArraysHash.size();i++) {
			if (dataArraysHash.get(i).contains(data)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean dataExists(Data data, String type) {
		if (dataArraysHash.get(type).contains(data)) {
			return true;
		}
		return false;
	}
	
	
}
