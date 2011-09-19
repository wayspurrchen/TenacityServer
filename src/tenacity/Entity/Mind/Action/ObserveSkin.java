package tenacity.Entity.Mind.Action;

import tenacity.Entity.*;
import tenacity.Entity.Mind.Data.Data;

public class ObserveSkin extends Action {
	
	public ObserveSkin(DynamicBeing actor, Entity target) {
		super(actor, target);
		execute();
	}

	void execute() {
		Data data = target.getDataByType("being").getChildrenByType("appearance").getChildrenByType("skin");
		actor.getMind().enterData(data);
		System.out.println(actor + " (" + actor.getName() + ") observed skin of " + target
				+ " (" + target.getName() + "), " + actor + " has added data entry" + data);
	}
	
}
