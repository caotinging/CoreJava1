package chapter03.firstSample;

/*
 * 时间:2017.3.23
 * 这个类是chapter04包中的packagetest要调用的类
 */

import java.util.*;

public class Employee {
	private String name = "";
	private double salary = 0.0;
	private Date hireDay;
	private static GregorianCalendar Today = new GregorianCalendar();
	
	public Employee(String name,double salary,int year,int month,int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		//GregorianCalendar类用0表示一月
		hireDay = calendar.getTime();
	}
	public Employee(String name,double salary) {
		this(name,salary,Today.get(Calendar.YEAR),Today.get(Calendar.MONTH),Today.get(Calendar.DAY_OF_MONTH));
	}
	/*
	 * 显式调用构造函数时不能引用实例字段 是因为this的执行顺序先于示例的初始化
	 * 关于这个顺序在包chapter04中类Employee2中验证 onenote java实例化顺序有详解
	 * 由于这个顺序的原因用this显式调用构造函数时不能用实例字段只能用静态字段
	 * 因为调用时实例字段还没有被初始化，而静态字段在装载程序集时就已经分配内存空间了
	 */
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public Date getDate() {
		return hireDay;
	}
	
	public void raiseSalary(double byPrecent) {
		double raise = salary * byPrecent/100;
		salary  += raise;
	}
}
