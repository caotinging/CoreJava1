package chapter15.IO.demo5;

import java.io.Serializable;
import java.util.Comparator;

/**
 * ����ѧ����,��������(String name),�Ա�(String gender),����(int age)��������,���ɿղ��вι���,set��get����,toString����
 * @author caoting
 *
 */

public class StudentInfo implements Serializable, Comparator<StudentInfo> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String sex;
	private int age;
	
	public StudentInfo() {}

	public StudentInfo(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "StudentInfo [name=" + name + ", sex=" + sex + ", age=" + age
				+ "]";
	}

	public int compare(StudentInfo o1, StudentInfo o2) {
		int age1 = o1.getAge();
		int age2 = o2.getAge();
		if(age1 > age2) {
			return 1;
		}else if(age1 < age2) {
			return -1;
		} else
			return 0;
	}
	
	//��д�ж���ȵķ���
	public boolean equals(Object obj) {
		StudentInfo stu = new StudentInfo();
		if(obj.getClass() != stu.getClass())
			return false;
		else{
			stu = (StudentInfo) obj;
		}
		if(!this.name.equals(stu.getName()))
			return false;
		if(!this.sex.equals(stu.getSex()))
			return false;
		if(this.age != stu.getAge())
			return false;
		return true;
	}
}
