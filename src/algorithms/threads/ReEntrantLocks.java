package algorithms.threads;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLocks {

	private int count = 0;
	 
	// Only one thread can acquire this lock at a time and the same thread who locked 
	// it is the only one who can unlock it.
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        
        // Resembles wait()
        System.out.println("Waiting ....");
        cond.await();
        
        System.out.println("\nWoken up!");

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        
        Thread.sleep(1000);
        lock.lock();
        
        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Return key pressed!");
        
        // Resembles notify()
        cond.signal();

        try {
            increment();
        } finally {
        	System.out.println("Realising the lock in 5 sec");
        	for(int i = 0; i < 5; i++) {
           		System.out.print(". ");  
        		Thread.sleep(1000);
        	}
        	
        	// Note that as soon as the return key is pressed the lock is released, unlike the
        	// notify() in synchronized block which lock isn't released unless the end of block
            lock.unlock();
            Thread.sleep(5000);
            System.out.println("\nEnd of secondThread block, however the lock was released 5 seconds ago!");   
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }
    
    public static void main(String[] args) {
    	ReEntrantLocks app = new ReEntrantLocks();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					app.firstThread();
				} catch (InterruptedException e) {
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					app.secondThread();
				} catch (InterruptedException e) {
				}
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
			app.finished();
		} catch (InterruptedException e) {
		}
	}
}
