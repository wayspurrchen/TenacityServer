package tenacity.Items;

public abstract class Quenchable extends Consumable {
	String quenchableType;
	
	protected Quenchable() {
		quenchableType = "thirst";
	}
}
