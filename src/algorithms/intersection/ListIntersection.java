package algorithms.intersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntersection {

	public static void main(String[] args) {
		String[] a = {"milan","dingo", "elpha", "hafil", "meat", "iga", "neeta.peeta"};
		List<String> listOne = new ArrayList<String>(Arrays.asList(a));
		List<String> listTwo = new ArrayList<String>(Arrays.asList("hafil", "iga", "binga", "mike", "dingo"));

		listOne.retainAll(listTwo);
		System.out.println(listOne);	
	}
}
