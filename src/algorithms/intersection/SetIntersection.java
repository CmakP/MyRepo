package algorithms.intersection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetIntersection {

	public static void main(String[] args) {
		new SetIntersection().example();
	}
	public void example() {	
		Set<String> set = new HashSet<String>();
		set.add("E");
	    set.add("F");
		set.add("C");
	    set.add("A");
	    set.add("B");
	    set.add("D");
//	    set.add(null);
	    System.out.println("set: " + set);
	    
	    Set<String> set1 = new TreeSet<String>();
	    set1.add("C");
	    set1.add("A");
	    set1.add("B");
	    set1.add("G");
	    set1.add("H");
	    set1.add("I");
	    System.out.println("set1: " + set1);
	    
	    Set<String> intersection = new HashSet<String>(set);
	    System.out.println("\nintersection elements: " + intersection);
	    
	    // Keeps only the elements that intersect in both
	    intersection.retainAll(set1);
	    System.out.println("intersection: " + intersection);
	    
	    Set<String> difference = new HashSet<String>(set);
	    System.out.println("\ndifference elements: " + difference);
	    
	    // Keeps only the elements that are not in the other set
	    difference.removeAll(set1);
	    System.out.println("difference: " + difference);
	}
}
