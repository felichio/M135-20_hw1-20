import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        
        GenericNode a = new GenericNode(1);
        
        ListNode b = new ListNode(10);
        
        HeapNode c = new HeapNode(100);
        
        TreeNode d = new TreeNode(1000);
        
        GraphNode e = new GraphNode(10000, "10000");
        
        Visitor p = new PrintVisitor();
        
        a.accept(p);
        b.accept(p);
        c.accept(p);
        d.accept(p);
        e.accept(p);
        
        Visitor dynamicProxyVisitor = (Visitor) Proxy.newProxyInstance(
                Visitor.class.getClassLoader(), 
                new Class[] {Visitor.class},
                (Object proxy, Method method, Object[] fargs) -> {
                    if (method.getName().equals("visit")) {
                        if (fargs[0] instanceof GraphNode) {
                            System.out.println("I am a GraphNode running through the proxy");
                            System.out.println("My value is : " + ((GraphNode) fargs[0]).getValue());
                            System.out.println("Let's run PrintVisitor's implementation too!");
                            method.invoke(p, (GraphNode) fargs[0]); // This is redundant, just for demo
                            System.out.println("----- Finished --------");
                        } else if (fargs[0] instanceof ListNode) {
                            System.out.println("I am a ListNode running through the proxy");
                            System.out.println("My value is : " + ((ListNode) fargs[0]).getValue());
                            System.out.println("Let's run PrintVisitor's implementation too!");
                            method.invoke(p, (ListNode) fargs[0]); // This is redundant, just for demo
                            System.out.println("----- Finished --------");
                        } else if (fargs[0] instanceof HeapNode) {
                            System.out.println("I am a HeapNode running through the proxy");
                            System.out.println("My value is : " + ((HeapNode) fargs[0]).getValue());
                            System.out.println("Let's run PrintVisitor's implementation too!");
                            method.invoke(p, (HeapNode) fargs[0]); // This is redundant, just for demo
                            System.out.println("----- Finished --------");
                        } else if (fargs[0] instanceof TreeNode) {
                            System.out.println("I am a TreeNode running through the proxy");
                            System.out.println("My value is : " + ((TreeNode) fargs[0]).getValue());
                            System.out.println("Let's run PrintVisitor's implementation too!");
                            method.invoke(p, (TreeNode) fargs[0]); // This is redundant, just for demo
                        } else if (fargs[0] instanceof GenericNode) {
                            System.out.println("I am a GenericNode running through the proxy");
                            System.out.println("My value is : " + ((GenericNode) fargs[0]).getValue());
                            System.out.println("Let's run PrintVisitor's implementation too!");
                            method.invoke(p, (GenericNode) fargs[0]); // This is redundant, just for demo
                            System.out.println("----- Finished --------");
                        }
                    }
                    return null;
                });
        
        a.accept(dynamicProxyVisitor);
        b.accept(dynamicProxyVisitor);
        c.accept(dynamicProxyVisitor);
        d.accept(dynamicProxyVisitor);
        e.accept(dynamicProxyVisitor);
    }
}
