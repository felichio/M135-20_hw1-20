

aspect Test {
    
    private volatile boolean Tree.mutex = true;

    pointcut insertChange(Tree t, int a): target(t) && call(public void Tree.insert(int)) && args(a);
    
    pointcut removeChange(Tree t, int a): target(t) && call(public void Tree.remove(int)) && args(a);

    void around(Tree t, int a): insertChange(t, a) {
        if (t.mutex) {
            t.mutex = false;
            proceed(t, a);
            t.mutex = true;
        } else {
            t.insert(a);
        }
    }

    void around(Tree t, int a): removeChange(t, a) {
        if (t.mutex) {
            t.mutex = false;
            proceed(t, a);
            t.mutex = true;
        } else {
            t.remove(a);
        }
    }
}