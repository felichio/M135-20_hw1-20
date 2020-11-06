

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
            for (int i = 999; i > -1; i--) {     /**  Thread {3} = Set1,  and Threads {4, 5, 6, 7} = Set2 are converging in the opposite direction (small steps each, never in parallel (Set1 vs Set2)) */
                b.lookup(i);
            }
        });
        Thread t5 = new Thread(() -> {
            for (int i = 999; i > -1; i--) {
                b.lookup(i);
            }
        });
        Thread t6 = new Thread(() -> {
            for (int i = 999; i > -1; i--) {
                b.getNumberOfTreeNodes();
            }
        });
        Thread t7 = new Thread(() -> {
            for (int i = 999; i > -1; i--) {
                b.getNumberOfTreeNodes();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        int num1 = a.getNumberOfTreeNodes();
        int num2 = b.getNumberOfTreeNodes();

        assert num1 == 2000;
        assert num2 == 1000;
        
        System.out.println(num1 + " --- " + num2);
        
    }
}
