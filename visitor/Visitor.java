
public interface Visitor {
    public void visit(GenericNode n);
    public void visit(ListNode n);
    public void visit(HeapNode n);
    public void visit(TreeNode n);
    public void visit(GraphNode n);
}
