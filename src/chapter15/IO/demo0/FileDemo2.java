package chapter15.IO.demo0;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * File��Ĵ�����ɾ�����ܣ������ļ�����Ŀ¼��
 * @author caoting
 *
 */

public class FileDemo2 {
	
	/*
	 * File�����ļ��й���
	 *  boolean mkdir() �����˳���·����ָ����Ŀ¼�� ���ܴ�������Ŀ¼  ����·�������ڵ�Ŀ¼
	 *  boolean mkdirs() �����˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼�� 
	 * ������·����File�Ĺ��췽���и���
	 */
	@Test
	public void fun_1() {
		File file = new File("G:\\abc\\b.txt");
		boolean b = file.mkdirs();
//		�����Ķ���Ŀ¼��b.txtҲ��Ŀ¼
		System.out.println(b);
	}
	
	/*
	 * File�����ļ��Ĺ���
	 * boolean createNewFile()
	 * ���ҽ��������ھ��д˳���·����ָ�����Ƶ��ļ�ʱ��
	 * ���ɷֵش���һ���µĿ��ļ�������ļ��Ƿ���ڣ����������򴴽����ļ�
	 * ���ָ�����ļ������ڲ��ɹ��ش������򷵻� true�����ָ�����ļ��Ѿ����ڣ��򷵻� false 
	 */
	@Test
	public void fun_2() throws IOException {
		File file = new File("G:\\abc\\b.txt\\b.txt");
		boolean b = file.createNewFile();
		System.out.println(b);
	}
	
	/*
	 * File���ɾ������
	 * ɾ���˳���·������ʾ���ļ���Ŀ¼�������·������ʾһ��Ŀ¼�����Ŀ¼����Ϊ�ղ���ɾ��
	 * ɾ���������߻���վ��ֱ�Ӵ�Ӳ����ɾ��
	 * ɾ���з��գ����������
	 */
	@Test
	public void fun_3() {
		File file = new File("G:\\abc\\b.java");
		boolean b = file.delete();
		System.out.println(b);
	}
}
