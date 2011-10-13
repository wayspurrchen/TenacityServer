package tenacity.Lexicon.Expressions;

import tenacity.Lexicon.Concepts.Concept;

public class Expression {
	Concept[] conceptFeed;
	
	public String getExpressedString() {
		String expressedString = "";
		for (int i=0;i<conceptFeed.length;i++) {
			expressedString += conceptFeed[i].getWord().getWordStringByIndex(0);
			if (i!=conceptFeed.length) expressedString += " ";
		}
		return expressedString;
	}
	
}
