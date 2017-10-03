package chapter15.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 4.��дһ����A������һ��ʵ������showString,���ڴ�ӡһ���ַ�����
	�ڱ�дһ����TestA �ü�������һ���ַ��������ַ���������A��ȫ����ʹ�÷�����ƴ�������Ķ���
	�����øö����еķ���showString
	
	chapter15.IO.demo8.StuInfo
 * @author caoting
 */

public class ReflectDemo4 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String className = in.nextLine();
		
		Class<?> c1 = Class.forName(className);
		Constructor<?> con = c1.getConstructor(int.class, String.class, String.class, double.class);
		Object object = con.newInstance(199, "С��", "�ʺ�ҽѧԺ", 99.9);
		
		Method m1 = c1.getDeclaredMethod("toString");
		m1.invoke(object);
		
		System.out.println(object);
		in.close();
	}
}
