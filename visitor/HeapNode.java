

public class HeapNode extends GenericNode {
    
    public HeapNode(int value) {
        super(value);
    }
    
    public void accept(Visitor v) {
        v.visit(this);
    }
}
