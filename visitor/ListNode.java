
public class ListNode extends GenericNode {
    
    private ListNode nextNode;
    
    
    public ListNode(int value) {
        super(value);
        this.nextNode = null;
    }
    

    
    public void accept(Visitor v) {
        v.visit(this);
    }
    
}
