

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

        int num = a.traverse();
        assert num == 2000 : "Number of elements inside tree must be 2000";
        System.out.println();
    }
}
