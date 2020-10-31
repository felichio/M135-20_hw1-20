
public class PrintVisitor implements Visitor {
    
    public void visit(GenericNode n) {
        System.out.println("I am a GenericNode with value " + n.getValue());
        
    }
    
    public void visit(ListNode n) {
        System.out.println("I am a ListNode with value " + n.getValue());
        
//        System.out.println(n.getValue().getValue());
    }
    
    public void visit(HeapNode n) {
        System.out.println("I am a HeapNode with value " + n.getValue());
    }
    
    public void visit(TreeNode n) {
        System.out.println("I am a TreeNode with value " + n.getValue());
    }
    
    public void visit(GraphNode n) {
        System.out.println("I am a GraphNode with value " + n.getValue());
    }
}
