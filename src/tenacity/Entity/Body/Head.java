package tenacity.Entity.Body;

public class Head extends BodyPart {
	Head() {
		super();
		partName = "head";
		side = 'c';
		guardable = true;
		guarded = false;
		baseHealth = 100;
		baseResistance = 10;
	}
}
