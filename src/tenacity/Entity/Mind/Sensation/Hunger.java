package tenacity.Entity.Mind.Sensation;

import tenacity.Entity.Mind.Thoughtspace;
import tenacity.Entity.Mind.Desire.Eat;

public class Hunger extends Sensation {
	
	Hunger(Thoughtspace thoughtspace) {
		super(thoughtspace);
		type = "hunger";
	}

	@Override
	public void bubble() {
		thoughtspace.getAgency().getDesires().add(new Eat());
		thoughtspace.getAgency().getSensations().add(this);
	}
	
}
