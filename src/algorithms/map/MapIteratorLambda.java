package algorithms.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapIteratorLambda {

	public static void main(String[] args) {
		displayResults();
	}
	
	private static void displayResults() {

		Map<String, Integer> results = new HashMap<String, Integer>();
		results.put("one", 1);
		results.put("two", 2);
		results.put("two", 2);
		results.put("three", 3);
		results.put("four", 4);
		
		for (Map.Entry<String, Integer> entry : results.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		// new way of iterating using key
		for(String key : results.keySet()) {
			System.out.println(key + " " + results.get(key));
		}
		
		// using forEach Lambda Expression 
		results.forEach((k, v) -> System.out.println(k + " " + v));
						
		Map<String, Integer> sortedLikedHashMap = new LinkedHashMap<>();
        //sort by value, and reserve, 10,9,8,7,6...
		results.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> sortedLikedHashMap.put(x.getKey(), x.getValue()));
		
		System.out.println("Sorted sortedLikedHashMap...");
		sortedLikedHashMap.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("Sorted...");
        System.out.println(sortedLikedHashMap); 
	}
}
