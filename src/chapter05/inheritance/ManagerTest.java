package chapter05.inheritance;

import chapter05.equals.Employee;
import chapter05.equals.Manager;

/*
 *@version 1.7 2017/3/24
 *@author CaoTing 
 */

public class ManagerTest {
	public static void main(String[] args) {
		//这里值得一提的是超类的引用可以指向它的子类
		Manager boss = new Manager("Carl Cracker",80000,1987,12,15);
		boss.setBonus(5000);
		
		Employee[] staff = new Employee[3];
		staff[0] = boss;
		staff[1] = new Employee("Herry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tommy Tester",40000,1990,3,15);
		
		for(Employee e : staff) 
			System.out.println(" name = "+e.getName()+" salary = "+e.getSalary()+" date = "+e.getDate());
	}
}
