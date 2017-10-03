package chapter15.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 4.编写一个类A，增加一个实例方法showString,用于打印一条字符串，
	在编写一个类TestA 用键盘输入一个字符串，该字符串就是类A的全名，使用反射机制创建该类的对象，
	并调用该对象中的方法showString
	
	chapter15.IO.demo8.StuInfo
 * @author caoting
 */

public class ReflectDemo4 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String className = in.nextLine();
		
		Class<?> c1 = Class.forName(className);
		Constructor<?> con = c1.getConstructor(int.class, String.class, String.class, double.class);
		Object object = con.newInstance(199, "小红", "仁和医学院", 99.9);
		
		Method m1 = c1.getDeclaredMethod("toString");
		m1.invoke(object);
		
		System.out.println(object);
		in.close();
	}
}
