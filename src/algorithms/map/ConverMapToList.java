package algorithms.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConverMapToList {

	public static void main(String[] args) {
		Map<String, String> mapExp = new HashMap<String, String>();

		// Convert all Map keys to a List
		@SuppressWarnings("unused")
		List<String> resultExp = new ArrayList<String>(mapExp.keySet());

		// Convert all Map values to a List
		@SuppressWarnings("unused")
		List<String> resultExp2 = new ArrayList<String>(mapExp.values());

		// Java 8, Convert all Map keys to a List
		@SuppressWarnings("unused")
		List<String> resultExp3 = mapExp.keySet().stream().collect(Collectors.toList());

		// Java 8, Convert all Map values to a List
		@SuppressWarnings("unused")
		List<String> resultExp4 = mapExp.values().stream().collect(Collectors.toList());

		// Java 8, seem a bit long, but you can enjoy the Stream features like filter and etc.
		@SuppressWarnings("unused")
		List<String> resultExp5 = mapExp.values().stream()
			.filter(x -> !"apple".equalsIgnoreCase(x))
			.collect(Collectors.toList());
		
		Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        System.out.println("\n1. Export Map Key to List...");
        List<Integer> result = map.keySet().stream().collect(Collectors.toList());
        result.forEach(System.out::println);

        System.out.println("\n2. Export Map Value to List...");
        List<String> result2 = map.values().stream().collect(Collectors.toList());
        result2.forEach(System.out::println);
        
        System.out.println("\n3. Export Map Value to List..., say no to banana");
        List<String> result3 = map.values().stream()
        		.filter(x -> !"banana".equalsIgnoreCase(x)) //filter banana & return it to resultValues
                .collect(Collectors.toList());
        result3.forEach(System.out::println);

        System.out.println("\n4. Split a map into 2 List");
        List<Integer> resultSortedKey = new ArrayList<>();
        List<String> resultValues = map.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(x -> x.getValue())
                .collect(Collectors.toList());

        resultSortedKey.forEach(System.out::println);
        resultValues.forEach(System.out::println);
	}

}
