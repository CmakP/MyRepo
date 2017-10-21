package algorithms.set;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Set - extends the Collection interface for sets that maintain unique elements 
 * SortedSet - for sets with elements in sorted order
 */
public class NaturalOrderExceptionSet {

	public static void main(String[] args) {
	
		// Using SortedSet Interface just to emphasize on a sorted set
		SortedSet<Item> parts = new TreeSet<Item>();
		parts.add(new Item("Toaster1", 1234));
		parts.add(new Item("Toaster2", 1234));	//Case A
		parts.add(new Item("Widget", 4562));
		parts.add(new Item("Modem", 9912));
		
		System.out.println(parts);
		
		SortedSet<Item> sortByDescriptionLambda = new TreeSet<Item>(
				(Item a, Item b) -> b.getDescription().compareTo(a.getDescription()));
		
		sortByDescriptionLambda.addAll(parts);
		System.out.println(sortByDescriptionLambda);
		
		// Note how one of the elements in the set gets overridden
		SortedSet<Item> sortByPartNumberLambda = new TreeSet<Item>(
				(Item a, Item b) -> b.getPartNumber() - a.getPartNumber());
		
		sortByPartNumberLambda.addAll(parts);
		System.out.println(sortByPartNumberLambda);
	}
}

class Item implements Comparable<Item> {
	
	private String description;
	private int partNumber;
	private int price;
	private float discount;
	
	public Item(String description, int partNumber) {
		this.description = description;
		this.partNumber = Integer.valueOf(partNumber);
	}

	public Item(String description, String partNumberString, int price, float discount) {
		this.description = description;
		this.partNumber = Integer.valueOf(partNumberString);
	}
	
	/* Case A:
	 * The Following implementation is incomplete and results in unpredicted addition 
	 * in case SAME part numbers are allowed in the set.
	
	public int compareTo(Item other) {
		return partNumber - other.partNumber;
	}*/
	
	// Instead use the following:
	
	@Override
	public int compareTo(Item other) {
		if(partNumber > other.partNumber) {
			return 1;	// 1 means put it later in the list
		} else if(partNumber < other.partNumber) {
			return -1;	// -1 means put it earlier in the list
		} 
		// Both objects have the same partNumber which means only if they have the exact same
		// description we can conclude they are the same objects, otherwise they are NOT the 
		// same objects. So we use Strings compareTo():
		else { 
			return description.compareTo(other.description);
		}
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
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "[descripion=" + description + ", partNumber=" + partNumber + "]";
	}

	@Override
	public boolean equals(Object other) {
		if (getClass() == other.getClass()) {
			Item otherItem = (Item) other;
			return description.equals(otherItem.description) && partNumber == otherItem.partNumber;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return 13 * description.hashCode() + 17 * partNumber;
	}
}
