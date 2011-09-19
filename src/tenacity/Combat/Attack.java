package tenacity.Combat;

public abstract class Attack {
	String attackName;  // Name of the attack
	int motionTotal;    // Total number of motions the attack uses
	int motionAttack;   // The number of motions used during attack
	int motionRecover;  // Number of motions used during recovery
	int momentum;       // Momentum of attack
	float baseDamage;     // Base damage of attack (modified by other variables)
	float skill = 1;      // Skill of attack (will change in Attacks, starts at 1 always)
	String partUsed;    // Part of body used (arm or leg)
	
	String optimHeight;
	String optimReach;
	String maxReach;
	
	public String getAttackName() {
		return attackName;
	}
	
	public String getPartUsed() {
		return partUsed;
	}
	
	public int getMotionTotal() {
		return motionTotal;
	}

	public int getMotionAttack() {
		return motionAttack;
	}
	
	public int getMotionRecover() {
		return motionRecover;
	}
	
	public int getMomentum() {
		return momentum;
	}
	
	public float getBaseDamage() {
		return baseDamage;
	}
	
	public float getSkill() {
		return skill;
	}
	
	public String getOptimHeight() {
		return optimHeight;
	}
}
