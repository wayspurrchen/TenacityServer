package tenacity.Items;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import tenacity.Entity.Entity;

abstract public class Item extends Entity {
	int itemID;
	protected String itemType;
	
	static Hashtable<Integer, Item> itemHash = new Hashtable<Integer, Item>();
	
	protected Item() {
		super();
		double rand = Math.random();
		int x;
		do {
		x = (int) ((10000 * rand) + 1);
		} while (itemHash.containsKey(x));
		///System.out.println("Item ID assign attempt: "+x);
		///System.out.println("ID already assigned: "+itemMap.containsKey(x));
		if (itemHash.containsKey(Integer.valueOf(x))==false) {
			itemID = x;
			itemHash.put(x, this);
			System.out.println("\""+getName()+"\" created. Data:\nItem Map: "+x+" :: "+itemHash.get(x)
					+"\nItem Name: "+getName()+"("+itemID+")");
		}
	}
	
	public int itemID() {
		return itemID;
	}
	
	public String uniqueID() {
		return getName() + itemID();
	}
	
	static public void getItemList() {
		Collection<Item> c = itemHash.values();
		Iterator<Item> itr = c.iterator();
		while (itr.hasNext()) {
			Item tmp = (Item) itr.next();
			System.out.println(tmp.uniqueID());
		}
		System.out.println("set printed");
	}
}
