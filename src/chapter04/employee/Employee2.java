package chapter04.employee;

import java.util.Random;

//�ţ�constructorTest�Ĳ����
/*
 * ���������ʵ�����ʼ��˳����OneNote Java���ʵ����˳������ϸ����
 */

class Employee2 {
private static int nextId;//��һ������ID
private String name = "";//��Ա����
private double salary;//��Աнˮ
private int id;//��ԱID

static{
	Random generator = new Random();
	nextId = generator.nextInt(10000);
}
{
	id = nextId;
	nextId++;
	System.out.println("id = "+id+"\nnextId = "+nextId);
}

public Employee2(String name,double salary) {
	this.name = name;
	this.salary = salary;
	System.out.println("dadada nextId = "+nextId);
}
public Employee2(double salary) {
	this("Employee #"+nextId,salary);//������һ�������������ظ�
	System.out.println("lalala naxtId = "+nextId);
}
public Employee2() {
	//ʵ���򶼱�Ĭ�ϳ�ʼ��
}

public String getName() {
	return name;
}
public double getSalary() {
	return salary;
}
public int getId() {
	return id;
}
}
