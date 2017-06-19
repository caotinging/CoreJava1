package chapter12.genericReflection;

import java.lang.reflect.*;
import java.util.*;

/**
 * @version 1.10 2017/5/19
 * @author caoting
 */

public class GenericReflectionTest {
	public static void main(String[] args) {
		//从命令行参数或者用户输入读取类名
		String name;
		if(args.length > 0) name = args[0];
		else {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (e.g. java.util.Collections): ");
			name = in.next();
			//从有效字符开始 到空白、Tab、Enter字符结束 nextLine()方法只以Enter方法结束
		}
		
		try {
			Class<?> cl = Class.forName(name);
//			返回与带有给定字符串名的类或接口相关联的 Class 对象 .调用 forName("X") 将导致命名为 X 的类被初始化
			
			printClass(cl);
			for(Method m : cl.getDeclaredMethods())
				printMethod(m);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void printClass(Class<?> cl) {
		System.out.print(cl);
		System.out.print(" ");
		printTypes(cl.getTypeParameters(), "<", ",", ">", true);
//		如果这个类被声明为泛型类型 则返回泛型类型变量 否则返回长度为0的数组
		Type sc = cl.getGenericSuperclass();
		if(sc != null) {
			System.out.print(" 2extends ");
			printType(sc, false);
		}
		printTypes(cl.getGenericInterfaces(), " implements ", ",", "", false);
		System.out.println();
	}
	
	public static void printMethod(Method m) {
		String name = m.getName();
		System.out.print(Modifier.toString(m.getModifiers()));
		System.out.print(" ");
		printTypes(m.getTypeParameters(), "<", ",", ">", true);
		
		printType(m.getGenericReturnType(), false);
		System.out.print(" ");
		System.out.print(name);
		System.out.print("(");
		printTypes(m.getGenericParameterTypes(), "", ",", "", false);
		System.out.println(")");
	}
	
	public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
		if(pre.equals(" extends ") && Arrays.equals(types, new Type[] { Object.class })) return;
		if(types.length > 0) System.out.print(pre);
		for(int i = 0; i < types.length; i++) {
			if(i > 0) System.out.print(sep);
			printType(types[i], isDefinition);
		}
		if(types.length > 0) System.out.print(suf);
	}
	
	public static void printType(Type type, boolean isDefinition) {
		if(type instanceof Class) {
			Class<?> t = (Class<?>) type;
			System.out.print(t.getName());
		}
		
		else if(type instanceof TypeVariable) {
			TypeVariable<?> t = (TypeVariable<?>) type;
			System.out.print(t.getName());
			if(isDefinition)
				printTypes(t.getBounds(), " extends ", " & ", "", false);
		}
		
		else if(type instanceof WildcardType) {
			WildcardType t = (WildcardType) type;
			System.out.print("?");
			printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
			printTypes(t.getLowerBounds(), " super ", " & ", "", false);
		}
		
		else if(type instanceof ParameterizedType) {
			ParameterizedType t = (ParameterizedType) type;
			Type owner = t.getOwnerType();
			if(owner != null) {
				printType(owner, false);
				System.out.print(".");
			}
			printType(t.getRawType(), false);
			printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
		}
		
		else if (type instanceof GenericArrayType) {
			GenericArrayType t = (GenericArrayType) type;
			System.out.print(" ");
			printType(t.getGenericComponentType(), isDefinition);
			System.out.print("[]");
		}
	}
}
