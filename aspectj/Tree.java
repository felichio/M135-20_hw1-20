

public class Tree {

    private TreeNode root;
    int counter = 0;
    private class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int value) {
            this(value, null, null);
        }
        
    }

    public Tree() {
        this.root = null;
    }

    public boolean lookup(int value) {
        return lookup(value, root);
    }

    private boolean lookup(int value, TreeNode t) {
        if (t.value == value) return true;
        else if (value <= t.value) return lookup(value, t.left);
        else return lookup(value, t.right);
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private TreeNode insert(int value, TreeNode t) {
        if (t == null) return new TreeNode(value);
        else if (value <= t.value) {
            t.left = insert(value, t.left);
        } else {
            t.right = insert(value, t.right);
        }

        return t;
    }

    public void remove(int value) {
        root = remove(value, root);
    }

    private int findSmallestValue(TreeNode t) {
        if (t.left == null) return t.value;
        return findSmallestValue(t.left);
    }

    private TreeNode remove(int value, TreeNode t) {
        if (t == null) return t;
        if (t.value == value) {
            if (t.left == null && t.right == null) {
                return null;
            } else if (t.left == null) {
                return t.right;
            } else if (t.right == null) {
                return t.left;
            } else {
                t.value = findSmallestValue(t.right);
                t.right = remove(t.value, t.right);
            }

        } else if (value <= t.value) {
            t.left = remove(value, t.left);
        } else {
            t.right = remove(value, t.right);
        }

        return t;
    }


    public void traverse() { // in-order traversal
        traverse(root);
    }

    private void traverse(TreeNode t) {
        if (t == null) return;
        traverse(t.left);
        System.out.print(t.value + " ");
        traverse(t.right);
        counter++;
    }
}