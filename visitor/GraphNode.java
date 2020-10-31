
public class GraphNode extends GenericNode {
    private String label;
    private ListNode edges;
    
    public GraphNode(int value, String label) {
        super(value);
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public void accept(Visitor v) {
        v.visit(this);
    }
}
