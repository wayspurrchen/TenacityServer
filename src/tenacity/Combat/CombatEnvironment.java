package tenacity.Combat;

import java.util.Vector;
import tenacity.Entity.Being;

public class CombatEnvironment {
	Vector<Being> combatants = new Vector<Being>();
	Vector<Integer> combatMotions = new Vector<Integer>();
	//Vector combatActions = new Vector(); // figure this out
	
	CombatEnvironment(Being initiator, Being target) {
		combatants.add(initiator);
		combatants.add(target);
	}
}
