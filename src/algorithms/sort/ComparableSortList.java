package algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import algorithms.sort.ComparatorWordSorter.CompareByMaxLength;

/**
 * Check B2 class for more lambda expression examples on maps and sorting
 */
public class ComparableSortList {

		public static void main(String[] args) {
		
			List<Item> list = new ArrayList<Item>();
			list.add(new Item("Toaster", 1234, 100));
			list.add(new Item("Widget", 4562, 150));
			list.add(new Item("Modem", 9912, 200));
			list.add(new Item("Toaster", 1234, 100));
			
		// Note that we have implemented the Comparable interface, hence it makes sense
		// for the Collection interface to sort the list based on Natural Ordering idea.
			Collections.sort(list);
			System.out.println("Natural Ordering - sorted list based on partNumber ascending: " + list);
		
			Collections.sort(list, (a, b) -> a.getPartNumber() - b.getPartNumber());
			System.out.println("Lambda - sorted list based on price ascending: " + list);
		
			list.sort((a, b) -> b.getDescription().compareTo(a.getDescription()));
			//list.sort((Item a, Item b) -> b.getDescription().compareTo(a.getDescription()));
			System.out.println("Lambda - sorted list based on category descending: " + list);
			
			list.sort(new Comparator<Item>() {
				@Override
				public int compare(Item o1, Item o2) {
					return o2.getDescription().compareTo(o1.getDescription());
				}			
			});
			System.out.println("Classic - sorted list based on description descending: " + list);
			
			Collections.sort(list, new Comparator<Item>() {
				@Override
				public int compare(Item a, Item b) {
					return a.getPrice() - b.getPrice();
				}			
			});
			System.out.println("Classic - sorted list based on price ascending: " + list);
			
			// accessing an instance method of a non static inner-class 
			Collections.sort(list, new ComparatorWordSorter().new CompareByMinLength()::compare);
			System.out.println("Util Class - sorted list based on min description-length: " + list);
			// or since there is only one method
			Collections.sort(list, new ComparatorWordSorter().new CompareByMinLength());
			System.out.println("Util Class - sorted list based on min description-length: " + list);
			
			// accessing static inner-class
			Collections.sort(list, new CompareByMaxLength());
			// or
			//Collections.sort(list, new CompareByMaxLength()::compare);
			System.out.println("Util Class - sorted list based on max description-length: " + list);
		}
}

class Item implements Comparable<Item> {
	private String description;
	private int partNumber;
	private int price;
	
	public Item(String description, int partNumber) {
		this.description = description;
		this.partNumber = Integer.valueOf(partNumber);
	}

	public Item(String description, int partNumberString, int price) {
		this.description = description;
		this.partNumber = partNumberString;
		this.price = price;
	}

	@Override
	public int compareTo(Item other) {
		return partNumber - other.partNumber;
	}
	
	/**
	 * Gets the description of this item.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the partNumber
	 */
	public int getPartNumber() {
		return partNumber;
	}

	/**
	 * @param partNumber the partNumber to set
	 */
	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "[descripion=" + description + ", partNumber=" + partNumber + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + partNumber;
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (partNumber != other.partNumber)
			return false;
		if (price != other.price)
			return false;
		return true;
	}
}