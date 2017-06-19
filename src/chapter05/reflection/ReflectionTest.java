package chapter05.reflection;

import java.util.*;
import java.lang.reflect.*;

/**
 * This program uses reflection to print all features of a class
 * @version 1.7.0_80 2017/3/31
 * @author CaoTing
 */

public class ReflectionTest {
	public static void main (String[] args) {
		//read class name from command line args or user input
		//上面注释的翻译是从命令行读取类名或者由用户输入
		String name;
		if (args.length > 0)
			name = args[0];
		else {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("Enter a class name (e.g. java.util.Date): ");
			name = in.next();
		}
		
		try {
			//print class name and super class name
			Class<?> cl = Class.forName(name);
			Class<?> supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers+" ");
			System.out.print("class "+name);
			if (supercl != null && supercl != Object.class)
				System.out.print(" extends "+supercl.getName());
			
			System.out.print("\n{\n");
			printConstructors(cl);//打印所有构造器
			System.out.println();
			printMethods (cl);//打印所有方法
			System.out.println();
			printFields (cl);//打印所有域
			System.out.println("}");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
}
/**
 * Prints all constructors of a class
 * @param cl a class
 */
public static void printConstructors (Class<?> cl){
	Constructor<?>[] constructors = cl.getDeclaredConstructors();
	//用于反射类的所有构造方法包括私有的
	for (Constructor<?> c : constructors) {
		String name = c.getName();
		System.out.print("   ");
		String modifiers = Modifier.toString(c.getModifiers());
		if (modifiers.length() > 0)
			System.out.print(modifiers + " ");
		System.out.print(name + "(");
		
		//打印参数类型
		Class<?>[] paramTypes = c.getParameterTypes();
		for (int j = 0;j < paramTypes.length;j++) {
			if(j > 0)
				System.out.print(" , ");
			System.out.print(paramTypes[j].getName());
		}
		System.out.println(");");
	}
}

/**
 * Prints all methods of a class
 * @param cl a class
 */
public static void printMethods(Class<?> cl) {
	Method[] methods = cl.getDeclaredMethods();
	for (Method m : methods) {
		Class<?> retType = m.getReturnType();
		//获得方法的名字
		String name = m.getName();
		System.out.print("   ");
		//打印修饰符：返回类型和方法的名字
		String modifiers = Modifier.toString(m.getModifiers());
		if (modifiers.length() > 0)
			System.out.print(modifiers + " ");
		System.out.print(retType.getName() + " " +name+ "(");
		
		//打印参数类型
		Class<?>[] paramTypes = m.getParameterTypes();
		for (int j = 0 ; j < paramTypes.length; j++) {
			if (j > 0)
				System.out.print(" , ");
			System.out.print(paramTypes[j].getName());
		}
		System.out.println(");");
	}
}

/**
 * Prints all fields of a class
 * @param cl a class
 */
public static void printFields(Class<?> cl) {
	Field[] fields = cl.getDeclaredFields();
	
	for (Field f : fields) {
		Class<?> type = f.getType();
		String name = f.getName();
		System.out.print("   ");
		String modifiers = Modifier.toString(f.getModifiers());
		if (modifiers.length() > 0)
			System.out.print(modifiers+" ");
		System.out.println(type.getName()+" " + name + ";");
	}
}
}