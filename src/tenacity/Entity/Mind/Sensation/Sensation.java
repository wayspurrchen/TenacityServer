package tenacity.Entity.Mind.Sensation;

public abstract class Sensation {
	
	protected String type;
	protected int strength;  // Variable strength of a Sensation, max 5000
	protected int threshold; // The amount of strength a Sensation must be before bubbling up to conscious awareness
	
	public static String[] sensations = { "hunger" };
	
}
