package tenacity.Entity.Body;

import java.util.Hashtable;

import tenacity.Combat.Attacks;
import tenacity.Combat.Stance;
import tenacity.Combat.StanceNeutral;

public class HumanoidBody extends Body {
	
	int health = 100;
	int momentum;
	int leftLegStrength = 0;
	int rightLegStrength = 0;
	int leftArmStrength = 0;
	int rightArmStrength = 0;
	Stance stance = new StanceNeutral();
	Attacks attacks = new Attacks();

	public Hashtable<String, BodyPart> bodyParts = new Hashtable<String, BodyPart>();
	
	public HumanoidBody() {
		bodyParts.put("head", new Head());
		bodyParts.put("neck", new Neck());
		bodyParts.put("chest", new Chest());
		bodyParts.put("abdomen", new Abdomen());
		bodyParts.put("groin", new Groin());
		bodyParts.put("leftthigh", new LeftThigh());
		bodyParts.put("leftshin", new LeftShin());
		bodyParts.put("leftcalf", new LeftCalf());
		bodyParts.put("leftankle", new LeftAnkle());
		bodyParts.put("leftfoot", new LeftFoot());
		bodyParts.put("rightthigh", new RightThigh());
		bodyParts.put("rightshin", new RightShin());
		bodyParts.put("rightcalf", new RightCalf());
		bodyParts.put("rightankle", new RightAnkle());
		bodyParts.put("rightfoot", new RightFoot());
		bodyParts.put("leftarm", new LeftArm());
		bodyParts.put("leftforearm", new LeftForearm());
		bodyParts.put("leftelbow", new LeftElbow());
		bodyParts.put("leftwrist", new LeftWrist());
		bodyParts.put("lefthand", new LeftHand());
		bodyParts.put("leftfingers", new LeftFingers());
		bodyParts.put("leftthumb", new LeftThumb());
		bodyParts.put("rightarm", new RightArm());
		bodyParts.put("rightforearm", new RightForearm());
		bodyParts.put("rightelbow", new RightElbow());
		bodyParts.put("rightwrist", new RightWrist());
		bodyParts.put("righthand", new RightHand());
		bodyParts.put("rightfingers", new RightFingers());
		bodyParts.put("rightthumb", new RightThumb());
		
	}
	
	  // returns an int array with health and resistance
	public int[] getBodyPartValues(String part) {
		if (isValidPartString(part)) {
				int[] values = { getPartByString(part).getHealth(), getPartByString(part).getResistance() };
				return values;
		}
		else return null;
	}
	
	public int getResistance(String part) {
		return getPartByString(part).getResistance();
	}
	
	public int getHealth(String part) {
		return getPartByString(part).getHealth();
	}
	
	public boolean isValidPartString(String part) {
		if (bodyParts.containsKey(part)) {
			return true;
		} else return false;
	}
	
	public BodyPart getPartByString(String part) {
		return bodyParts.get(part);
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMomentum() {
		return momentum;
	}
	
	public Stance getStance() {
		return stance;
	}
	
	public Attacks getAttacks() {
		return attacks;
	}
	// This takes leftarm, leftleg, rightarm, and rightleg, though these aren't -actually-
	// body parts but conceptual strengths of entire limbs/appendages.
	public int getPartStrength(String str) { 
		if (str.equals("leftarm")) return leftArmStrength;
		else if (str.equals("rightarm")) return rightArmStrength;
		else if (str.equals("leftleg")) return leftLegStrength;
		else if (str.equals("rightleg")) return rightLegStrength;
		else return 0;
	}

}
