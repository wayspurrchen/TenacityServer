package tenacity.Entity.Body;

public class LeftHand extends BodyPart {
	LeftHand() {
		super();
		partName = "lefthand";
		side = 'l';
		guardable = false;
		baseHealth = 100;
		baseResistance = 6;
	}
}
