package chapter15.reflect;

import java.lang.reflect.Field;

/**
 * 5. дһ���������˷����ɽ�obj���������Ե�ֵ����Ϊvalue.   
	public void setProperty(Object obj, String name, Object value){ }
 * @author caoting
 */

public class ReflectDemo5 {
	private static Class<?> c1;
	
	public static void main(String[] args) throws Exception {
		c1 = Class.forName("chapter15.IO.demo8.StuInfo");
		
		Object obj = c1.newInstance();
		setProperty(obj, "sname", "��ˮ");
	}
	
	public static void setProperty(Object obj, String name, Object value) throws Exception {
		Field field = c1.getDeclaredField(name);
		
		field.setAccessible(true);
		field.set(obj, value);
		System.out.println(obj);
	}
}
