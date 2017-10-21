package algorithms.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapByValue {

	public static void main(String[] args) {
		  
		Map<Integer, String> unsortMap = new HashMap<Integer, String>();
        unsortMap.put(10, "z");
        unsortMap.put(5, "b");
        unsortMap.put(6, "a");
        unsortMap.put(20, "c");
        unsortMap.put(1, "d");
        unsortMap.put(7, "e");
        unsortMap.put(8, "y");
        unsortMap.put(99, "n");
        unsortMap.put(50, "j");
        unsortMap.put(2, "m");
        unsortMap.put(9, "f");	            
        System.out.println("Unsort Map: " + unsortMap);
        
        Map<Integer, String> sortedLinkMap = new LinkedHashMap<>();
        List<Entry<Integer, String>> list = new ArrayList<>(unsortMap.entrySet());
        list.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        System.out.println("Sorted list: " + list); 
        list.forEach(e -> sortedLinkMap.put(e.getKey(), e.getValue()));
        System.out.println("Sorted linkedMap by Value: " + sortedLinkMap); 
        sortedLinkMap.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
	}
}
