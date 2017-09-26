package chapter15.IO.demo1;

/**
 * ʹ���ļ����ƹ�����ɸѡ��ָ���ļ����µ�С��200K��С�ļ���ȡ����ӡ
 */

import java.io.File;
import java.io.FileFilter;

public class TaskDemo1 {
	public static void main(String[] args) {
//		����һ���ļ�
		File file = new File("D:\\MyEclipse 2015");
		
//		���õݹ鷽������Ŀ¼ ��ӡС��200k���ļ�
		getSmall(file);
	}
	
	public static void getSmall(File aFile) {
		//���ȼ�����·���Ƿ����
		if(!aFile.exists())
			return;
		//Ȼ����file�Ƿ�Ϊһ��Ŀ¼��Ŀ¼��Ϊ��
		if(aFile.isDirectory() && aFile.list().length>0) {
			//������Ŀ¼
			File[] files = aFile.listFiles(new filter11());
			for(File f: files) {
				if(f.isDirectory())
					getSmall(f);
				else
					System.out.println(f);
			}
		}
		else
			System.out.println(aFile);
	}
}
class filter11 implements FileFilter {
	public boolean accept(File pathname) {
		//��ȡ�ļ�С��200k���ļ� �����Ŀ¼ֱ��true
		if(pathname.isDirectory())
			return true;
		return (pathname.length())/1024 < 200;
	}
}