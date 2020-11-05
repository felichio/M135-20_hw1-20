

aspect Test {
    
    private volatile boolean Tree.writer = true;
    private volatile int Tree.readers = 0;

    pointcut insertChange(Tree t, int a): target(t) && execution(public void Tree.insert(int)) && args(a);
    
    pointcut removeChange(Tree t, int a): target(t) && execution(public void Tree.remove(int)) && args(a);

    pointcut lookupCall(Tree t, int a): target(t) && execution(public boolean Tree.lookup(int)) && args(a);

    void around(Tree t, int a): insertChange(t, a) { 
        synchronized(t) {
            while (!t.writer || t.readers > 0) {
                try {
                    t.wait();
                } catch (InterruptedException ex) {
                    return ;
                }
            }
            t.writer = false;
            proceed(t, a);
            t.writer = true;
            t.notifyAll();
        }
    }

    void around(Tree t, int a): removeChange(t, a) {
        synchronized(t) {
            while (!t.writer || t.readers > 0) {
                try {
                    t.wait();
                } catch (InterruptedException ex) {
                    return ;
                }
            }
            t.writer = false;
            proceed(t, a);
            t.writer = true;
            t.notifyAll();
        }
    }

    boolean around(Tree t, int a): lookupCall(t, a) {
        synchronized(t) {
            while (!t.writer) {
                try {
                    t.wait();
                } catch (InterruptedException ex) {
                    return false;
                }
            }
            ++t.readers;
            boolean q = proceed(t, a);
            --t.readers;
            t.notify();
            return q;
        }
    }
}