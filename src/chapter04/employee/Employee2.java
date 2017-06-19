package chapter04.employee;

import java.util.Random;

//嗯，constructorTest的补充吧
/*
 * 关于这里的实例域初始化顺序在OneNote Java类的实例化顺序有详细解释
 */

class Employee2 {
private static int nextId;//下一个可用ID
private String name = "";//雇员名字
private double salary;//雇员薪水
private int id;//雇员ID

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
	this("Employee #"+nextId,salary);//调用上一个构造器避免重复
	System.out.println("lalala naxtId = "+nextId);
}
public Employee2() {
	//实例域都被默认初始化
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
