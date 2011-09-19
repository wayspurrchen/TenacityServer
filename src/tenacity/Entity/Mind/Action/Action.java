package tenacity.Entity.Mind.Action;

import tenacity.Entity.*;

public abstract class Action {
	static String[] actionList = { "observeskincolor", "observeappearance" };
	
	int time = 0;
	DynamicBeing actor;
	Entity target;
	
	Action(DynamicBeing parent, Entity target) {
		this.actor = parent;
		this.target = target;
	}
	
	static public String[] getActionList() {
		return actionList;
	}
	
	static public void createAction(String action, DynamicBeing actor, Entity target) {
		if (action.equals("observeskin")) {
			new ObserveSkin(actor,target);
		} else if (action.equals("observeappearance")) {
			new ObserveAppearance(actor,target);
		} else {
			System.out.println(action+" is not a valid action string");
		}
	}
}