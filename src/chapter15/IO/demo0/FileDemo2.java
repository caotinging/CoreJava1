package chapter15.IO.demo0;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * File类的创建和删除功能（创建文件或者目录）
 * @author caoting
 *
 */

public class FileDemo2 {
	
	/*
	 * File创建文件夹功能
	 *  boolean mkdir() 创建此抽象路径名指定的目录。 不能创建多层的目录  即父路径不存在的目录
	 *  boolean mkdirs() 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。 
	 * 创建的路径在File的构造方法中给出
	 */
	@Test
	public void fun_1() {
		File file = new File("G:\\abc\\b.txt");
		boolean b = file.mkdirs();
//		创建的都是目录：b.txt也是目录
		System.out.println(b);
	}
	
	/*
	 * File创建文件的功能
	 * boolean createNewFile()
	 * 当且仅当不存在具有此抽象路径名指定名称的文件时，
	 * 不可分地创建一个新的空文件。检查文件是否存在，若不存在则创建该文件
	 * 如果指定的文件不存在并成功地创建，则返回 true；如果指定的文件已经存在，则返回 false 
	 */
	@Test
	public void fun_2() throws IOException {
		File file = new File("G:\\abc\\b.txt\\b.txt");
		boolean b = file.createNewFile();
		System.out.println(b);
	}
	
	/*
	 * File类的删除功能
	 * 删除此抽象路径名表示的文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除
	 * 删除方法不走回收站，直接从硬盘中删除
	 * 删除有风险，运行需谨慎
	 */
	@Test
	public void fun_3() {
		File file = new File("G:\\abc\\b.java");
		boolean b = file.delete();
		System.out.println(b);
	}
}
