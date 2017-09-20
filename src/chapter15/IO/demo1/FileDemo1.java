package chapter15.IO.demo1;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

import org.junit.Test;

/**
 * File遍历目录的功能
 * 1. String[] list()  String[] list(FilenameFilter filter) 
 * 2.  File[] listFiles()  File[] listFiles(FileFilter filter) 
 * @author caoting
 */

public class FileDemo1 {
	/*
	 * File类的获取功能
	 * String[] list()返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录
	 * 每个字符串是一个文件名，而不是一条完整路径。 
	 * 有参数的list方法是指：满足指定过滤器的文件和目录
	 */
	@Test
	public void fun_1() {
		File file = new File("G:");
		String[] fileStrings = file.list();
		System.out.println(fileStrings.length);
		
		for(String fileString: fileStrings) {
			System.out.println(fileString);
		}
		
		System.out.println("===============");
		
		String[] fileStrs = file.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".ttf");
			}
		});
		
		System.out.println(fileStrs.length);
		for(String str: fileStrs) {
			System.out.println(str);
		}
	}
	
	/*
	 *  File[] listFiles() 返回一个抽象路径名数组，
	 *  这些路径名表示此抽象路径名表示的目录中的文件。
	 *  File[] listFiles(FileFilter filter) 返回抽象路径名数组，
	 *   这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。 
	 */
	@Test
	public void fun_2() {
		File aFile = new File("G:");
		File[] aFiles = aFile.listFiles();
		
		System.out.println(aFiles.length);
		for(File f: aFiles) {
			System.out.println(f);
		}
		
		System.out.println("==============");
		
		File[] bFiles = aFile.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".ttf");
			}
		});
		System.out.println(bFiles.length);
		System.out.println(Arrays.toString(bFiles));
	}
	
	/*
	 *  File[] listRoots()列出可用的文件系统根（这是File的静态方法）
	 */
	@Test
	public void fun_3() {
//		获取系统中所有根目录（Windows系统下是盘符）
		File[] files = File.listRoots();
		System.out.println(Arrays.toString(files));
	}
}
