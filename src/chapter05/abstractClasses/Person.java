package chapter05.abstractClasses;

/*
 * ���ǳ���ĳ��࣬student��employee copy������������
 * @version 1.7.0_80 2017/3/26
 * @author CaoTing
 */

abstract class Person {
	private String name = "";
	
	public Person (String name) {
		this.name = name;
	}
	public abstract String getDestricption ();//���󷽷������������о��嶨��
	public String getName () {
		return name;
	}
}
