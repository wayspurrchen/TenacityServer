package tenacity.Entity.Body;

public class Abdomen extends BodyPart {
	Abdomen() {
		super();
		partName = "abdomen";
		side = 'c';
		guardable = true;
		guarded = false;
		baseHealth = 100;
		baseResistance = 10;
	}
}
