

public class Main {
    public static void main(String[] args) {
        Tree a = new Tree();
        Animal e = new Animal("asd");
        e.setName("kolokot");
        a.insert(5);
        a.insert(3);
        a.insert(7);
        a.insert(1);
        a.insert(6);
        a.insert(2);
        a.insert(5);
        a.delete(5);
        a.delete(2);
        a.delete(1);
        a.delete(8);
        a.traverse();
        for (int i = 0; i < 1000; i++) {
            a.insert(i);
        }
        for (int i = 1000; i > 0; i--) {
            a.delete(i);
        }
        a.traverse();
    }
}
