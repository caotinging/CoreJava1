package chapter06.clone;

public class Employee  implements Comparable<Employee> {
	private String name = "";
	private double salary = 0;
	public Employee (String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName () {
		return name;
	}
	public double getSalary () {
		return salary;
	}
	public void raiseSalary (double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	/**
	 * Compares employees by salary
	 * @param other another Employee object.
	 * @return a negative value if this employee has a lower salary than the otherobject,
	 * 0 if the salaries are the same, a positive value oherwise
	 */
	public int compareTo(Employee other) {
		return Double.compare(salary, other.salary);
	}
}
