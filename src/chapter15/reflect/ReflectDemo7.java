package chapter15.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 7.(1)写一个Properties格式的配置文件，配置类的完整名称。
	 (2) 写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，
	 (3)用反射 的方式运行方法。
 * @author caoting
 *
 */

public class ReflectDemo7 {
	public static void main(String[] args) throws Exception {
		//相对于src的路径 class.getResourceStream(String name)是相对于class包的路径
		InputStream in = ReflectDemo7.class.getClassLoader().getResourceAsStream("chapter15/reflect/config.properties");
		
		Properties properties = new Properties();
		properties.load(in);
		
		String className = properties.getProperty("className");
		String methodName = properties.getProperty("Method");
		
		System.out.println(className+"  "+methodName);
		
		Class<?> c1 = Class.forName(className);
		Method method = c1.getDeclaredMethod(methodName);
		
		method.invoke(c1.newInstance());
	}
}
