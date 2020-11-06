

public class ReadWriteLock {
    private volatile boolean writer;
    private volatile int readers;

    public ReadWriteLock() {
        this.writer = true;
        this.readers = 0;
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while (!writer || readers > 0) {
            wait();
        }
        writer = false;
    }

    public synchronized void acquireReadLock() throws InterruptedException {
        while (!writer) {
            wait();
        }
        ++readers;
        System.out.println("Readers: " + readers); // with Main.java implementation can reach the number of 4
    }

    public synchronized void releaseWriteLock() throws InterruptedException {
        writer = true;
        notifyAll();
    }

    public synchronized void releaseReadLock() throws InterruptedException {
        --readers;
        notify();
    }

    
}