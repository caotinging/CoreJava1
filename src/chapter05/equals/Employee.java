package chapter05.equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/*
 * @author CaoTing
 * @version 1.7 2017/3/24
 * �������Manager�ĳ���P155ҳ
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
	}//������
	public Employee(String name) {
		this.name = name;
	}
	public Employee () {
	}//Ĭ�Ϲ�����
	
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
		//ֱ�ӵıȽ����������Ƿ���ȫ��ͬ
		if (otherObject == null) return false;
		//����һ����null��ز����
		if(getClass() != otherObject.getClass()) return false;
		//������������඼��һ���ز����getClass���ض�����������
		Employee other = (Employee) otherObject;
		//���е�ǿ������ת����һ���Ļ�˵��������������ͬһ���༴Employee�����ǿ��ת���������
		return Objects.equals (name,other.name) && salary == other.salary && Objects.equals (hireDay,other.hireDay);
	}
	public int hashCode () {
		return Objects.hash(name,salary,hireDay);
		//�ض��峬��objects�е�hashcode��������Ϊ��ͬ�Ķ���Ӧ�÷�����ͬ��ɢ����
	}
	public String toString () {
		return getClass().getName() + "[ name = "+name+" salary = "+salary+" hireDay = "+hireDay+" ]";
		//Ӧ��Ϊÿһ���Զ�������ض���equals��hashcode��toString����
	}
}
