package algorithms.intersection;

import java.util.Arrays;

public class ArrayIntersection {

	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int[] b = {2, 3, 4};
		int[] intersection = intersection(a, b);	
		System.out.println(Arrays.toString(intersection));
	}
	
	public static int[] intersection(int[] a, int[] b) {
	   return Arrays.stream(a)
	            .filter(x -> Arrays.stream(b)
	                    .anyMatch(y -> y == x)
	            )
	            .toArray();
	}

}
