package algorithms.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class GenericSortMapValue {

	public static void main(String[] args) {
		GenericSortMapValue sortedMap = new GenericSortMapValue();
		GenericSortMapValue.SortMapTest test = sortedMap.new SortMapTest();
		Map<String, Integer> map = test.testsortByValueGeneric();
		System.out.println("SortedMap By Value - Generic Method");
		map.forEach((k, v) -> System.out.println("Key= " + k + " Value= " + v));
	}
	
	@SuppressWarnings("unused")
	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        	@Override
        	public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/
        return sortedMap;
    }
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueGeneric(Map<K, V> map)
	{
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>()
		{
			@Override
			public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2)
			{
				return (o1.getValue()).compareTo( o2.getValue());
			}
        });

		Map<K, V> result = new LinkedHashMap<K, V>();
    	for (Map.Entry<K, V> entry : list)
    	{
        	result.put(entry.getKey(), entry.getValue());
    	}
    	return result;
	}
	
	class SortMapTest
	{
	    @Test
	    public Map<String, Integer> testsortByValueGeneric()
	    {
	        Random random = new Random(System.currentTimeMillis());
	        Map<String, Integer> testMap = new HashMap<String, Integer>(1000);
	        for(int i = 0 ; i < 1000 ; ++i) {
	            testMap.put( "SomeString " + random.nextInt(), random.nextInt());
	        }

	        testMap = GenericSortMapValue.sortByValueGeneric( testMap );
	        Assert.assertEquals(1000, testMap.size());

	        Integer previous = null;
	        for(Map.Entry<String, Integer> entry : testMap.entrySet()) {
	            Assert.assertNotNull(entry.getValue());
	            if (previous != null) {
	                Assert.assertTrue(entry.getValue() >= previous);
	            }
	            previous = entry.getValue();
	        }
	      return testMap;
	    }
	}
}
