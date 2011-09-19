package tenacity.Entity.Mind.Action;

import tenacity.Entity.*;

public class Move extends Action {
	
	public Move(DynamicBeing actor, String direction) {
		super(actor, null);
		execute(direction);
	}

	void execute(String direction) {
		actor.goDirection(direction);
	}
	
}
