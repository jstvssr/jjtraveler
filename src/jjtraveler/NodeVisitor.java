package jjtraveler;


/**
 * An (abstract) implementation of the <code>Visitor</code> interface
 * for testing purposes.
 */

public abstract class NodeVisitor implements jjtraveler.Visitor {

    public jjtraveler.Visitable visit(jjtraveler.Visitable any) 
    throws jjtraveler.VisitFailure {
        jjtraveler.Visitable result;
	if (any instanceof Node) {
	    result = ((Node) any).accept(this);
	} else {
	    throw new jjtraveler.VisitFailure();
	}
	return result;
    }

    public abstract Node visitNode(Node x) 
    throws jjtraveler.VisitFailure ;
}