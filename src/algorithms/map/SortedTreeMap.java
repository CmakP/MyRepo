package algorithms.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortedTreeMap {

	public static void main(String[] args) {
		
		  Map<String, String> unsortMap = new HashMap<String, String>();
	        unsortMap.put("Z", "z");
	        unsortMap.put("B", "b");
	        unsortMap.put("A", "a");
	        unsortMap.put("C", "c");
	        unsortMap.put("D", "d");
	        unsortMap.put("E", "e");
	        unsortMap.put("Y", "y");
	        unsortMap.put("N", "n");
	        unsortMap.put("J", "j");
	        unsortMap.put("M", "m");
	        unsortMap.put("F", "f");

	        System.out.println("\nUnsort Map......");
	        printMap(unsortMap);

	        System.out.println("\nSorted Map By Key using TreeMap: ");
	        Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
	        printMap(treeMap);
	        
	        System.out.println("\nSorted Map By Key using TreeMap, descending: ");
	        treeMap = new TreeMap<String, String>((o1, o2) -> o2.compareTo(o1));
	        treeMap.putAll(unsortMap);
	        printMap(treeMap);	        
	}
	
	public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }
}
