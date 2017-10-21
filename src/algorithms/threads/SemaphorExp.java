package algorithms.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/*
 * According to docs.oracle: A semaphore initialized to one, and which is used such that it 
 * only has at most one permit available, can serve as a mutual exclusion lock. This is more 
 * commonly known as a binary semaphore, because it only has two states: one permit available, 
 * or zero permits available. When used in this way, the binary semaphore has the property 
 * (unlike many Lock implementations), that the "lock" can be released by a thread other than 
 * the owner (as semaphores have no notion of ownership). This can be useful in some specialized 
 * contexts, such as deadlock recovery.
 * 
 * Semaphores could be used as a lock, however you can release it from different threads, unlike 
 * the lock that you have to release from the same thread which locked it in the first place 
 * 
 * Semaphores are usually used to control access to some resource
 */
public class SemaphorExp {

	  static class Connection {

	    private static Connection instance = new Connection();
	    
	    // If there are no available permits Semaphore will just wait for one to become available
	    // true: makes it a FIFO service
	    private Semaphore sem = new Semaphore(10, true);

	    private int connections = 0;

	    private Connection() {

	    }

	    public static Connection getInstance() {
	        return instance;
	    }

	    public void connect() {
	        try {
	            sem.acquire();
	        } catch (InterruptedException e1) {
	            e1.printStackTrace();
	        }

	        try {
	            doConnect();
	        } finally {
	            sem.release();
	        }
	    }

	    public void doConnect() {

	        synchronized (this) {
	            connections++;
	            System.out.println("Current connections: " + connections);
	        }

	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        synchronized (this) {
	            connections--;
	        }
	    }
	}

	public static void main(String[] args) throws Exception {
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        for(int i=0; i < 200; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }
        
        executor.shutdown();
        
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
