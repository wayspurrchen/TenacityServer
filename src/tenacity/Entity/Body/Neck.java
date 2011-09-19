package tenacity.Entity.Body;

public class Neck extends BodyPart {
	Neck() {
		super();
		partName = "neck";
		side = 'c';
		guardable = true;
		guarded = false;
		baseHealth = 100;
		baseResistance = 5;
	}
}
