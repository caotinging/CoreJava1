package chapter15.IO.demo1;

import java.io.File;

/**
 * ���õݹ�ʵ��Ŀ¼��ȫ����
 * @author caoting
 *
 */

public class FileDemo2 {
	public static void main(String[] args) {
		File file = new File("G:\\demo");
		getAllDir(file);
		System.out.println("==========================");
		getJava(file);
	}
	
//	������Ŀ���Ǳ���һ��Ŀ¼
	public static void getAllDir(File file) {
//		�ݹ�ı߽�������������һ���ļ����ٽ��б��������ã�
//		�����ж��ǲ���һ��Ŀ¼  �ǵĻ����б���  ���ǵĻ�������ڿ���̨
		if(!file.exists())
			return;
		
		if(file.isDirectory() && file.listFiles().length>0) {
//			��Ŀ¼���б���
//			���ﻹ�����һ��Ŀ¼�Ƿ�Ϊ��  
			File[] files = file.listFiles();
				for(File f: files) {
	//				�������ж��ǲ���Ŀ¼ ����Ǿ͵ݹ���ñ���
					if(f.isDirectory()) {
						getAllDir(f);
					} else {
						System.out.println(f);
					}
				}
		}else {
			System.out.println(file);
		}
	}
	
	/*
	 * �����Զ���Ĺ�������ȡĿ¼�е�����java�ļ�
	 */
	public static void getJava(File file) {
		if(!file.exists())
			return;
		if(file.isDirectory()) {
			for(File f: file.listFiles(new MyFilter())) {
				if(f.isDirectory())
					getJava(f);
				else
					System.out.println(f);
			}
		} 
		else
			System.out.println(file);
	}
}
