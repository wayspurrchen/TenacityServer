package tenacity.Entity.Mind.Data;

public class Being extends Data {
	tenacity.Entity.Being being;
	
	public Being(tenacity.Entity.Being being) {
		type = "being";
		this.being = being;
	}
}
