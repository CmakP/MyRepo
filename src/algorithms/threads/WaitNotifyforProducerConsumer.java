package algorithms.threads;

import java.util.LinkedList;
import java.util.Random;

public class WaitNotifyforProducerConsumer {
	
	private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();
    
    public void produce() throws InterruptedException {

        int value = 0;

        while (true) {

            synchronized (lock) {
                
                while(list.size() == LIMIT) {
                    lock.wait();
                }
                
                list.add(value++);
                lock.notify();
            }

        }
    }

    public void consume() throws InterruptedException {
        
        Random random = new Random();

        while (true) {

            synchronized (lock) {
                
                while(list.size() == 0) {
                    lock.wait();
                }
                
                System.out.print("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }
            
            Thread.sleep(random.nextInt(1000));
        }
    }

	public static void main(String[] args) {
		WaitNotifyforProducerConsumer app = new WaitNotifyforProducerConsumer();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					app.produce();
				} catch (InterruptedException e) {
				}
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
}
