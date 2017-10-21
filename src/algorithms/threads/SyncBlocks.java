package algorithms.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Using two Objects as locks to make the program time efficient.
 */
public class SyncBlocks {

	public SyncBlocks() {}

	public static void main(String[] args) {
		new SyncBlocks().new Worker().main();
	}

	/*
	 * Note that just by having one Worker object the program takes around 4 seconds to finish.
	 * The problem is there is only one intrinsic lock, so when t1 is executing 
	 * sync stageOne block, t2 (or any other thread) has to wait for t1 to release the lock. 
	 * And even if t2 (or any other thread) tries to write to ANOTHER independent sync block 
	 * it will have to wait for the same lock to be released by t1.
	 * 
	 * What we want is a system whereby no two threads can write to stageOne() at the same time
	 * but different threads can write to different blocks (stageOne(), stageTwo(), ...)
	 * at the same time.
	 */
	class Worker {
		
		private Object lock1 = new Object();
		private Object lock2 = new Object();
		
		private Random random = new Random();
		
		private List<Integer> list1 = new ArrayList<Integer>(); 
		private List<Integer> list2 = new ArrayList<Integer>(); 
		
	// This will take approximately 4 seconds to finish. No locks used.	
	/*	public synchronized void stageOne() {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			list1.add(random.nextInt(100));
		}
		
		public synchronized void stageTwo() {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			list2.add(random.nextInt(100));
		} */
		
		public void stageOne() {
			// sleep doesn't need to be within the synchronized block, just simulating
			// it's doing something which needs to be synchronized
			synchronized (lock1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
				}
				list1.add(random.nextInt(100));
			}
		} 
		
		public void stageTwo() {
			synchronized (lock2) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
				}
				list2.add(random.nextInt(100));
			}
		}
		
		public void process() {
			
			for(int i = 0; i < 1000; i++) {
				stageOne();
				stageTwo();
			}
		}
		
		public void main() {
			
			System.out.println("Starting...");
			
			long start = System.currentTimeMillis();
			
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					process();
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					process();
				}
			});
			
			t1.start();
			t2.start();
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println("Duration: " + (end - start));
			System.out.println("List1: " + list1.size() +" ; List2: " + list2.size());
		}
	}
}
