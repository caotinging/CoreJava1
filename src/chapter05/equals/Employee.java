package chapter05.equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/*
 * @author CaoTing
 * @version 1.7 2017/3/24
 * 这个类是Manager的超类P155页
 */

public class Employee {
	private String name = "";
	private double salary = 0.0;
	private Date hireDay = new Date();
	
	public Employee (String name,double salary,int year,int month,int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar g = new GregorianCalendar(year,month-1,day);
		hireDay = g.getTime();
	}//构造器
	public Employee(String name) {
		this.name = name;
	}
	public Employee () {
	}//默认构造器
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public Date getDate() {
		return (Date) hireDay.clone();
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent/100;
		salary += raise;
	}
	public boolean equals (Object otherObject) {
		if (this == otherObject) return true;
		//直接的比较两个对象是否完全相同
		if (otherObject == null) return false;
		//若另一个是null则必不相等
		if(getClass() != otherObject.getClass()) return false;
		//若两个对象的类都不一样必不相等getClass返回对象所属的类
		Employee other = (Employee) otherObject;
		//进行到强制类型转换这一步的话说明两个对象属于同一个类即Employee类因此强制转换不会出错
		return Objects.equals (name,other.name) && salary == other.salary && Objects.equals (hireDay,other.hireDay);
	}
	public int hashCode () {
		return Objects.hash(name,salary,hireDay);
		//重定义超类objects中的hashcode方法，因为相同的对象应该返回相同的散列码
	}
	public String toString () {
		return getClass().getName() + "[ name = "+name+" salary = "+salary+" hireDay = "+hireDay+" ]";
		//应该为每一个自定义的类重定义equals，hashcode，toString方法
	}
}
