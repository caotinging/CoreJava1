package chapter15.IO.demo0;

import java.io.File;

/**
 * File类的构造方法 三种重载形式
 * @author caoting
 *
 */

public class FileDemo1 {
	public static void main(String[] args) {
		fun_1();
		System.out.println();
		fun_2();
		System.out.println();
		fun_3();
	}
	
	/*
	 *  File(String pathname)
	 *  通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
	 */
	public static void fun_1() {
		File file = new File("G:\\demo");
		System.out.println(file);
	}
	
	/*
	 * File(String parent,String child)
	 *  传递路径,传递字符串父路径,字符串子路径
	 *  好处: 单独操作父路径和子路径
	 */
	public static void fun_2() {
		File file = new File("G:", "demo");
		System.out.println(file);
	}
	
	/*
	 * File(File parent,String child)
	 *  传递路径,传递File类型父路径,字符串子路径
	 *  好处: 父路径是File类型,父路径可以直接调用File类方法
	 */
	public static void fun_3() {
		File parent = new File("G:");
		File file = new File(parent, "demo");
		System.out.println(file);
	}
}
