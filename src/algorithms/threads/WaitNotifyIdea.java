package algorithms.threads;

import java.util.Scanner;

public class WaitNotifyIdea {

	public static void main(String[] args) {
		
		WaitNotifyIdea app = new WaitNotifyIdea();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				app.produce();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					app.consume();
				} catch (InterruptedException e) {
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}
	}
	
	public void produce() {
        synchronized (this) {
            System.out.println("Producer thread running ....");
            try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Cautch InterruptedException!");
			}
            System.out.println("\nResumed.");
        }
    }

    public void consume() throws InterruptedException {
        
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        
        synchronized (this) {
        	System.out.println("Waiting for return key to be pressed...");
            scanner.nextLine();
            System.out.println("Return key pressed!");
            notify();
            // Just to prove that producer does not acquire the lock immediately and it
            // has to wait for the synchronized block to end
            System.out.println("Releasing the key in 5 seconds...");
            for(int i = 0; i < 5; i++) {
            	System.out.print(". ");
            	Thread.sleep(1000);
            }
            scanner.close();
        }
    }
}
