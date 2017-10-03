package chapter15.reflect;

import java.lang.reflect.Field;

/**
 * 5. 写一个方法，此方法可将obj对象中属性的值设置为value.   
	public void setProperty(Object obj, String name, Object value){ }
 * @author caoting
 */

public class ReflectDemo5 {
	private static Class<?> c1;
	
	public static void main(String[] args) throws Exception {
		c1 = Class.forName("chapter15.IO.demo8.StuInfo");
		
		Object obj = c1.newInstance();
		setProperty(obj, "sname", "秋水");
	}
	
	public static void setProperty(Object obj, String name, Object value) throws Exception {
		Field field = c1.getDeclaredField(name);
		
		field.setAccessible(true);
		field.set(obj, value);
		System.out.println(obj);
	}
}
