package chapter15.IO.demo1;

import java.io.File;
import java.util.Scanner;

/**
 * �Ӽ��̽���һ���ļ���·��,���ļ����е������ļ��Լ��ļ��е����ְ��㼶��ӡ
 *	����:
 *	aaa���ļ���,������bbb.txt,ccc.txt,ddd.txt��Щ�ļ�,��eee�������ļ���,eee����fff.txt��ggg.txt,��ӡ���㼶��
 *	aaa
 *		bbb.txt
 *		ccc.txt
 *		ddd.txt	
 *		eee
 *			fff.txt
 *			ggg.txt
 * @author caoting
 *
 */

public class TaskDemo4 {
	public static void main(String[] args) {
		System.out.println("������Ҫ��ӡ���ļ���·����");
		//����һ��scanner������ռ�������
		Scanner in = new Scanner(System.in);
		String pathname = in.next();
		//���ô�ӡ����
		printDir(pathname);
		//�ر�������
		in.close();
	}
	
	//����һ�����㼶��ӡ�ķ���
	public static void printDir(String pathname) {
		if(pathname == null) {
			System.out.println("��Ч���ļ�·��");
			return;
		}
		File file = new File(pathname);
		if(!file.exists()) {
			System.out.println("��Ч���ļ�·��");
			return;
		}
		if(file.isFile()) {
			System.out.println(file.getName());
			return;
		}
		else {
			//�����Ŀ¼���õݹ鷽��
			printDirs(file);
		}
	}
	
	//����һ���ݹ����Ŀ¼�ķ���
	public static void printDirs(File file) {
		//�ж��ǲ����ļ���
		if(file.isDirectory()) {
			System.out.println(file.getName());
			//�ж��Ƿ�Ϊ��
			File[] files = file.listFiles();
			if(files.length == 0)
				return;
			else {
				for(File f: files) {
					System.out.print("     ");
					printDirs(f);
				}
			}
		}
		else {
			System.out.print("     ");
			System.out.println(file.getName());
		}
	}
}
