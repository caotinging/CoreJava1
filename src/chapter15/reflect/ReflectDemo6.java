package chapter15.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 6.定义一个标准的JavaBean，名叫Person，包含属性name、age。
	使用反射的方式创建一个实例、调用构造函数初始化name、age，使用反射方式调用setName方法对名称进行设置，
	不使用setAge方法直接使用反射方式对age赋值。
 * @author caoting
 */

public class ReflectDemo6 {
	public static void main(String[] args) throws Exception {
		Class<?> person = Class.forName("chapter15.reflect.Person");
		
		Object obj1 = person.newInstance();
		Object obj2 = person.getConstructor(String.class, int.class).newInstance("小红", 22);
		
		Method method = person.getMethod("setName", String.class);
		method.invoke(obj1, "秋水");
		
		Field field = person.getDeclaredField("age");
		field.setAccessible(true);
		field.set(obj1, 23);
		
		System.out.println(obj1+"\n"+obj2);
	}
}
