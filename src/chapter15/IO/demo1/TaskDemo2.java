package chapter15.IO.demo1;

import java.io.File;
import java.util.Scanner;

/**
 * �Ӽ��̽���һ���ļ���·��,ͳ�Ƹ��ļ��д�С
 * @author caoting
 *
 */

public class TaskDemo2 {
	
	public static void main(String[] args) {
		System.out.println("������Ҫ�����С��·��");
		Scanner in = new Scanner(System.in);
		//�Ӽ��̽���һ���ļ�·��
		String srcString = in.next();
		//��·�����ݸ������ļ���С�ķ���
		getSize(srcString);
		//�ر�������
		in.close();
	}
	//�������ڱ����ļ��д�С��ȫ�ֱ���
	static long sum;
	
	//���������ļ��д�С�ķ���
	public static void getSize(String s) {
		File file = new File(s);
		//�ж�·���Ƿ�����Լ�s�Ƿ�Ϊ��
		if(file == null || !file.exists()) {
			System.out.println("�ļ�·�������ڣ�");
			return;
		}
		if(!file.isDirectory()) 
			System.out.println("�ļ���СΪ��" + file.length());
		else {
			//�ж��ļ����Ƿ�Ϊ��
			File[] files = file.listFiles();
			if(files.length == 0) {
				System.out.println("�ļ���Ϊ�գ�");
				return;
			}
			//���ñ���Ŀ¼����
			dirs(file);
			System.out.println("�ļ��д�СΪ��" + sum);
		}
	}
	
	//�������������ļ���С�ķ���
	public static void dirs(File pathname) {
		if(!pathname.isDirectory()) {
			sum += pathname.length();
			return;
		}
		else {
			File[] files = pathname.listFiles();
			if(files.length == 0)
				return;
			for(File f: files) {
				dirs(f);
			}
		}
	}
}
