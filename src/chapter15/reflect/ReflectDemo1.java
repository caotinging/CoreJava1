package chapter15.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 1.ArrayList<Integer> list = new ArrayList<Integer>(); 
 *	�������ΪInteger��ArrayList�д��һ��String���͵Ķ���
 * @author caoting
 */

public class ReflectDemo1 {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Class<?> c1 = Class.forName("java.util.ArrayList");
		Method method = c1.getDeclaredMethod("add", Object.class);
		
		method.invoke(list, "string");
		method.invoke(list, "add��������ɹ���");
		method.invoke(list, 555);
		method.invoke(list, "haha");
		
		System.out.println(list);
		for(Object i: list) {
			System.out.println(i);
		}
	}
}
