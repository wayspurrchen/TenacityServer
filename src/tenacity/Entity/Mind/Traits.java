package tenacity.Entity.Mind;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

public class Traits {
	
	Hashtable<String, Float> traitTable = new Hashtable<String, Float>();		//	All the traits themselves, yay!
	Hashtable<String, Float> traitIncrements = new Hashtable<String, Float>(); 	//	External increments to traits for whatever reasons
	
	public Traits() {
		//Tier 1
		setTrait("communalism", new Float(0));			//
		setTrait("creativity", new Float(0));			//
		setTrait("emotionality", new Float(0));			//
		setTrait("extroversion", new Float(0));			//
		setTrait("individualism", new Float(0));		//
		setTrait("intellect", new Float(0));			//
		setTrait("openness", new Float(0));				//
		setTrait("physicality", new Float(0));			//
		setTrait("quickness", new Float(0));			//
		setTrait("tenacity", new Float(0));				//
		setTrait("wisdom", new Float(0));				//
		//Tier 2 starts here
		setTrait("agreeableness", new Float(0));		//
		setTrait("compassion", new Float(0));			//
		setTrait("neuroticism", new Float(0));			//
		setTrait("perception", new Float(0));			//
		setTrait("pride", new Float(0));				//
		setTrait("ruleconsciousness", new Float(0));	//
		setTrait("sociableness", new Float(0));			//
		setTrait("sensitivity", new Float(0));			//
		//Tier 3 starts here
		setTrait("aggressiveness", new Float(0));		//
		setTrait("awareness", new Float(0));			//
		setTrait("familial", new Float(0));				//
		setTrait("kindness", new Float(0));				//
		setTrait("patience", new Float(0));				//
		setTrait("spontaneity", new Float(0));			//
		
		//Tier 1
		setIncrement("communalism", new Float(0));
		setIncrement("creativity", new Float(0));
		setIncrement("emotionality", new Float(0));
		setIncrement("extroversion", new Float(0));
		setIncrement("individualism", new Float(0));
		setIncrement("intellect", new Float(0));
		setIncrement("openness", new Float(0));
		setIncrement("physicality", new Float(0));
		setIncrement("quickness", new Float(0));
		setIncrement("tenacity", new Float(0));
		setIncrement("wisdom", new Float(0));
		//Tier 2
		setIncrement("agreeableness", new Float(0));
		setIncrement("compassion", new Float(0));
		setIncrement("neuroticism", new Float(0));
		setIncrement("perception", new Float(0));
		setIncrement("pride", new Float(0));
		setIncrement("ruleconsciousness", new Float(0));
		setIncrement("sensitivity", new Float(0));
		setIncrement("sociableness", new Float(0));
		//Tier 3
		setIncrement("aggressiveness", new Float(0));
		setIncrement("awareness", new Float(0));
		setIncrement("familial", new Float(0));
		setIncrement("kindness", new Float(0));
		setIncrement("openness", new Float(0));
		setIncrement("patience", new Float(0));
		setIncrement("spontaneity", new Float(0));
		
		calculateAgreeableness();
		calculateCompassion();
		calculateNeuroticism();
		calculatePerception();
		calculatePride();
		calculateRuleConsciousness();
		calculateSensitivity();
		calculateSociableness();
		
		calculateAggressiveness();
		calculateAwareness();
		calculateFamilial();
		calculateKindness();
		calculatePatience();
		calculateSpontaneity();
		
		//getTraitStrings();
		
	}
	
	public void recalculateTraits() {
		calculateAgreeableness();
		calculateCompassion();
		calculateNeuroticism();
		calculatePerception();
		calculatePride();
		calculateRuleConsciousness();
		calculateSensitivity();
		calculateSociableness();
		
		calculateAggressiveness();
		calculateAwareness();
		calculateFamilial();
		calculateKindness();
		calculatePatience();
		calculateSpontaneity();
	}
	
	/*
	 * 
	 * MUST REWORK--GOING TO DEFINE TRAITS INSTEAD AS -2500 TO 2500
	 * FOR EASE OF CALCULATIONS
	 * 
	 */

	public float getTrait(String str) { // Returns trait via HashMap string
		return traitTable.get(str);
	}
	
	public void setTrait(String trait, float value) { // Returns trait via HashMap string
		if (value>5000) {
			traitTable.put(trait, (float) 5000);
		} else if (value<-5000) {
			traitTable.put(trait, (float) -5000);
		} else traitTable.put(trait, value);
	}
	
	public float getIncrement(String str) { // Returns trait via HashMap string
		return traitIncrements.get(str);
	}
	
	public void setIncrement(String trait, float value) { // Returns trait via HashMap string
		traitIncrements.put(trait, value);
	}
	
	public void getTraitStrings() {
		Enumeration<Float> e = traitTable.elements();
		Enumeration<String> ef = traitTable.keys();
		String[] strings = new String[traitTable.size()];
		int i=0;
		while (e.hasMoreElements())
	    {
			strings[i] = ef.nextElement() +": " +e.nextElement();
			System.out.println("strings["+i+"]: "+strings[i]);
			i++;
	    }
		Arrays.sort(strings);
		for (int j=0;j<strings.length;j++) {
			System.out.println(Character.toUpperCase(strings[j].charAt(0))+strings[j].substring(1));
		}
	}
	

	//TIER TWO CALCULATIONS
	
	//Here we need to divide by 4 to average out all of the positive values
	void calculateAgreeableness() {
		float newvalue = (float) ((getAffectingTrait("openness") + getAffectingTrait("communalism") +
				getAffectingTrait("extroversion"))/3 + getModifyingTrait("intellect") +
				getModifyingTrait("wisdom", true, 10)) + getIncrement("agreeableness");
		//System.out.println("====AGREEABLENESS CALCULATION====");
		//System.out.println("Openness: " + getAffectingTrait("openness"));
		//System.out.println("Communalism: " + getAffectingTrait("communalism"));
		//System.out.println("Extroversion: " + getAffectingTrait("extroversion"));
		//System.out.println("Openness+Communalism+Extroversion / 3: " + getAffectingTrait("openness") +
		//		" + " + getAffectingTrait("communalism") + " + " + getAffectingTrait("extroversion") + " + ");
		setTrait("agreeableness", newvalue);
	}	
	
	void calculateCompassion() {
		float newvalue = (float) ((getAffectingTrait("communalism") + getAffectingTrait("emotionality") +
				getAffectingTrait("openness"))/3 + getModifyingTrait("intellect") +
				getModifyingTrait("wisdom", true))+getIncrement("compassion");
		setTrait("compassion", newvalue);
	}
	
	void calculateNeuroticism() {
		float newvalue = (float) ((getAffectingTrait("emotionality") - (getAffectingTrait("openness"))) +
				getModifyingTrait("intellect", true, 10) + getModifyingTrait("wisdom", true)) +
				+getIncrement("neuroticism");
		setTrait("neuroticism", newvalue);
	}
	
	void calculatePride() {
		float newvalue = (float) ((getAffectingTrait("individualism") - getAffectingTrait("wisdom"))
				+ getModifyingTrait("intellect") + getModifyingTrait("tenacity", true) +
				getModifyingTrait("emotionality", true, 10)) + getIncrement("pride");
		setTrait("pride", newvalue);
	}
	
	void calculatePerception() {
		float newvalue = (float) ((getAffectingTrait("intellect") + getAffectingTrait("quickness"))/2
				+ getModifyingTrait("wisdom", true) + getModifyingTrait("openness", true)
				- getModifyingTrait("emotionality", true)) + getIncrement("perception");
		setTrait("perception", newvalue);
	}
	
	void calculateRuleConsciousness() {
		float newvalue = (float) ((getAffectingTrait("communalism", 1.5))
				- getModifyingTrait("creativity") - getModifyingTrait("individualism", true, 10)
				- getModifyingTrait("intellect", true, 10)) + getIncrement("ruleconsciousness");
		setTrait("ruleconsciousness", newvalue);
	}
	
	void calculateSensitivity() {
		float newvalue = (float) ((getAffectingTrait("wisdom") + getAffectingTrait("openness"))/3
				+ getModifyingTrait("emotionality", true) + getModifyingTrait("quickness", 20) +
				getModifyingTrait("creativity")) + getIncrement("sensitivity");
		setTrait("sensitivity", newvalue);
	}
	
	void calculateSociableness() {
		float newvalue = (float) ((getAffectingTrait("extroversion"))/2
				+ getModifyingTrait("emotionality", true, 20) + getModifyingTrait("openness", 20)
				+ getModifyingTrait("communalism") + getModifyingTrait("quickness", 20)
				- getModifyingTrait("intellect")) + getIncrement("sociableness");
		setTrait("sociableness", newvalue);
	}
	
	// TIER 3 CALCULATIONS
	
	void calculateAggressiveness() {
		float newvalue = (float) ((getAffectingTrait("extroversion") + getAffectingTrait("pride") +
				getAffectingTrait("communalism", 0.8) - getAffectingTrait("agreeableness"))/2
				+ getModifyingTrait("tenacity", true) + getModifyingTrait("physicality")
				+ getModifyingTrait("openness")) + getIncrement("aggressiveness");
		setTrait("aggressiveness", newvalue);
	}
	
	void calculateAwareness() {
		float newvalue = (float) ((getAffectingTrait("quickness") + getAffectingTrait("extroversion"))/2
				+ getModifyingTrait("tenacity", true) + getModifyingTrait("wisdom", true)
				+ getIncrement("awareness"));
		setTrait("awareness", newvalue);
	}
	
	void calculateFamilial() {
		float newvalue = (float) ((getAffectingTrait("communalism") + getAffectingTrait("emotionality"))/2
				+ getModifyingTrait("pride", true) + getIncrement("familial"));
		setTrait("familial", newvalue);
	}
	
	void calculateKindness() {
		float newvalue = (float) ((getAffectingTrait("agreeableness") + getAffectingTrait("communalism"))/2
				+ getModifyingTrait("sensitivity", true) + getModifyingTrait("wisdom", true)
				+ getModifyingTrait("openness") + getIncrement("kindness"));
		setTrait("kindness", newvalue);
	}
	
	
	void calculatePatience() {
		float newvalue = (float) ((getAffectingTrait("agreeableness") + getAffectingTrait("openness"))/2
				+ getModifyingTrait("wisdom", true) + getModifyingTrait("tenacity", true)
				+ getIncrement("patience"));
		setTrait("patience", newvalue);
	}
	
	void calculateSpontaneity() {
		float newvalue = (float) ((getAffectingTrait("tenacity") + getAffectingTrait("openness") +
				getAffectingTrait("quickness"))/3 +	getModifyingTrait("extroversion", true) +
				+ getIncrement("spontaneity"));
		setTrait("spontaneity", newvalue);
	}
	
	// This returns the amount over 500 or the amount under 500 in a positive amount,
	// so to use this function you either add or subtract it, depending on whether
	// you want its effects to be positive or negative on the trait.
	float getAffectingTrait(String trait) {
		float traitFloat = getTrait(trait);
		return traitFloat;
	}
	
	float getAffectingTrait(String trait, double weight) {
		float traitFloat = getTrait(trait);
		return (float) (traitFloat*weight);
	}
		
	float getModifyingTrait(String trait) { // true/false means increment/decrement
		float traitFloat = getTrait(trait);
		float newvalue = ((traitFloat)/15);
		return newvalue;
	}

	float getModifyingTrait(String trait, boolean reversible) { // true/false means increment/decrement
		float traitFloat = getTrait(trait);
		float newvalue = ((traitFloat)/15);
		if (reversible==true && newvalue<0) {
			return -newvalue;
		} else return newvalue;
	}
	float getModifyingTrait(String trait, int modifier) { // modifier is the amount to divide by
		float traitFloat = getTrait(trait);
		float newvalue = ((traitFloat)/modifier);
		return newvalue;
	}
	
	float getModifyingTrait(String trait, boolean reversible, int modifier) { // true/false means increment/decrement
		float traitFloat = getTrait(trait);
		float newvalue = ((traitFloat)/modifier);
		if (reversible==true && newvalue<0) {
			return -newvalue;
		} else return newvalue;
	}
	
	
}
