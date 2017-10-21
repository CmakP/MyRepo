package algorithms.threads;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * For this simple class, synchronization is an acceptable solution. But for a more 
 * complicated class, we might want to avoid the liveness impact of unnecessary 
 * synchronization. Replacing the int field with an AtomicInteger allows us to prevent 
 * thread interference without resorting to synchronization, as in AtomicCounter:
 */
class AtomicCounter {
	
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " incremented c : " + c);
    }

    public void decrement() {
        c.decrementAndGet();
        System.out.println(Thread.currentThread().getName() + " decremented c : " + c);
    }

    public int value() {
        return c.get();
    }
    
    // Cmak - Not sure how this works
    /*
     * All classes have get and set methods that work like reads and writes on volatile 
     * variables. That is, a set has a happens-before relationship with any subsequent 
     * get on the same variable. The atomic compareAndSet method also has these memory 
     * consistency features, as do the simple atomic arithmetic methods that apply to 
     * integer atomic variables.
     */
    public boolean set(int value) {
    	System.out.println(Thread.currentThread().getName() + " old value: " + c.get() + " new value: " + value );
    	return c.compareAndSet(c.get(), value);
    }
    
    /*
     One way to make Counter safe from thread interference is to make its methods synchronized, as in SynchronizedCounter:


class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

}

     */
    
    public static void  main(String[] args) {
    	AtomicCounter app = new AtomicCounter();
    	
    	Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i = 1; i <= 5; i++) {
					app.increment();
				}
			} 		
    	});
    	
    	Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i = 1; i <= 5; i++) {
					app.increment();
				}
			} 		
    	});
    	
    	t1.start();
    	t2.start();
    	
    	boolean result = app.set(5);
    	for(int i = 1; i < 5; i++) {
    		result = app.set(i);
    		System.out.println("Result: " + result + "; value: " + app.value());
    	}
    }
}
