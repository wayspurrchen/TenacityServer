package tenacity.Entity;

import tenacity.Entity.Body.Body;
import tenacity.Entity.Mind.Data.*;
import tenacity.Places.Place;

public abstract class Being extends Entity {
	String firstName;
	String lastName;
	
	Inventory inventory = new Inventory();
	Body body = new Body();
	
	public Being() {
		super();
		init();
	}
	
	public Being(String name) {
		super(name);
		init();
	}
	
	public Being(String name, Place place) {
		super(name, place);
		init();
	}
	
	public Being(String name, Place place, int x, int y, int z) {
		super(name, place, x, y, z);
		init();
	}
	
	public void init() {
		className = "Being";
		descShort = "A being";
		descPlace = "A dynamic-looking being that shouldn't be here";
		addData(new tenacity.Entity.Mind.Data.Being(this));
		getDataByType("being").addDataChild(new Appearance());
		getDataByType("being").getChildrenByType("appearance").addDataChild(new Skin());
	}
	
	public Inventory getInv() {
		return inventory;
	}
	
	public Body body() {
		return body;
	}
	
	
}
