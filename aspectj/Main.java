

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
        Thread t4 = new Thread(() -> {
            for (int i = 999; i > -1; i--) {
                boolean w = b.lookup(i);
                System.out.println(i + (w ? " Found" : " Not Found"));
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        int num1 = a.traverse();
        int num2 = b.traverse();

        assert num1 == 2000;
        assert num2 == 1000;
        
        System.out.println(num1 + " --- " + num2);
        
    }
}
