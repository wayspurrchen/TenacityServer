package tenacity.Lexicon.Expressions;

import tenacity.Lexicon.Concepts.Concept;
import tenacity.Lexicon.Concepts.RelationalDeclarativeSimple;
import tenacity.Lexicon.Concepts.Thing;
import tenacity.Lexicon.Concepts.Value;

public class SimpleDeclarativeStatement extends Expression {
	
	public SimpleDeclarativeStatement() {
		conceptFeed = new Concept[3];
		conceptFeed[0] = new Thing();
		conceptFeed[1] = new RelationalDeclarativeSimple();
		conceptFeed[2] = new Value();
	}
}
