
public class TreeNode extends GenericNode {
    
    private TreeNode lchild;
    private TreeNode rchild;
    
    public TreeNode(int value) {
        super(value);
        lchild = null;
        rchild = null;
    }
    
    public void accept(Visitor v) {
        v.visit(this);
    }
}
