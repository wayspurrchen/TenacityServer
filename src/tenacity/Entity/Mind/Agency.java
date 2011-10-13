package tenacity.Entity.Mind;

import java.util.ArrayList;
import java.util.Vector;

import tenacity.Entity.Mind.Desire.Desire;
import tenacity.Entity.Mind.Sensation.Sensation;

public class Agency {
	
	ArrayList<Desire> desires;
	Vector<Sensation> sensations;
	
	public ArrayList<Desire> getDesires() {
		return desires;
	}
	
	public Vector<Sensation> getSensations() {
		return sensations;
	}

}
