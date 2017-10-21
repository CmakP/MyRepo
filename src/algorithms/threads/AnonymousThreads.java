package algorithms.threads;

public class AnonymousThreads {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i =0; i < 10; i++) {
					System.out.println("t " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		
		
		t1.start();
		// try commenting t1.join
		try {
			t1.join();
		} catch (InterruptedException e) {
		}

		new Thread(new Runner()).start();	
	
		for(int i =0; i < 10; i++) {
			System.out.println("Main " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}	
		
	}
}

class Runner implements Runnable {
	@Override
	public void run() {
		for(int i =0; i < 10; i++) {
			System.out.println("Runner " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
