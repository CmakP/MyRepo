package algorithms.sort;

import java.util.Comparator;

public class ComparatorWordSorter {

	public class CompareByMinLength implements Comparator<Item> {
		@Override
		public int compare(Item item1, Item item2) {
			return item1.getDescription().length() - item2.getDescription().length();
		}
	}

	public static class CompareByMaxLength implements Comparator<Item> {
		@Override
		public int compare(Item item1, Item item2) {
			return item2.getDescription().length() - item1.getDescription().length();
		}
	}
}
