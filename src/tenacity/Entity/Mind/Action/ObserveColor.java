package tenacity.Entity.Mind.Action;

import tenacity.Entity.*;
import tenacity.Entity.Mind.Data.Data;

public class ObserveColor extends Action {
	
	public ObserveColor(DynamicBeing actor, Entity target) {
		super(actor, target);
		execute();
	}

	void execute() {
		Data data = target.getDataSystem().getDataByType("color");
		actor.getMind().enterData(data);
		System.out.println(actor + " (" + actor.getName() + ") observed color of " + target
				+ " (" + target.getName() + "), " + actor + " has added data entry" + data);
	}
	
	void execute(String parentData) {
		Data data = target.getDataSystem().getDataByType(parentData).getChildrenByType("color");
		actor.getMind().enterData(data);
		System.out.println(actor + " (" + actor.getName() + ") observed color of " + target
				+ " (" + target.getName() + "), " + actor + " has added data entry" + data);
	}
	
}
