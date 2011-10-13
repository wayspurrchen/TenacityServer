package tenacity.Entity.Mind.Sensation;

import tenacity.Entity.Mind.Thoughtspace;
import tenacity.Entity.Mind.Desire.Eat;

public abstract class Sensation implements SensationInterface {
	
	protected String type;
	protected int strength;  // Variable strength of a Sensation, max 5000
	protected int threshold; // The amount of strength a Sensation must be before bubbling up to conscious awareness
	protected Thoughtspace thoughtspace;
	
	public static String[] sensations = { "hunger" };
	
	Sensation(Thoughtspace thoughtspace) {
		this.thoughtspace = thoughtspace;
	}
	
	public boolean bubbleReady() {
		if (strength>threshold) return true;
		else return false;
	}
	
}
