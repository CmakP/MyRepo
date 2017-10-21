/**
 * Project: Siamak_Pourian_Collection_Conversion
 * File: ListSetMapConversions.java
 * Date: July 16, 2017
 * Time: 1:18:50 PM
 */
package algorithms.collectionconversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * CollectionConvertor.
 * @author Siamak Pourian
 * @version July 16, 2017
 */
public class ListSetMapConversions {

	private static String[] array1 = {"milan","dingo", "elpha", "hafil", "meat", "iga", "neeta.peeta"};
	private static List<String> list1, list2;
	private static Set<String> set1, set2;
	private static Map<Integer, String> map1;
	
	public static void main(String[] args) {
		
		arrayToArrayList();
		arraylistToArray();
		
		arrayToHashSet();
		hashsetToArray();
		
		arraylistToHashSet();
		hashSetToArrayList();
		
		hashmapEntriesToList();
		hashmapKeysToList();
		hashmapValuesToList();
		
		hashmapKeysToSet();
		hashmapValuesToSet();
		hashmapEntriesToSet();
	}

	public static void arrayToArrayList() {
		System.out.println("Array to ArrayList");	
		list1 = new ArrayList<String>(Arrays.asList(array1));
		list2 = new ArrayList<String>(Arrays.asList("hafil", "iga", "binga", "mike", "dingo"));
		System.out.println(list1);
		System.out.println(list2);
	}

	public static void arraylistToArray() {
		System.out.println("\nArrayList to Array");	
		String[] b = list1.toArray(new String[list1.size()]);
		System.out.println(Arrays.toString(b));
	}
	
	public static void arrayToHashSet() {
		System.out.println("\nArray to HashSet");
		set1 = new HashSet<String>(Arrays.asList(array1));
		System.out.println(set1);
	}
	
	public static void hashsetToArray() {
		System.out.println("\nHashSet to Array");
		String[] array = set1.toArray(new String[set1.size()]);
		System.out.println(Arrays.toString(array));
	}
	
	public static void arraylistToHashSet() {
		System.out.println("\nArrayList to HashSet");
		set2 = new HashSet<String>(list1);
		System.out.println(set2);
	}
	
	public static void hashSetToArrayList() {
		System.out.println("\nHashSet to ArrayList");
		List<String> list3 = new ArrayList<>(set2);
		System.out.println(list3);
	}
	
	public static void hashmapEntriesToList() {
		System.out.println("\nHashMap Entry to List");
		map1 = new HashMap<Integer, String>();
		map1.put (1, "Mark");
		map1.put (2, "Tarryn");
		List<Entry<Integer, String>> entryList = new ArrayList<Entry<Integer, String>>(map1.entrySet());
		System.out.println(entryList);
	}
	
	public static void hashmapKeysToList() {
		System.out.println("\nHashMap Keys to List");
		List<Integer> list4 = new ArrayList<Integer>(map1.keySet());
		System.out.println(list4);
	}
	
	public static void hashmapValuesToList() {
		System.out.println("\nHashMap Values to List");
		List<String> list5 = new ArrayList<String>(map1.values());
		System.out.println(list5);
	}
	
	public static void hashmapKeysToSet() {
		System.out.println("\nHashMap Keys to Set");
		Set<Integer> set3 = new HashSet<Integer>(map1.keySet());
		System.out.println("method1: " + set3);
		set3.clear();
		map1.forEach((k, v) -> set3.add(k));
		System.out.println("method2: " + set3);	
	}
	
	public static void hashmapEntriesToSet() {
		System.out.println("\nHashMap Entries to Set");	
		// The Object Generic Type stored in the set is Entry
		Set<Entry<Integer, String>> entries1 = new HashSet<>(map1.entrySet());
		System.out.println(entries1);
		
		Set<Entry<Integer, String>> entries2 = map1.entrySet();
		System.out.println(entries2);
		
		
		for (Map.Entry<Integer, String> entry : entries1) {
			@SuppressWarnings("rawtypes")
			Entry element = entry;
			//or Entry<Integer, String> element = entry;
			System.out.print("Element: " + element);
			System.out.println(" ; Key=" + entry.getKey() + " Value=" + entry.getValue());
		}
	}
	
	public static void hashmapValuesToSet() {
		System.out.println("\nHashMap Values to Set");
		Set<String> set4 = new HashSet<String>();
		map1.forEach((k, v) -> set4.add(v));
		System.out.println(set4);
	}
}
