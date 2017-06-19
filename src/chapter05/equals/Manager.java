package chapter05.equals;

import java.util.Objects;

/*
 * 这个类是Employee的子类
 * @version 1.7 2017/3/24
 * @author CaoTing
 */

public class Manager extends Employee {
	private double bonus = 0.0;
	//所以Manager类的对象都是有四个实例的name，salary，hireDay，bonus（奖金，经理才有普通雇员没有）
	
	public Manager (String name,double salary,int year,int month,int day) {
		super(name,salary,year,month,day);
	}
	public Manager () {
		//默认构造器
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double getSalary() {
		double salary = bonus + super.getSalary();
		return salary;
	}
	public boolean equals (Object otherObject) {
		if (!super.equals(otherObject)) return false;
		//先执行超类的equals方法 如果检测失败两个对象就不可能相等
		Manager other = (Manager) otherObject;
		return bonus == other.bonus;
	}
	//以下用于检测getclass方法返回值超类与其子类是否相等的问题
	//下面输出结果是不相等
	/*public static void main (String[] args) {
		Manager m = new Manager("Herry",9000,1998,5,15);
		m.setBonus(50);
		Employee e = new Employee("Marry",8000,1997,5,15);
		if (m.getClass() == e.getClass()) System.out.println("子类父类的getclass方法返回相等");
		else System.out.println("子类超类的getclass方法返回不相等");
	}*/
	public int hashCode () {
		return super.hashCode()+Objects.hash(bonus);
	}
	public String toString () {
		return super.toString()+"[ bonus = "+bonus+" ]";
	}
}
