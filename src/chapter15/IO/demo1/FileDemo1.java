package chapter15.IO.demo1;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

import org.junit.Test;

/**
 * File����Ŀ¼�Ĺ���
 * 1. String[] list()  String[] list(FilenameFilter filter) 
 * 2.  File[] listFiles()  File[] listFiles(FileFilter filter) 
 * @author caoting
 */

public class FileDemo1 {
	/*
	 * File��Ļ�ȡ����
	 * String[] list()����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼�е��ļ���Ŀ¼
	 * ÿ���ַ�����һ���ļ�����������һ������·���� 
	 * �в�����list������ָ������ָ�����������ļ���Ŀ¼
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
	 *  File[] listFiles() ����һ������·�������飬
	 *  ��Щ·������ʾ�˳���·������ʾ��Ŀ¼�е��ļ���
	 *  File[] listFiles(FileFilter filter) ���س���·�������飬
	 *   ��Щ·������ʾ�˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼�� 
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
	 *  File[] listRoots()�г����õ��ļ�ϵͳ��������File�ľ�̬������
	 */
	@Test
	public void fun_3() {
//		��ȡϵͳ�����и�Ŀ¼��Windowsϵͳ�����̷���
		File[] files = File.listRoots();
		System.out.println(Arrays.toString(files));
	}
}
