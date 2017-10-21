package algorithms.set;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TreesetExp {

	public static void main(String[] args) {
		// TreeSet provides an implementation of the Set interface that uses a tree for storage. 
		// Objects are stored in a sorted and ascending order. Access and retrieval times are quite fast, 
		// which makes TreeSet an excellent choice when storing large amounts of sorted information that 
		// must be found quickly.
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("C");
	    ts.add("A");
	    ts.add("B");
	    ts.add("E");
	    ts.add("F");
	    ts.add("D");
	    System.out.println(ts);

	    List<String> list = new ArrayList<String>();
	    list.add("C");
	    list.add("A");
	    list.add("B");
	    list.add("E");
	    list.add("F");
	    list.add("D");
	    
	    //This constructor builds a tree set that contains the elements of the collection c.
	    TreeSet<String> ts1 = new TreeSet<String>(list);
	    System.out.println(ts1);
	    
	    list.forEach(item -> System.out.print(item + " ")); 
	    System.out.println();
	    list.forEach(System.out::print);
	}
}
