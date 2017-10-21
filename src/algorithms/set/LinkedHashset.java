package algorithms.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashset {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");
		System.out.println(set);

		// Obtain an iterator for the hash set
		Iterator<String> iterator = set.iterator();

		// Display the elements in the hash set
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		System.out.println();
		
		Set<String> linkedSet = new LinkedHashSet<String>();
		linkedSet.add("London");
		linkedSet.add("Paris");
		linkedSet.add("New York");
		linkedSet.add("San Francisco");
		linkedSet.add("Beijing");
		linkedSet.add("New York");
		System.out.println(linkedSet);
		
	}
}
