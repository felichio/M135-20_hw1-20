

public class Main {
    public static void main(String[] args) {
        Tree a = new Tree();
        Tree b = new Tree();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                a.insert(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                a.insert(i);
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                b.insert(i);
                
            }
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        int num1 = a.traverse();
        assert num1 == 2000 : "Number of elements inside tree must be 2000"; // not always true, because we are using a simple boolean check (should use atomicBoolean instead)
        int num2 = b.traverse();
        assert num2 == 1000; // Always true, there is no contest. (lock is per Tree instance and not static)
        
        
        
    }
}
