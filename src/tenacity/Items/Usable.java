package tenacity.Items;

import tenacity.Items.Item;

public abstract class Usable extends Item {
	String usableType;
	
	protected Usable() {
		itemType = "usable";
	}
}
