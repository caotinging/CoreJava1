package chapter12.pair;

import chapter05.equals.Employee;
import chapter05.equals.Manager;

/**
 * @version 1.8 2017/5/19
 * @author caoting
 */
public class PairTest3 {
	public static void main(String[] args) {
		chapter05.equals.Manager ceo = new chapter05.equals.Manager("Gus Greedy", 800000, 2003, 12, 15);
		chapter05.equals.Manager cfo = new chapter05.equals.Manager("Sid Sneaky", 600000, 2003, 12, 15);
		
		Pair<Manager> buddies = new Pair<> (ceo, cfo);
		printBuddies(buddies);
		
		ceo.setBonus(1000000);
		cfo.setBonus(500000);
		
		chapter05.equals.Manager[] managers = { ceo, cfo };
		Pair<Employee> result = new Pair<> ();
		
		minmax(managers, result);
		System.out.println("Pair<Employee> : \nFirst = " + result.getFirst().getName()
				+ " Second = " + result.getSecond().getName());
		maxmin(managers, result);
		System.out.println("½»»»Ö®ºó: \nPair<Employee> : \nFirst = " + result.getFirst().getName()
				+ " Second = " + result.getSecond().getName());
	}
	
	public static void printBuddies(Pair<? extends Employee> p) {
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println("Pair<Manager> :\nFirst = " + first.getName() + " Second = " + second.getName());
	}
	
	public static void minmax(Manager[] a, Pair<? super Manager> result) {
		if(a == null || a.length == 0) return;
		
		Manager min = a[0];
		Manager max = a[0];
		for(int i = 1; i < a.length; i++) {
			if(min.getSalary() > a[i].getSalary()) min = a[i];
			if(max.getSalary() < a[i].getSalary()) max = a[i];
			}
		result.setFirst(min);
		result.setSecond(max);
	}
	
	public static void maxmin(Manager[] a, Pair<? super Manager> result) {
		minmax(a, result);
		PairAlg.swapHelper(result);
	}
}

class PairAlg {
	public static boolean hasNulls(Pair<?> p) {
		return p.getFirst() == null || p.getSecond() == null;
	}
	
	public static void Swap(Pair<?> p) { swapHelper(p); }
	
	public static <T> void swapHelper(Pair<T> p) {
		T t = p.getSecond();
		p.setSecond(p.getFirst());
		p.setFirst(t);
	}
}