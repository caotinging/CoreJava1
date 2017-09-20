package chapter15.IO.demo0;

import java.io.File;

import org.junit.Test;

/**
 * File类的判断功能
 * @author caoting
 *
 */

public class FileDemo4 {
	/*
	 * File的判断功能
	 * boolean exists() 判断File构造方法中的封装路径是否存在
	 */
	@Test
	public void fun_1() {
		File aFile = new File("G:\\demo\\demo3");
		File bFile = new File("G:\\demo\\demo1");
		
		boolean b1 = aFile.exists();
		boolean b2 = bFile.exists();
		
		System.out.println(b1 + " " + b2);
	}
	
	/*
	 * File的判断功能
	 *  boolean isAbsolute() 测试此抽象路径名是否为绝对路径名。 
	 *  boolean isDirectory() 测试此抽象路径名表示的文件是否是一个目录。 
	 *  boolean isFile() 测试此抽象路径名表示的文件是否是一个标准文件。 
	 */
	@Test
	public void fun_2() {
		File aFile = new File("G:\\demo\\demo1");
		File bFile = new File("G:\\demo\\demo1\\c.java");
		File cFile = new File("b.java");
		
		System.out.println(aFile.isDirectory());
		System.out.println(bFile.isFile());
		System.out.println(cFile.isAbsolute());
	}
}
