package algorithms.intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersectionwithSet {

	public static void main(String[] args) {
		String[][] a = {{"1","2"}, {"1", "3", "4"}};
		Set<String> setArray1 = new HashSet<String>(Arrays.asList(a[0]));
		System.out.println(setArray1);
		Set<String> setArray2 = new HashSet<String>(Arrays.asList(a[1]));
		System.out.println(setArray2);	
		
		Set<String> intersectSet = new HashSet<>(setArray1);
		intersectSet.retainAll(setArray2);
		System.out.println(intersectSet);
	}

}
