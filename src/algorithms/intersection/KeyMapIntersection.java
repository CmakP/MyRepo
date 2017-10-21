package algorithms.intersection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyMapIntersection {

	public static void main(String[] args) {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("a", "a");
		map1.put("b", "b");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("c", "c");
		map2.put("b", "b");
		
		// intersection on map keys
		Set<String> intersectSet = new HashSet<String>(map1.keySet());
		intersectSet.retainAll(map2.keySet());
		System.out.println("intersection on map keys: " + intersectSet);
		
		// intersection on map values
		intersectSet = new HashSet<String>(map1.values());
		intersectSet.retainAll(map2.values());
		System.out.println("intersection on map values: " + intersectSet);
		
		// intersection on key map and value
		Map<String, String> intersectMap = new HashMap<>(map1);
		intersectMap.keySet().retainAll(map2.keySet());
		System.out.println("intersection on key map and value: " + intersectMap);	
	}
}
