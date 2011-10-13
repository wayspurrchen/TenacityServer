package tenacity.Lexicon.Words;

import tenacity.Lexicon.Concepts.Concept;

public abstract class Word {
	String[] words;
	Concept concept;
	
	public Concept getConcept() {
		return concept;
	}
	
	public String getWordStringRand() {
		return words[(int) (Math.random()*words.length)];
	}
	
	public String getWordStringFirst() {
		return words[0];
	}
	
	public String getWordStringByIndex(int i) {
		return words[i];
	}

}
