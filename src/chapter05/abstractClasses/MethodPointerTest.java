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
		//getMethod��class�ķ�����Ȼ�������඼��ʹ��
		
		EmployeeCopy employee = new EmployeeCopy("harry", 40000);
		//EmployeeCopy���getSalary����û�в������getMethod����Ҫ������������
		Method getsalary = EmployeeCopy.class.getMethod("getSalary");
		//getSalary���Ǿ�̬�����������Ҫ�ṩEmployeeCopy���ʵ��������Ҫ���ݲ���
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
