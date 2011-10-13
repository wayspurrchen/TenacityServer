package tenacity.Entity.Mind;

import java.util.Vector;

import tenacity.Entity.Mind.Sensation.Sensation;

public class Thoughtspace {
	
	Agency agency = new Agency();
	
	Vector<Sensation> sensationVector = new Vector<Sensation>();
	
	public void update() {
		for (int i=0;i<sensationVector.size();i++) {
			Sensation tmpSensation = sensationVector.get(i);
			if (tmpSensation.bubbleReady()) {
				tmpSensation.bubble();
			}
		}
	}
	
	public Agency getAgency() {
		return agency;
	}
	
}
