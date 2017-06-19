package chapter05.abstractClasses;

import java.lang.reflect.*;

/**
 * This program shows how to invoke method through reflection.
 * @author CaoTing
 * @version 1.7.0_80 2017/4/6
 */
public class MethodPointerTest {
	public static void main (String[] args) throws Exception {
		//get method pointer to the square and sqrt methods.
		Method square = MethodPointerTest.class.getMethod("square", double.class);
		Method sqrt = Math.class.getMethod("sqrt", double.class);
		//getMethod是class的方法自然这两个类都能使用
		
		EmployeeCopy employee = new EmployeeCopy("harry", 40000);
		//EmployeeCopy类的getSalary方法没有参数因此getMethod不需要给出参数类型
		Method getsalary = EmployeeCopy.class.getMethod("getSalary");
		//getSalary不是静态方法，因此需要提供EmployeeCopy类的实例，不需要传递参数
		double salary = (Double) getsalary.invoke(employee);
		System.out.println("salary = " + salary);
		
		//print tables of x- and y-values
		
		printTable(1, 10, 10, square);
		printTable(1, 10, 10, sqrt);
	}
	
	/**
	 * Returns the square of a number
	 * @param x a number
	 * @return x squared
	 */
	public static double square(double x) {
		return x * x;
	}
	/**
	 * Prints a table with x- and y-values fora method.
	 * @param from the lower bound for the x-values
	 * @param to the upper bound for the x-values
	 * @param n the number of rows in the table
	 * @param f a method with a double parameter and double return value
	 */
	public static void printTable (double from, double to, int n, Method f) {
		//print out the method as table header
		System.out.println(f);
		
		double dx = (to - from) / (n - 1);
		for (double x = from; x <= to; x += dx) {
			try {
				double y = (Double) f.invoke(null, x);
				System.out.printf("%10.4f | %10.4f%n", x, y);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
