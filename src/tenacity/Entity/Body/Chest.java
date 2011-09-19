package tenacity.Entity.Body;

public class Chest extends BodyPart {
	Chest() {
		super();
		partName = "chest";
		side = 'c';
		guardable = true;
		guarded = false;
		baseHealth = 100;
		baseResistance = 15;
	}
}
