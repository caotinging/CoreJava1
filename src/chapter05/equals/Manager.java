package chapter05.equals;

import java.util.Objects;

/*
 * �������Employee������
 * @version 1.7 2017/3/24
 * @author CaoTing
 */

public class Manager extends Employee {
	private double bonus = 0.0;
	//����Manager��Ķ��������ĸ�ʵ����name��salary��hireDay��bonus�����𣬾��������ͨ��Աû�У�
	
	public Manager (String name,double salary,int year,int month,int day) {
		super(name,salary,year,month,day);
	}
	public Manager () {
		//Ĭ�Ϲ�����
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
		//��ִ�г����equals���� ������ʧ����������Ͳ��������
		Manager other = (Manager) otherObject;
		return bonus == other.bonus;
	}
	//�������ڼ��getclass��������ֵ�������������Ƿ���ȵ�����
	//�����������ǲ����
	/*public static void main (String[] args) {
		Manager m = new Manager("Herry",9000,1998,5,15);
		m.setBonus(50);
		Employee e = new Employee("Marry",8000,1997,5,15);
		if (m.getClass() == e.getClass()) System.out.println("���ุ���getclass�����������");
		else System.out.println("���೬���getclass�������ز����");
	}*/
	public int hashCode () {
		return super.hashCode()+Objects.hash(bonus);
	}
	public String toString () {
		return super.toString()+"[ bonus = "+bonus+" ]";
	}
}
