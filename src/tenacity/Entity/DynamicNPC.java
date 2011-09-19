package tenacity.Entity;

public class DynamicNPC extends DynamicBeing {
	
	public DynamicNPC(String name) {
		this.name = name;
		className = "DynamicNPC";
		descShort = "A being named \\_being\\"+getName();
		descPlace = "A being named \\_being\\"+getName();
	}
	
	
}
