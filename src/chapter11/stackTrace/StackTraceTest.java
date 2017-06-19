package chapter11.stackTrace;

import java.util.*;

/**
 * 这个类通过堆栈追踪打印堆栈信息
 * @version 1.8 2017/5/13
 * @author caoting
 */
public class StackTraceTest { 
	
	public static int factorial(int n) {
		System.out.println("factorial(" + n +") :");
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		
		for(StackTraceElement f : frames) 
			System.out.println(f);
		
		int r = 0;
		if(n <= 1 ) r = 1;
		else
			r = n * factorial(n - 1);
		System.out.println("return " + r);
		return r;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n :");
		int n = in.nextInt();
		System.out.println("谢谢合作！");
		
		factorial(n);
		
		in.close();
	}
}
