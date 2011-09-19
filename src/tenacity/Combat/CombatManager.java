package tenacity.Combat;

import tenacity.Entity.*;
import tenacity.Entity.Body.*;


public class CombatManager {
	Being attacker;			// The attacker initiating attack
	Being attackee;			// Enemy being attacked
	Attack attack;				// Attack being used
	BodyPart attackerPart;		// BodyPart attacker uses to attack
	BodyPart attackeePart;		// BodyPart attacker is attacking
	String attackerLimb;   		// Arm or leg
	Attacks attackerAttacks;	// Attacks object of Attacker
	char attackerSide; // left (l), right (r), center (c)  |  These are used to get crossings as well as correspond to 
	char attackeeSide; // left (l), right (r), center (c)  |  body part strengths in the base damage calculations.
	char crossing; // opposite (o), same (s), centered (c)
	
	public CombatManager(Being attacker, Being attackee, String attack, String attackerPart, String attackeePart) { //This should be called to get the damage of an attack
		System.out.println("Combat manager running");
		
		this.attacker = attacker;
		System.out.println("Attacker: "+attacker.getName());
		this.attackee = attackee;
		System.out.println("Attackee: "+attackee.getName());
		this.attackerAttacks = attacker.body().getAttacks();
		
		if (this.attacker.body().getAttacks().attacksHash.containsKey(attack)) {
				this.attack = attackerAttacks.attacksHash.get(attack);
				this.attackerLimb = this.attack.getPartUsed();
				System.out.println(this.attack+": working!");
				System.out.println(this.attack.getBaseDamage());
		} else System.out.println("Attacks no specified attack: "+attack);
		
		if (this.attacker.body().isValidPartString(attackerPart)) { // Properly assigns the part used to attack via string inputed
			this.attackerPart = this.attacker.body().getPartByString(attackerPart);
			System.out.println("Attacking Part: "+this.attackerPart+" "+this.attackerPart.getName());
			this.attackerSide = this.attackerPart.getSide();
			//else if (this.attackerPart.getName().startsWith("right")) this.attackeeSide = 'r';
			//else this.attackeeSide = 'c';
			System.out.println("Attacking Part Side: "+attackerSide);
		} else	System.out.println("Attacker part check failed"); 
		if (this.attackee.body().isValidPartString(attackeePart)) { // Properly assigns the part being attacked via string inputed
			this.attackeePart = this.attackee.body().getPartByString(attackeePart);
			System.out.println("Attacked Part: "+this.attackeePart);
			this.attackeeSide = this.attackeePart.getSide();
		}  else	System.out.println("Attackee part check failed");
		//this.crossing = getCrossing(); // Determines whether the target and the part used are on the same side, opposite, or the target is centered
		//System.out.println("Crossing: "+crossing);
	}
	
	char getCrossing() { // Relies on the .. "string-y-ness" of body parts to determine if it is left or right or center (headbutts mostly, maybe pelvic thrusts)
		if (attackeePart.getSide()!='l' && attackerPart.getSide()!='r') { //this needs to check strings for crossing; changing to chars messed it up but will still work with modifications
			attackerSide = 'c';
		} else if (attackerPart.getSide()=='l') {
			attackerSide = 'l';
		} else attackerSide = 'r';
		
		if (attackeePart.getSide()!='l' && attackeePart.getSide()!='r') {
			attackeeSide = 'c';
		} else if (attackeePart.getSide()=='l') {
			attackeeSide = 'l';
		} else attackeeSide = 'r';
		
		if (attackeeSide==attackerSide) return 's';
		else if (attackeePart.getSide()=='c') return 'c';
		else return 'o';
	}
	
	public float getBaseDMG() {
		float baseDMG;
		baseDMG = (attack.getBaseDamage()+(attacker.body().getStrength()+(attacker.body().getPartStrength(attackerPart.getName())))/2)*(attack.getSkill());
		baseDMG = attack.getBaseDamage(); // Get base damage of attack being used
		System.out.println("Base: "+baseDMG);
		String tmpSideLong = null;
		if (attackeePart.getSide()=='l') tmpSideLong = "left";			//This entire bit takes the shorthand chars for sides and lengthens
		else if (attackeePart.getSide()=='r') tmpSideLong = "right";	//them to full strings for Body to get the conceptual arm strengths
		String partForBody = tmpSideLong+attackerLimb;
		baseDMG += (attacker.body().getStrength()+attacker.body().getPartStrength(partForBody))/2;
		System.out.println("Strengths added: "+baseDMG);
		baseDMG = baseDMG*(attack.getSkill()/10);
		System.out.println(attack.getAttackName()+" skill: "+attack.getSkill());
		System.out.println("Skill incorporated: "+baseDMG);
		System.out.println("attack baseDamage: "+attack.getBaseDamage());
		System.out.println("attacker STR: "+attacker.body().getStrength());
		System.out.println("attacker partStrength: "+attacker.body().getPartStrength(partForBody));
		return baseDMG;
	}
	
	
	//Calculates damage by adding attack momentum to enemy's Body's momentum
	public float momentumCalc(float dmg) {
		float newDMG = dmg*((attack.getMomentum()+attackee.body().getMomentum())/attack.getMomentum());
		return newDMG;
	}
	
	//Calculates damage for guarded parts--should only be called after a positive isGuarded check
	//public float guardedCalc(float dmg) {
		
	//}
	
	
}
