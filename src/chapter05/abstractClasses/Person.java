package chapter05.abstractClasses;

/*
 * 这是抽象的超类，student和employee copy是这个类的子类
 * @version 1.7.0_80 2017/3/26
 * @author CaoTing
 */

abstract class Person {
	private String name = "";
	
	public Person (String name) {
		this.name = name;
	}
	public abstract String getDestricption ();//抽象方法，在子类中有具体定义
	public String getName () {
		return name;
	}
}
