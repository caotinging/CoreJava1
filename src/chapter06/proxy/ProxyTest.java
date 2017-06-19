package chapter06.proxy;

import java.lang.reflect.*;
import java.util.*;

/**
 * This program demonstrates the use of proxies
 * @version 1.7.0_80 2017/4/10
 * @author caoting
 */
public class ProxyTest {
	public static void main(String[] args) {
		Object[] elements = new Object[100];
		//fill elements with proxies for the integers 1...100
		for (int i = 0; i < elements.length; i++) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[] { Comparable.class }, handler);
			elements[i] = proxy;
		}
		
		//construct a random integer
		Integer key = new Random().nextInt(elements.length) + 1;
		//search for the key
		int result = Arrays.binarySearch(elements, key);
		//print match if found
		if (result >= 0) System.out.println("λ����:"+ elements[result]);
		//element�е�Ԫ�ض��Ǵ������ ���������õķ��������õ�invoke
	}
}

/**
 * An invocation handler that prints out the method name and parameters, 
 * then invokes the original method
 */
class TraceHandler implements InvocationHandler {
	private Object target;
	
	/**
	 * Constructs a traceHandler
	 * @param t the implicit parameter of the method call
	 */
	public TraceHandler(Object t) {
		target = t;
	}
	
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		//print implicit argument
		System.out.print(target);
		//print method name
		System.out.print("." + m.getName() + "(");
		//print explicit arguments
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1) System.out.print(", ");
			}
		}
		System.out.println(")");
		//invoke actual method
		return m.invoke(target, args);
	}
}