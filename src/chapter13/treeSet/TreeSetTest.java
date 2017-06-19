package chapter13.treeSet;

import java.util.*;

public class TreeSetTest {
	public static void main(String[] args) {
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("Widget", 4562));
		parts.add(new Item("Modem", 9912));
		System.out.println(parts);
		
		SortedSet<Item> sortByDescription = new TreeSet<>(new Comparator<Item>() {
			public int compare(Item a, Item b) {
				String aDesc = a.getDescription();
				String bDesc = b.getDescription();
				return aDesc.compareTo(bDesc);
			}
		});
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}
}
