
public class GenericNode {
    private int value;
    
    public GenericNode(int value) {
        this.value = value;
    }
    
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void accept(Visitor v) {
        v.visit(this);
    }
}
