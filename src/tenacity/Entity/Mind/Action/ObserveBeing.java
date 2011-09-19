package tenacity.Entity.Mind.Action;

import tenacity.Entity.*;
import tenacity.Entity.Mind.Data.Data;

public class ObserveBeing extends Action {
	
	public ObserveBeing(DynamicBeing actor, Entity target) {
		super(actor, target);
		execute();
	}

	void execute() {
		Data data = target.getDataByType("being");
		actor.getMind().enterData(data);
		System.out.println(actor + " (" + actor.getName() + ") observed being of " + target
				+ " (" + target.getName() + "), " + actor + " has added data entry" + data);
	}
	
}
