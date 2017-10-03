package chapter15.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 6.����һ����׼��JavaBean������Person����������name��age��
	ʹ�÷���ķ�ʽ����һ��ʵ�������ù��캯����ʼ��name��age��ʹ�÷��䷽ʽ����setName���������ƽ������ã�
	��ʹ��setAge����ֱ��ʹ�÷��䷽ʽ��age��ֵ��
 * @author caoting
 */

public class ReflectDemo6 {
	public static void main(String[] args) throws Exception {
		Class<?> person = Class.forName("chapter15.reflect.Person");
		
		Object obj1 = person.newInstance();
		Object obj2 = person.getConstructor(String.class, int.class).newInstance("С��", 22);
		
		Method method = person.getMethod("setName", String.class);
		method.invoke(obj1, "��ˮ");
		
		Field field = person.getDeclaredField("age");
		field.setAccessible(true);
		field.set(obj1, 23);
		
		System.out.println(obj1+"\n"+obj2);
	}
}
