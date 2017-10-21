package algorithms.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySort {

	public static void main(String[] args) {
		Integer[] values = new Integer[] { 3, 1, 14, 3, 4, 5, 6, 7, 8, 9, 11, 3, 2, 1 };
		Arrays.sort(values);
		for(int i : values) {
			System.out.print(i + " ");
		}
		List<Integer> sortedList = Arrays.asList(values);
		Collections.sort(sortedList);
		System.out.println("\n" + sortedList);
	}
}
