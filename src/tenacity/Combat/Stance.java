package tenacity.Combat;

public abstract class Stance {
	private String stanceName;
	private String stanceDescShort;
	private String stanceDescLong;
	
	/*
	 * 
	 * States:
	 * A stance's state determines specific bonuses/negations conferred by those states.
	 * The main states are:
	 * - relaxed
	 * - tensed
	 * - prepared
	 * "Relaxed" conveys no bonus to defending attacks and applies a penalty to initiating attacks suddenly.
	 * "Tensed" conveys a small bonus in defending attacks and does not affect initiated attacks.
	 * "Prepared" conveys a larger bonus to defending attacks and provides a small bonus to attacks.
	 * 
	 * When attacking or attacked, a character is automatically taken out of the "relaxed" state and
	 * put into a "prepared" state.
	 * 
	 */
	
	/*
	 * All the following variables assume that "forward" is in the direction of the character's initial
	 * orientation to face the opponent. However, if a character's opponent is facing away but has an
	 * extended arm /backwards/, it would be reachable by the character because it extends backwards
	 * towards the character.
	 */
	
	private String headPosition; // forward, left, right, up, down
	private String posture; // straight, slouch, hunched, bowed
	private String torsoOrientation; // straight, left, right	
	
	private String leftLegPosition; // neutral, forward, backward, to side
	private String leftLegFacing; // in, out, forward
	private boolean leftLegBent;
	private boolean leftFootBent;
	private int leftLegWeightage;
	
	private String rightLegPosition; // neutral, forward, backward, to side
	private String rightLegFacing; // in, out, forward
	private boolean rightLegBent;
	private boolean rightFootBent;
	private int rightLegWeightage;
	
	private String leftArmPosition; //forward, backward, side, down, or up
	private boolean leftArmBent;
	private String leftHandShape; // relaxed, open, closed, fist, claw, knifehand, palmstrike
	
	private String rightArmPosition; //forward, backward, side, down, or up
	private boolean rightArmBent;
	private String rightHandShape; // relaxed, open, closed, fist, claw, knifehand, palmstrike
	
	public String getHeadPosition() {
		return headPosition;
	}
	
	public String getPosture() {
		return posture;
	}
	
	public String getTorsoOrientation() {
		return torsoOrientation;
	}
	
	public String getStanceName() {
		return stanceName;
	}
	
	public String getStanceDesc(Boolean longdesc) {
		if (longdesc) return stanceDescLong;
		else return stanceDescShort;
	}
	
	public String getLegPosition(String side) throws Exception {
		if (side=="left") return leftLegPosition;
		else if (side=="right") return rightLegPosition;
		else throw new Exception("invalid entry");
	}
	
	public String getLegFacing(String side) throws Exception {
		if (side=="left") return leftLegFacing;
		else if (side=="right") return rightLegFacing;
		else throw new Exception("invalid entry");
	}
	
	public int getLegWeightage(String side) throws Exception {
		if (side=="left") return leftLegWeightage;
		else if (side=="right") return rightLegWeightage;
		else throw new Exception("invalid entry");
	}
	
	public Boolean isLegBent(String side) throws Exception {
		if (side=="left") return leftLegBent;
		else if (side=="right") return rightLegBent;
		else throw new Exception("invalid entry");
	}
	
	public Boolean isFootBent(String side) throws Exception {
		if (side=="left") return leftFootBent;
		else if (side=="right") return rightFootBent;
		else throw new Exception("invalid entry");
	}
	
	public String getArmPosition(String side) throws Exception {
		if (side=="left") return leftArmPosition;
		else if (side=="right") return rightArmPosition;
		else throw new Exception("invalid entry");
	}
	
	public Boolean isArmBent(String side) throws Exception {
		if (side=="left") return leftArmBent;
		else if (side=="right") return rightArmBent;
		else throw new Exception("invalid entry");
	}
	
	public String getHandShape(String side) throws Exception {
		if (side=="left") return leftHandShape;
		else if (side=="right") return rightHandShape;
		else throw new Exception("invalid entry");
	}
}
