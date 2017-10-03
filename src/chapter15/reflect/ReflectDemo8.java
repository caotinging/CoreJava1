package chapter15.reflect;

import java.lang.reflect.Field;

/**
 * 8. 写一个方法，此方法可以获取obj对象中名为propertyName的属性的值   
	public Object getProperty(Object obj, String propertyName, Object value) {}
 * @author caoting
 *
 */

public class ReflectDemo8 {
	public static void main(String[] args) throws Exception {
		Person person = new Person("秋水", 23);
		System.out.println(getProperty(person, "name"));
	}
	
	public static Object getProperty(Object obj, String propertyName) throws Exception {
		Class<?> c1 = obj.getClass();
		Field field = c1.getDeclaredField(propertyName);
		field.setAccessible(true);
		
		Object objPro = field.get(obj);
		
		return objPro;
	}
}
