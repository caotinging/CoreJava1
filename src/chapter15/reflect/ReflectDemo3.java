package chapter15.reflect;

import java.lang.reflect.Method;

/**
 * 3. 编写一个类，增加一个实例方法用于打印一条字符串。
 *	    并使用反射手段创建该类的对象， 并调用该对象中的方法。
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
		m2.setAccessible(true);//取消私有权限设置
		m2.invoke(obj);
	}
}
