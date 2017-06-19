package chapter05.abstractClasses;


/*
 * Person的子类，number表示学号
 * @version 1.7.0_80 2017/3/26
 * @author CaoTing
 */

class Student extends Person {
	private double number = 0;
	
	public Student (String name,double number) {
		super(name);
		this.number = number;
	}
	public String getDestricption () {
		return "Student: \nname = "+this.getName()+" number = "+this.number;
	}
	public double getNumber () {
		return number;
	}
}
