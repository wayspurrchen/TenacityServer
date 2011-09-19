package tenacity.Entity.Body;

public class Groin extends BodyPart {
	Groin() {
		super();
		partName = "groin";
		side = 'c';
		guardable = true;
		guarded = false;
		baseHealth = 100;
		baseResistance = 0;
	}
}
