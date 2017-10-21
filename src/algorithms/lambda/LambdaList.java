package algorithms.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaList {

	public static void main(String[] args) {
		new LambdaList().lambdaTest();
	}
	
	public void lambdaTest() {
    	List<String> list = new ArrayList<String>();
 	    list.add("C");
 	    list.add("A");
 	    list.add("B");
 	    list.add("E");
 	    list.add("F");
 	    list.add("D");
 	    
 	    list.forEach(item -> System.out.print(item + " ")); 
 	    System.out.println();
 	    
 	    list.forEach(System.out::print);
 	    System.out.println();
	    
 	    list.replaceAll(String::toLowerCase);
 	    System.out.println(list);
    }
}
