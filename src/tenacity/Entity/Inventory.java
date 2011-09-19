package tenacity.Entity;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;

import tenacity.GUI.GUI;
import tenacity.Items.*;

public class Inventory {
		
	int maxCapacity = 50; // 50 items, no weight
	Vector<Item> bag = new Vector<Item>(50);
	String[] slots = { "head", "neck", "rightwrist", "leftwrist", "rightarmaccessory", "leftarmaccessory", "chest", "belt", "legs",
			"leftlegaccessory", "rightlegaccessory", "feet", "righthand", "lefthand"};
	
	/*Item invHead;
	Item invNeck;
	Item invRightWrist;
	Item invLeftWrist;
	Item invRightArmAccessory;
	Item invLeftArmAccessory;
	Item invChest;
	Item invBelt;
	Item invLegs;
	Item invLeftLegAccessory;
	Item invRightLegAccessory;
	Item invFeet;
	Item invRightHand;
	Item invLeftHand;*/
	
	Hashtable<String, Item> invMap = new Hashtable<String,Item>();
	
	public Inventory() {
	}
	
	String getInvSlotName(String str) {
		if (invMap.get(str)!=null) {
			return invMap.get(str).getName();
		}
		else return "None";
	}
	
	public Item getInvSlot(String str) {
		return invMap.get(str);
	}
	
	void setInv(String str, Item item) {
		if(item!=null) invMap.put(str, item);
		else invMap.remove(str);
	}
	
	public void showGear() {
		GUI.printColoredVariable("info","Head: ",getInvSlotName("head"));
		GUI.printColoredVariable("info","Neck: ",getInvSlotName("neck"));
		GUI.printColoredVariable("info","Left Hand: ",getInvSlotName("lefthand"), false);
		GUI.printColoredVariable("info"," | Right Hand: ",getInvSlotName("righthand"));
		GUI.printColoredVariable("info","Left Wrist: ",getInvSlotName("leftwrist"), false);
		GUI.printColoredVariable("info"," | Right Wrist: ",getInvSlotName("rightwrist"));
		GUI.printColoredVariable("info","Left Arm Accessory: ",getInvSlotName("leftarmaccessory"), false);
		GUI.printColoredVariable("info"," | Right Arm Accessory: ",getInvSlotName("rightarmaccessory"));
		GUI.printColoredVariable("info","Chest: ",getInvSlotName("chest"));
		GUI.printColoredVariable("info","Belt: ",getInvSlotName("belt"));
		GUI.printColoredVariable("info","Legs: ",getInvSlotName("legs"));
		GUI.printColoredVariable("info","Left Leg Accessory: ",getInvSlotName("leftlegaccessory"), false);
		GUI.printColoredVariable("info"," | Right Leg Accessory: ",getInvSlotName("rightlegaccessory"));
		GUI.printColoredVariable("info","Feet: ",getInvSlotName("feet"));
	}
	
	public void showInventory() {
		GUI.printColor("info","Inventory:\n");
		for (int i=0;i<bag.size();i++) {
			if (bag.get(i)!=null) GUI.print(bag.get(i).getName()+"\n");
		}
	}
	
	public void equip(String item, String slot){
		boolean success = false;
		String itemName = "null";
		System.out.println(Arrays.asList(slots));
		if (Arrays.asList(slots).contains(slot)) {// Check whether or not the requested slot actually exists
			for (int i=0; i<bag.size(); i++) { // Runs through all items in bag to find selected item
				System.out.println("Trying slot "+i+": "+bag.get(i));
				if (bag.get(i)!=null && item.equals(bag.get(i).getName())) { // If the item in bag is NOT null and the item is equal to the item we want
					itemName=bag.get(i).getName();
					setInv(slot,bag.get(i));
					bag.remove(i);
					success = true;
					break;
				}
			}
			if (success) {
				GUI.print(itemName.toString()+" successfully equipped in/on "+slot.toString()+"\n");
			} else {
				GUI.println("No such item.");
			}
		} else GUI.println("No such slot.");
	}
	
	public void unequip(String slot) {
		System.out.println(Arrays.asList(slots));
		if (Arrays.asList(slots).contains(slot)) {
			if(invMap.get(slot)!=null) {
				Item itemType = invMap.get(slot);
				setInv(slot,null);
				bag.add(itemType);
			} else GUI.println("Nothing to unequip there.");
		} else GUI.println("No such slot.");
	}
	
	
	
}