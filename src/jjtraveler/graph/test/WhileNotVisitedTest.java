package jjtraveler.graph.test;

import jjtraveler.graph.*;
import jjtraveler.Identity;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;
import jjtraveler.test.Logger;
import jjtraveler.test.VisitorTestCase;

public class WhileNotVisitedTest extends VisitorTestCase {

	public WhileNotVisitedTest(String test) {
		super(test);
	}

	public void testCircle() throws VisitFailure {
		Visitor id = new Identity();

		new WhileNotVisited(logVisitor(id)).visit(rootOfCircle);

		Visitable bottomOfCircle = rootOfCircle.getChildAt(0);

		Logger expected = new Logger(id, new Visitable[] { rootOfCircle, bottomOfCircle });

		assertEquals(expected, logger);
	}

}