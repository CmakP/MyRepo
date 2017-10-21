package algorithms.threads;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
	
	private static Buffer buffer = new Buffer();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		executor.shutdown();
	}

	private static class ProducerTask implements Runnable {
		@Override
		public void run() {
			try {
				int i = 1;
				while (true) {
					System.out.println("Producer writes " + i);
					buffer.write(i++); 
					Thread.sleep((int) (Math.random() * 10000));
				}
			} catch (InterruptedException ex) {
			}
		}
	}

	private static class ConsumerTask implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					int i = buffer.read();
					System.out.println("\t\t\tConsumer reads " + i);
					Thread.sleep((int) (Math.random() * 10000));
				}
			} catch (InterruptedException ex) {
			}
		}
	}

	private static class Buffer {
		private static final int FULL = 1; // buffer size
		private LinkedList<Integer> queue = new LinkedList<Integer>();

		private static Lock lock = new ReentrantLock();

		private static Condition notEmpty = lock.newCondition();
		private static Condition notFull = lock.newCondition();

		public void write(int value) {
			lock.lock(); 
			try {
				while (queue.size() == FULL) {
					System.out.println("Wait for notFull condition");
					notFull.await();
				}

				queue.offer(value);
				notEmpty.signal(); // Signal notEmpty condition
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.unlock(); // Release the lock
			}
		}

		@SuppressWarnings("finally")
		public int read() {
			int value = 0;
			lock.lock(); // Acquire the lock
			try {
				while (queue.isEmpty()) {
					System.out.println("\t\t\tWait for notEmpty condition");
					notEmpty.await();
				}

				value = queue.poll();
				notFull.signal(); // Signal notFull condition
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.unlock(); // Release the lock
				return value;
			}
		}
	}
}
