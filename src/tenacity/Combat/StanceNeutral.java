package tenacity.Combat;

public class StanceNeutral extends Stance {
	String stanceName = "Neutral";
	String stanceDescShort = "You are standing at a neutral posture.";
	String stanceDescLong = "You are standing at a neutral posture. There's not much else to say about this.";
	
	/*
	 * All the following variables assume that "forward" is in the direction of the character's initial
	 * orientation to face the opponent. However, if a character's opponent is facing away but has an
	 * extended arm /backwards/, it would be reachable by the character because it extends backwards
	 * towards the character.
	 */
	String headPosition = "forward"; // forward, left, right, up, down
	String posture = "straight"; // straight, slouch, hunched, bowed
	String torsoOrientation = "straight"; // straight, left, right	
	
	String leftLegPosition = "neutral"; // neutral, forward, backward, to side
	String leftLegFacing = "forward"; // in, out, forward
	boolean leftLegBent = false;
	boolean leftFootBent = true;
	int leftLegWeightage = 50;
	
	String rightLegPosition = "neutral"; // neutral, forward, backward, to side
	String rightLegFacing = "forward"; // in, out, forward
	boolean rightLegBent = false;
	boolean rightFootBent = true;
	int rightLegWeightage = 50;
	
	String leftArmPosition = "down"; //forward, backward, side, down, or up
	boolean leftArmBent = false;
	String leftHandShape = "relaxed"; // relaxed, open, closed, fist, claw, kniefhand, palmstrike
	
	String rightArmPosition = "down"; //forward, backward, side, down, or up
	boolean rightArmBent = false;
	String rightHandShape = "relaxed"; // relaxed, open, closed, fist, claw, kniefhand, palmstrike
	

	
	
	
}
