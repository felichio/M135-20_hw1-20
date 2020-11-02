

public class Main {
    public static void main(String[] args) {
        Tree a = new Tree();
        
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
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        a.traverse();
        System.out.println("------ " + a.counter);
    }
}
