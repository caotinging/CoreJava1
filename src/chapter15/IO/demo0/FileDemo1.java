package chapter15.IO.demo0;

import java.io.File;

/**
 * File��Ĺ��췽�� ����������ʽ
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
	 *  ͨ��������·�����ַ���ת��Ϊ����·����������һ���� File ʵ����
	 */
	public static void fun_1() {
		File file = new File("G:\\demo");
		System.out.println(file);
	}
	
	/*
	 * File(String parent,String child)
	 *  ����·��,�����ַ�����·��,�ַ�����·��
	 *  �ô�: ����������·������·��
	 */
	public static void fun_2() {
		File file = new File("G:", "demo");
		System.out.println(file);
	}
	
	/*
	 * File(File parent,String child)
	 *  ����·��,����File���͸�·��,�ַ�����·��
	 *  �ô�: ��·����File����,��·������ֱ�ӵ���File�෽��
	 */
	public static void fun_3() {
		File parent = new File("G:");
		File file = new File(parent, "demo");
		System.out.println(file);
	}
}
