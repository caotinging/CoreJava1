package chapter15.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 7.(1)дһ��Properties��ʽ�������ļ�����������������ơ�
	 (2) дһ�����򣬶�ȡ���Properties�����ļ����������������Ʋ���������࣬
	 (3)�÷��� �ķ�ʽ���з�����
 * @author caoting
 *
 */

public class ReflectDemo7 {
	public static void main(String[] args) throws Exception {
		//�����src��·�� class.getResourceStream(String name)�������class����·��
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
