package jjtraveler;
import jjtraveler.test.Event;
import jjtraveler.test.Logger;
import jjtraveler.test.SucceedAtNodes;
import jjtraveler.test.VisitorTestCase;

public class TopDownUntilTest extends VisitorTestCase {

    public TopDownUntilTest(String test) {
        super(test);
    }

    public void testTopDownUntil() throws VisitFailure {
	Visitor stopAt = new SucceedAtNodes(n1, n2);

        Logger expected = new Logger();
	expected.log( new Event( stopAt, n0 ));
	expected.log( new Event( stopAt, n1 ));
	expected.log( new Event( stopAt, n2) );

        Visitable nodeReturned = 
	    new TopDownUntil( logVisitor(stopAt) ). visit(n0);

        assertEquals(expected, logger);
        assertEquals(n0, nodeReturned);
    }
}
