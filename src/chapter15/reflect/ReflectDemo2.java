package chapter15.reflect;

import java.lang.reflect.Constructor;

/**
 * 2.用反射去创建一个对象，有2种方式，尽量用代码去体现
 * @author caoting
 */

public class ReflectDemo2 {
	public static void main(String[] args) throws Exception {
		Class<?> c1 = Class.forName("chapter15.IO.demo7.StuInfo");
		
		Object obj1 = c1.newInstance();
		
		Constructor<?> con = c1.getConstructor(int.class, String.class, String.class, double.class);
		Object obj2 = con.newInstance(80, "二狗子", "三年二班", 66.6);
		
		System.out.println(obj1+"\n"+obj2);
	}
}
