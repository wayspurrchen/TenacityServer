package tenacity.Items;

public abstract class Consumable extends Usable {
	String consumableType;
	
	protected Consumable() {
		usableType = "consumable";
	}
}
