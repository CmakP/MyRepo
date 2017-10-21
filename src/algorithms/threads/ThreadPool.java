package algorithms.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

	private int id;
	
	public Processor(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting: " + id);
		
		// Simulating some useful work like handling request if this is a server
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println("Completed: " + id);
	}
}

public class ThreadPool {

	public static void main(String[] args) {
		
		// Instead of using the Thread class to start some Processors for different tasks
		// we employ 2 threads from ExecutorService:
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		System.out.println("Starting to submit tasks...");
		
		for(int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}
		
		// Instructing the ExecutorService's managerial thread to shut down when  
		// all the threads have been submitted to stop accepting new tasks.
		executor.shutdown();   // this will not shut down immediately & waits for all the threads to complete
		
		System.out.println("All tasks submitted...");
		
		try {
			// Waits 1 day or all tasks are executed, whichever happens sooner,  
			// and then it will return. After that the next line will execute.
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			System.out.println("Your one day is Up! Continuing the program...");
		}	
		System.out.println("All tasks completed.");
	}
}
