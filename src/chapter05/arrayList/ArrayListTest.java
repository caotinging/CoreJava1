package chapter05.arrayList;

import java.util.ArrayList;

import chapter05.equals.Employee;

/*
 * This program demonstrates the ArrayList class
 * @version 1.7.0_80 2017/3/28
 * @author CaoTing
 */

public class ArrayListTest {
	public static void main (String[] args) {
		ArrayList<Employee> staff = new ArrayList<>();
		//staff也是从0开始计数的，
		staff.add(new Employee("Cral Cracker",75000,1987,12,15));
		staff.add(new Employee("Harry Hacker",50000,1989,10,1));
		staff.add(new Employee("Tony Tester",40000,1990,3,15));
		
		staff.set(0, new Employee("Cao Ting",60000,1998,5,15));
		staff.add(1,new Employee("Yuan Hao",60000,1999,11,12));
		Employee Delete = staff.remove(2);
		//E.remove方法会返回被删除的那个元素
		System.out.println("The element that was removed from this list is: "+Delete);
		System.out.println("The size of this list is: "+staff.size());
		
		for(Employee e:staff) {
			e.raiseSalary(5);
		}
		for(Employee e:staff) {
			System.out.println("name = "+e.getName()+" salary = "+e.getSalary()+" Hireday = "+e.getDate());
		}
	}
}
