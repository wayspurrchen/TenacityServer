package tenacity.Entity.Mind.Judgment;

import tenacity.Entity.Entity;

public class JudgmentColor extends Judgment {
	
	String judge(Entity ent) {
		return ent.getDataByType("color").value();
	}
	
}
