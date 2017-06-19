package chapter05.reflection;

import chapter05.equals.Employee;

/*
 * this program is used to study reflection
 * @version 1.7.0_80 2017330
 * @author CaoTing
 */

public class ReflectiveClass {
	public static void main (String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Employee e1 = new Employee();
		//Class<? extends Employee> cl1 = e1.getClass();
		System.out.println(e1.getClass().getName()+"  "+e1.getName());
		//String className = "java.util.Date";
		//Class cl2 = Class.forName(className);
		//Class cl3 = Manager.class;
		
		//Object m = cl1.newInstance();
		//InstantiationException是实例化异常 IllegalAccessException时非法访问异常
		if(e1.getClass() == Employee.class)
			System.out.println("Double[].class.getName() = "+Double[].class.getName());
		String s = "java.util.Date";
		Object m = Class.forName(s).newInstance();
		System.out.println("m.getClass() = "+m.getClass().getName());
	}
}
