package algorithms.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedHashMapLoadFactor {
	
	public static void main(String[] args) {
		// Create a HashMap
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("Smith", 30);
		hashMap.put("Anderson", 31);
		hashMap.put("Lewis", 29);
		hashMap.put("Cook", 29);

		System.out.println("Display entries in HashMap, unsorted: ");
		System.out.println(hashMap);

		// Create a TreeMap from the previous HashMap
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(hashMap);
		System.out.println("\nDisplay entries in ascending order of key");
		System.out.println(treeMap);
	
		// Create a LinkedHashMap
//		Constructs an empty LinkedHashMap instance with the specified initial capacity, load factor and ordering mode.
//		Parameters:
//		initialCapacity - the initial capacity
//		loadFactor - the load factor
//		accessOrder - the ordering mode - true for access-order: least accessed to most accessed keys.
//		if accessOrder is true, then it will result in access Order, One of the important application 
//		of access order LinkedHashMap is building LRU cache.
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>(16, 0.75f, true);
		linkedHashMap.put("Smith", 30);
		linkedHashMap.put("Anderson", 31);
		linkedHashMap.put("Lewis", 29);
		linkedHashMap.put("Cook", 29);

		System.out.println("\nDisplay entries in LinkedHashMap");
		System.out.println(linkedHashMap);
		
		// Display the age for Lewis 
	    System.out.println("The age for Lewis is " + linkedHashMap.get("Lewis").intValue());
	    
	    // Access Order = true meaning, least accessed to most accessed keys.
	    System.out.println("\nDisplay entries in LinkedHashMap");
		System.out.println(linkedHashMap);
	}
}
