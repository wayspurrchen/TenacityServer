package tenacity.Entity.Body;

public class LeftElbow extends BodyPart {
	LeftElbow() {
		super();
		partName = "leftelbow";
		side = 'l';
		guardable = false;
		baseHealth = 100;
		baseResistance = 30;
	}
}
