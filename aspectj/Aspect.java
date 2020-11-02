

aspect Test {
    
    private volatile boolean Tree.mutex = true; // This is not enough, but its ok for the demo (should use AtomicBoolean instead)

    pointcut insertChange(Tree t, int a): target(t) && call(public void Tree.insert(int)) && args(a);
    
    pointcut removeChange(Tree t, int a): target(t) && call(public void Tree.remove(int)) && args(a);

    void around(Tree t, int a): insertChange(t, a) { 
        if (t.mutex) {   // t.mutex.compareAndSet(true, false) condition, in case of AtomicBoolean implementation
            t.mutex = false; // skipped step in case of AtomicBoolean implementation
            proceed(t, a);
            t.mutex = true; // t.mutex.set(true)
        } else {
            t.insert(a);
        }
    }

    void around(Tree t, int a): removeChange(t, a) {
        if (t.mutex) {       // same with above, in case of AtomicReference use
            t.mutex = false;
            proceed(t, a);
            t.mutex = true;
        } else {
            t.remove(a);
        }
    }
}