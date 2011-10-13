package tenacity.Entity.Mind.Action;

import tenacity.Entity.*;
import tenacity.Entity.Mind.Data.Data;

public class ObserveAppearance extends Action {
	
	public ObserveAppearance(DynamicBeing actor, Entity target) {
		super(actor, target);
		execute();
	}

	void execute() {
		Data data = target.getDataSystem().getDataByType("appearance");
		actor.getMind().enterData(data);
		System.out.println(actor + " (" + actor.getName() + ") observed appearance of " + target
				+ " (" + target.getName() + "), " + actor + " has added data entry" + data);
	}
	
}
