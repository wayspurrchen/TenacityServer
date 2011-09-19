package tenacity.Entity.Body;

public abstract class BodyPart {
	String partName;
	char side;
	boolean guardable;
	boolean guarded;
	BodyPart guarder;
	int baseHealth;
	int health;
	int baseResistance;
	int resistance;
	
	public BodyPart() {
		resistance = baseResistance;
		health = baseHealth;
	}
	
	public String getName() {
		return partName;
	}
	
	public BodyPart getGuarder() {
		return guarder;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getResistance() {
		return resistance;
	}
	
	public char getSide() {
		return side;
	}
	
	public boolean isGuardable() {
		return guardable;
	}
	
	public boolean isGuarded() {
		return guarded;
	}
	
	public void setHealth(int newhealth) {
		health = newhealth;
	}
	
	public void setResistance(int newres) {
		resistance = newres;
	}
}
