package chapter15.IO.demo0;

import java.io.File;

import org.junit.Test;

/**
 * File类的获取功能
 * @author caoting
 *
 */

public class FileDemo3 {
	
	/*
	 * File类的获取功能
	 * String getName()
	 * 返回由此抽象路径名表示的文件或目录的名称。该名称是路径名名称序列中的最后一个名称
	 * 即路径中最后部分的名字
	 */
	@Test
	public void fun_1() {
		File file = new File("G:\\demo\\demo1");
		String name = file.getName();
		System.out.println(name);
	}
	
	/*
	 * File的获取功能
	 *  long length() 返回由此抽象路径名表示的文件的字节数。 
	 *  如果路径表示一个文件夹 则是文件夹中所有文件字节数总和（不确定的值）
	 */
	@Test
	public void fun_3() {
		File file = new File("G:\\demo\\demo1\\b.txt");
		long len = file.length();
		System.out.println(len);
	}
	
	/*
	 * File类获取功能
	 *  File getAbsoluteFile() 返回此抽象路径名的绝对路径名形式。返回File对象 
	 *  String getAbsolutePath() 如果此抽象路径名已经是绝对路径名，
	 *  则返回该路径名字符串，这与 getPath() 方法一样  返回String对象
	 *  MyEclipse环境中,如果写的是一个相对路径,绝对位置工程根目录
	 */
	@Test
	public void fun_4() {
		File file1 = new File("G:\\demo");
		File abFile = file1.getAbsoluteFile();
		System.out.println(abFile);
		
		File file2 = new File("demo");
		String abString = file2.getAbsolutePath();
		System.out.println(abString);
		/*
		 * 运行结果：
		 * G:\demo
		 * D:\javawork\Myeclipse\JavaChapter\demo
		 */
	}
	
	/*
	 * File类的获取功能
	 *  String getParent() 返回此抽象路径名父目录的路径名字符串；
	 *  File getParentFile() 返回此抽象路径名父目录的抽象路径名 
	 *  如果此路径名没有指定父目录（盘符没有父目录），则均返回 null。
	 */
	@Test
	public void fun_5() {
		File file = new File("G:\\demo\\demo1\\b.java");
		String parentString = file.getParent();
		System.out.println(parentString);
	}
}
