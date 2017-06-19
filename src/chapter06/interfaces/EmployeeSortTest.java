package chapter06.interfaces;

import java.util.*;

import chapter06.clone.Employee;

/**
 * This program demonstrates the use of the Comparable interface.
 * @version 1.7.0_80 2017/4/8
 * @author caoting
 */
public class EmployeeSortTest {
	public static void main (String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Harry Hecter", 35000);
		staff[1] = new Employee("Carl Cracter", 75000);
		staff[2] = new Employee("Tony Tester", 38000);
		
		System.out.println("ago :");
		for (Employee e : staff) {
			System.out.println("name = "+e.getName()+" salary = "+e.getSalary());
		}
		Arrays.sort(staff);
		
		//print out information about all employee objects.
		System.out.println("before :");
		for (Employee e : staff) {
			System.out.println("name = "+ e.getName()+" salary = "+e.getSalary());
		}
	}
}
