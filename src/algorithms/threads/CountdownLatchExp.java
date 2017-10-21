package algorithms.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * According to docs.oracle A synchronization aid that allows one or more threads to wait 
 * until a set of operations being performed in other threads completes.
 * A CountDownLatch initialized with a count of ONE serves as a simple on/off latch, or gate: 
 * all threads invoking await wait at the gate until it is opened by a thread invoking 
 * countDown(). 
 * A CountDownLatch initialized to N can be used to make one thread wait until N threads have 
 * completed some action, or some action has been completed N times.
 * A useful property of a CountDownLatch is that it doesn't require that threads calling 
 * countDown wait for the count to reach zero before proceeding, it simply prevents any thread 
 * from proceeding past an await until all threads could pass.
 * 
 * Another typical usage would be to divide a problem into N parts, describe each part with a 
 * Runnable that executes that portion and counts down on the latch, and queue all the Runnables 
 * to an Executor. When all sub-parts are complete, the coordinating thread will be able to pass 
 * through await. 
 * (When threads must repeatedly count down in this way, instead use a CyclicBarrier.)
 * 
 * Useful for thread intercommunication
 * 
 * Useful when you want one or more threads (based on the number passed in the constructor) wait at some certain
 * point of the program (latch.await()) until the same task or block of code is executed by all those threads.
 * Each of those threads count-down the latch until the latch reaches zero. As soon as the number of the latch 
 * reaches zero, threads proceed.
 */
class CountDown implements Runnable {
	
    private CountDownLatch latch;
    private int section;
    
    public CountDown(CountDownLatch latch, int section) {
        this.latch = latch;
        this.section = section;
    }
       
    @Override
    public void run() {
    
    	try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        
    	System.out.format("%s Finished executing task: %d%n", Thread.currentThread().getName(), section);
         	
        // Each count-down decrements the latch which is 3 in this case, by 1
        latch.countDown();
        System.out.format("\t\tLatch counts: %d%n", latch.getCount());
         
        // case A: Just to demonstrate that it is important where to count down the latch
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
        System.out.println("\t\t\t\tTerminated: " + Thread.currentThread().getName());
    }
}

public class CountdownLatchExp {
  
	public static void main(String[] args) {
        
        CountDownLatch latch = new CountDownLatch(6);
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // creating n threads
        for(int i = 0; i < 6; i++) {
            executor.submit(new CountDown(latch, i));
        }
        
        try {
        	// when the count-down reaches zero, the method returns 
        	System.out.println(Thread.currentThread().getName() + " has reached at gate, waiting for all program parts to be completed...\n");
        	// As soon as the latch reaches zero await returns and next line of the program will continue, 
        	// regardless of case A.
         
            latch.await();
        	System.out.println("Latch reached zero, gate open for awaiting threads.");
        } catch (InterruptedException e) {
        }
        System.out.println("Completed.");
    }
}
