package chapter03.firstSample;

/*
 * ʱ��:2017.3.23
 * �������chapter04���е�packagetestҪ���õ���
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
		//GregorianCalendar����0��ʾһ��
		hireDay = calendar.getTime();
	}
	public Employee(String name,double salary) {
		this(name,salary,Today.get(Calendar.YEAR),Today.get(Calendar.MONTH),Today.get(Calendar.DAY_OF_MONTH));
	}
	/*
	 * ��ʽ���ù��캯��ʱ��������ʵ���ֶ� ����Ϊthis��ִ��˳������ʾ���ĳ�ʼ��
	 * �������˳���ڰ�chapter04����Employee2����֤ onenote javaʵ����˳�������
	 * �������˳���ԭ����this��ʽ���ù��캯��ʱ������ʵ���ֶ�ֻ���þ�̬�ֶ�
	 * ��Ϊ����ʱʵ���ֶλ�û�б���ʼ��������̬�ֶ���װ�س���ʱ���Ѿ������ڴ�ռ���
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
