package tenacity.Combat;

import java.util.Hashtable;
import java.util.Vector;

public class Attacks {
	Vector<String> attacks = new Vector<String>();
	Hashtable<String, Attack> attacksHash = new Hashtable<String, Attack>();
	
	public Attacks() {
		attacks.add("jab");
		attacksHash.put("jab", new AttackJab());
	}
}
