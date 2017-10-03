package chapter15.reflect;

import java.lang.reflect.Method;

/**
 * 3. ��дһ���࣬����һ��ʵ���������ڴ�ӡһ���ַ�����
 *	    ��ʹ�÷����ֶδ�������Ķ��� �����øö����еķ�����
 * @author caoting
 *
 */

public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		Class<?> c1 = Class.forName("chapter15.IO.demo8.StuInfo");
		
		Object obj = c1.newInstance();
		/*Method[] methods = c1.getDeclaredMethods();
		
		for(Method m: methods) {
			System.out.println(m);
		}*/
		
		Method m1 = c1.getDeclaredMethod("eat", int.class);
		m1.invoke(obj, 999);
		
		Method m2 = c1.getDeclaredMethod("eat");
		m2.setAccessible(true);//ȡ��˽��Ȩ������
		m2.invoke(obj);
	}
}
