

aspect Test {
    
    private ReadWriteLock Tree.lock = new ReadWriteLock();

    pointcut insertChange(Tree t, int a): target(t) && execution(public void Tree.insert(int)) && args(a);
    
    pointcut removeChange(Tree t, int a): target(t) && execution(public void Tree.remove(int)) && args(a);

    pointcut lookupCall(Tree t, int a): target(t) && execution(public boolean Tree.lookup(int)) && args(a);

    pointcut getNumberOfTreeNodesCall(Tree t): target(t) && execution(public int Tree.getNumberOfTreeNodes());

    void around(Tree t, int a): insertChange(t, a) {
        try {
            t.lock.acquireWriteLock();
            proceed(t, a);
            t.lock.releaseWriteLock();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }

    void around(Tree t, int a): removeChange(t, a) {
        try {
            t.lock.acquireWriteLock();
            proceed(t, a);
            t.lock.releaseWriteLock();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    boolean around(Tree t, int a): lookupCall(t, a) {
        try {
            t.lock.acquireReadLock();
            boolean result = proceed(t, a);
            t.lock.releaseReadLock();
            return result;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    int around(Tree t): getNumberOfTreeNodesCall(t) {
        try {
            t.lock.acquireReadLock();
            int result = proceed(t);
            t.lock.releaseReadLock();
            return result;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}