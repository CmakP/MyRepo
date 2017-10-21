package algorithms.threads;

import java.util.ArrayList;
import java.util.List;

public class MyThreadJoin {

	 public static List<String> names = new ArrayList<String>();
     
	    public static void main(String a[]){
	        List<SampleThread> list = new ArrayList<SampleThread>();
	        for(int i=0;i<5;i++){
	            SampleThread s = new SampleThread();
	            list.add(s);
	            System.out.println("Started: " + s.getName());
	            s.start();
	        }
	        for(SampleThread st:list){
	            try{
	                st.join();
	                //System.out.println("from Join: " + st.getName());
	            } catch (Exception ex){}
	        }
	        System.out.println(names);
	    }
	}
	 
	class SampleThread extends Thread{
	     
		@Override
	    public void run(){
	        for(int i=0; i<10; i++) {
	            try{
	                Thread.sleep(10);
	            } catch(Exception ex){}
	        }
	        MyThreadJoin.names.add(Thread.currentThread().getName());
	        System.out.println("Terminated: " + getName());
	    }
	}