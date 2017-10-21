package algorithms.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConvertSetToArray {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("E");
		set.add("F");
		set.add("C");
		set.add("A");
		set.add("B");
		set.add("D");
		String[] array = set.toArray(new String[set.size()]);
		System.out.println(Arrays.toString(array));
	}
}
