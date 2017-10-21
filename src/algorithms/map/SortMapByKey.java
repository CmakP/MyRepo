package algorithms.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKey {
	
	public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }

	public static void main(String[] args) {
        
        Map<Integer, String> unsortMap1 = new HashMap<Integer, String>();
        unsortMap1.put(10, "z");
        unsortMap1.put(5, "b");
        unsortMap1.put(6, "a");
        unsortMap1.put(20, "c");
        unsortMap1.put(1, "d");
        unsortMap1.put(7, "e");
        unsortMap1.put(8, "y");
        unsortMap1.put(99, "n");
        unsortMap1.put(50, "j");
        unsortMap1.put(2, "m");
        unsortMap1.put(9, "f");

        System.out.println("Unsort Map......");
        printMap(unsortMap1);
        
        System.out.println("\nSorted Map By Key in Natural order, using TreeMap: ");
        Map<Integer, String> treeMap2 = new TreeMap<Integer, String>(unsortMap1);
        printMap(treeMap2);
       
        System.out.println("\nSorted Map By Key using Comparator in descending order: ");
        Map<Integer, String> treeMap1 = new TreeMap<Integer, String>(
            new Comparator<Integer>() {
            	@Override
                public int compare(Integer o1, Integer o2) {
            		return o2.compareTo(o1);
                }
        });
        treeMap1.putAll(unsortMap1);
        printMap(treeMap1);
    
        System.out.println("\nSorted Map using Lambda and Comparator in ascending order: ");
        // For Java 8, try this lambda
    	Map<Integer, String> treeMap3 = new TreeMap<Integer, String>(
    	                (Comparator<Integer>) (o1, o2) -> o1.compareTo(o2));
    	
    	// or   (o1, o2) -> o1.compareTo(o2));
    	//or 	(o1, o2) -> o1 - o2));
    	
        treeMap3.putAll(unsortMap1);
        printMap(treeMap3);
    }
}
