package algorithms.threads;

public class BasicJoin {

	private int count = 0;
	
	public static void main(String[] args) {
		BasicJoin app = new BasicJoin();
		app.doWork();
	}
	
	private synchronized void increment() {
		count++;
	}

	private void doWork() {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		System.out.println("Count is: " + count);
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}
	}
}
