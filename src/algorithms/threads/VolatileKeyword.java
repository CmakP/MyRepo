package algorithms.threads;

import java.util.Scanner;

/*
 * The idea is that both threads are reading the same variable and in some cases the catch
 * is that the Processor Thread might decide to cache the boolean value at the start based 
 * on java optimization or some other unknown reason so it will never see the change value 
 * of running, since it might not expect other threads to modify it or it might have it's 
 * own copy of the variable.
 */
public class VolatileKeyword {

	public static void main(String[] args) {
		App1 proc1 = new App1();
		proc1.start();
		
		System.out.println("Press return to start...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
		scanner.close();
	}
}

class App1 extends Thread {
	
	private volatile boolean running = true;
	
	@Override
	public void run() {
		while(running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}


