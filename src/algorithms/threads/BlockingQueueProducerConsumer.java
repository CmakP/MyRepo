package algorithms.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueProducerConsumer {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
        	public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
        	@Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
    
    private static void producer() throws InterruptedException {
        Random random = new Random();
        
        while(true) {     
            queue.put(random.nextInt(100));
      //      queue.offer(random.nextInt(100), 20, TimeUnit.SECONDS);
        }
    }
    
    private static void consumer() throws InterruptedException {
        Random random = new Random();
        
        while(true) {
            Thread.sleep(100);
            
            // The higher the chance, the faster the take() 
            if(random.nextInt(10) == 0) {
                Integer value = queue.take();
     //           Integer value = queue.poll(10, TimeUnit.SECONDS);
                
                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            }
        }
    }
}
