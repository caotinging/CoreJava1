package chapter13.treeSet;

import java.util.*;

/**
 * @version 1.8 2017/5/24
 * @author caoting
 */
public class Item implements Comparable<Item> {	
	private String description;
	private int partNumber;
	
	public Item(String description, int partNumber) {
		this.description = description;
		this.partNumber = partNumber;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return "[ description = " + description + " partNumber = " + partNumber + " ]";
	}
	
	public boolean equals(Object otherObject) {
		if(this == otherObject) return true;
		if(otherObject == null) return false;
		if(this.getClass() != otherObject.getClass()) 
			return false;
		Item other = (Item) otherObject;
		return Objects.equals(this.description, other.description) && (this.partNumber == other.partNumber);
	}
	
	public int hashCode() {
		return Objects.hash(description, partNumber);
	}
	
	public int compareTo(Item other) {
		return Integer.compare(this.partNumber, other.partNumber);
	}
}
