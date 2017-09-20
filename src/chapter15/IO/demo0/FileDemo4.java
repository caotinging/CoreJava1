package chapter15.IO.demo0;

import java.io.File;

import org.junit.Test;

/**
 * File����жϹ���
 * @author caoting
 *
 */

public class FileDemo4 {
	/*
	 * File���жϹ���
	 * boolean exists() �ж�File���췽���еķ�װ·���Ƿ����
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
	 * File���жϹ���
	 *  boolean isAbsolute() ���Դ˳���·�����Ƿ�Ϊ����·������ 
	 *  boolean isDirectory() ���Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼�� 
	 *  boolean isFile() ���Դ˳���·������ʾ���ļ��Ƿ���һ����׼�ļ��� 
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
