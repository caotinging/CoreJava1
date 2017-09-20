package chapter15.IO.demo0;

import java.io.File;

import org.junit.Test;

/**
 * File��Ļ�ȡ����
 * @author caoting
 *
 */

public class FileDemo3 {
	
	/*
	 * File��Ļ�ȡ����
	 * String getName()
	 * �����ɴ˳���·������ʾ���ļ���Ŀ¼�����ơ���������·�������������е����һ������
	 * ��·������󲿷ֵ�����
	 */
	@Test
	public void fun_1() {
		File file = new File("G:\\demo\\demo1");
		String name = file.getName();
		System.out.println(name);
	}
	
	/*
	 * File�Ļ�ȡ����
	 *  long length() �����ɴ˳���·������ʾ���ļ����ֽ����� 
	 *  ���·����ʾһ���ļ��� �����ļ����������ļ��ֽ����ܺͣ���ȷ����ֵ��
	 */
	@Test
	public void fun_3() {
		File file = new File("G:\\demo\\demo1\\b.txt");
		long len = file.length();
		System.out.println(len);
	}
	
	/*
	 * File���ȡ����
	 *  File getAbsoluteFile() ���ش˳���·�����ľ���·������ʽ������File���� 
	 *  String getAbsolutePath() ����˳���·�����Ѿ��Ǿ���·������
	 *  �򷵻ظ�·�����ַ��������� getPath() ����һ��  ����String����
	 *  MyEclipse������,���д����һ�����·��,����λ�ù��̸�Ŀ¼
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
		 * ���н����
		 * G:\demo
		 * D:\javawork\Myeclipse\JavaChapter\demo
		 */
	}
	
	/*
	 * File��Ļ�ȡ����
	 *  String getParent() ���ش˳���·������Ŀ¼��·�����ַ�����
	 *  File getParentFile() ���ش˳���·������Ŀ¼�ĳ���·���� 
	 *  �����·����û��ָ����Ŀ¼���̷�û�и�Ŀ¼����������� null��
	 */
	@Test
	public void fun_5() {
		File file = new File("G:\\demo\\demo1\\b.java");
		String parentString = file.getParent();
		System.out.println(parentString);
	}
}
