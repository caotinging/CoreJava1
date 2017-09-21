package chapter15.IO.demo1;

import java.io.File;
import java.util.Scanner;

/**
 * �Ӽ��̽���һ���ļ���·��,ɾ�����ļ���
 * @author caoting
 *
 */

public class TaskDemo3 {
	//����delete����ֻ��ɾ���ļ��Ϳ��ļ��У����������Ҫ����������
	//һ������ɾ���յ��ļ����Լ���������ļ���·����һ���ݹ�ɾ��Ŀ¼���ļ��ķ���
	public static void main(String[] args) {
		System.out.println("������Ҫɾ����·������ɾ���з��գ������������");
		//���ȴ���һ��Scanner�����ȡ��������
		Scanner in = new Scanner(System.in);
		String pathname = in.next();
		//����ɾ��������
		if(pathname != null)
			delDirs(pathname);
		//��Ҫ���ǹر�������
		in.close();
	}
	
	//����ɾ�����ļ��к��ļ��ķ���
	public static void delDirs(String pathname) {
		File file = new File(pathname);
		//�ж��Ƿ�Ϊ��Ч·��
		if(file == null || !file.exists()) {
			System.out.println("������Ч·��");
			return;
		}
		if(file.isFile()) {
			file.delete();
			System.out.println("�ļ�ɾ���ɹ�");
		}
		else {
			delFile(file);
			if(file.exists())
				file.delete();
			System.out.println("�ļ�ɾ���ɹ���");
		}
	}
	
	//��������ɾ���ļ�Ŀ¼���ļ��ķ���
	public static void delFile(File file) {
		//�ж��Ƿ�Ϊ�ļ���
		if(file.isFile()) {
			file.delete();
			return;
		}
		else {
			File[] files = file.listFiles();
			//�ж��Ƿ�Ϊ��
			if(files.length == 0) {
				file.delete();
				return;
			}
			//��������ļ�Ҳ���ǿ�Ŀ¼���б����ݹ����
			for(File f: files) {
				delFile(f);
				//��һ�������٣���ɾ���㼶Ŀ¼�±ߵ��ļ����Ϸ��ص�ʱ��Ŀ¼�Ѿ����˵��ǲ���������ļ���ˣ�
				//���ֻ������һ��ɾ����Щ��Ϊ�ļ���ɾ����յ�Ŀ¼
				if(f.exists())
					f.delete();
			}
		}
	}
}
