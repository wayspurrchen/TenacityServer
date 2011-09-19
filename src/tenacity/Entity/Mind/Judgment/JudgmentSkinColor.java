package tenacity.Entity.Mind.Judgment;

import tenacity.Entity.Entity;

public class JudgmentSkinColor extends Judgment {
	
	public static String judge(Entity ent) {
		return ent.getDataByType("appearance").getChildrenByType("skin").getChildrenByType("color").value();
	}
	
}
