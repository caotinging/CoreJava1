package chapter05.equals;


/*
 * This program demonstrates the equals method
 * @version 1.7.0_80 2017/3/28
 * @author CaoTing
 */

public class EqualsTest {
	public static void main (String[] args) {
		Employee alice1 = new Employee("Alice Adams",75000,1987,12,15);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alice Adams",75000,1987,12,15);
		Employee Bob = new Employee("Bob Brandson",45000,1997,7,8);
		
		System.out.println("alice1 == alice2: "+(alice1 == alice2));
		System.out.println("alice1 == alice3: "+(alice1 == alice3));
		System.out.println("alice1.equals(alice2): "+alice1.equals(alice2));
		System.out.println("alice1.equals(alice3): "+alice1.equals(alice3));
		System.out.println("alice1.equals(Bob): "+alice1.equals(Bob));
		System.out.println("alice1.getClass() == Bob.getClass(): "+(alice1.getClass() == Bob.getClass()));
		
		Manager carl = new Manager("Carl Cracker",80000,1987,12,15);
		Manager boss = new Manager("Carl Cracker",80000,1987,12,15);
		boss.setBonus(5000);
		
		System.out.println("boss.toString(): "+boss);
		System.out.println("carl.equals(boss): "+carl.equals(boss));
		System.out.println("carl.hashCode(): "+carl.hashCode());
		System.out.println("boss.hashCode(): "+boss.hashCode());
		System.out.println("alice1.hashCode(): "+alice1.hashCode());
		System.out.println("alice2.hashCode(): "+alice2.hashCode());
		
		carl.setBonus(5000);
		System.out.println("carl.equals(boss): "+carl.equals(boss));
		System.out.println("carl.getName(): "+carl.getName());
		System.out.println("Employee.class.getName(): "+Employee.class.getName());
		System.out.println("alice1.getClass().getName(): "+alice1.getClass().getName());
	}
}
