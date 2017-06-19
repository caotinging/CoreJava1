package chapter06.clone;

import chapter06.interfaces.EmployeeClone;

/**
 * This program demonstrates cloning.
 * @author caoting
 * @version 1.7.0_80 2017/4/8
 */
public class CloneTest {
	public static void main (String[] args) {
		try {
			EmployeeClone original = new EmployeeClone ("John Q. Public", 50000);
			original.setHireDay(2000, 1, 1);
			EmployeeClone cloned = original.clone();
			cloned.raiseSalary(500);
			cloned.setHireDay(2005, 3, 14);
			System.out.println("original = "+original);
			System.out.println("cloned = "+cloned);
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
