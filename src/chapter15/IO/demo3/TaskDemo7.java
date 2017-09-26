package chapter15.IO.demo3;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * �ӿ���̨��ȡ������ļ�Ŀ¼Ȼ�󽫸�Ŀ¼(������Ŀ¼)�µ�.java�ļ����Ƶ�D:/java�ļ�����
 * @author caoting
 *
 */

public class TaskDemo7 {
	public static void main(String[] args) {
		System.out.println("��������Ҫ����java�ļ����ļ���·��:");
		Scanner in = new Scanner(System.in);
		String src = in.next();
		
		String des = new String("G:\\java");
		if(!new File(des).exists())
			new File(des).mkdirs();
		
		File file = new File(src);
		if(file.isFile()) {
			if(file.getName().endsWith(".java"))
				FileListA.copyFiles(file, des+"\\"+file.getName());
		}
		
		if(file!=null && file.isDirectory() && file.exists()) {
			
			//���û�ȡȫ��java�ļ��ķ���
			FileListA fileList = new FileListA();
			fileList.getFiles(file);
			//����FileListA����list��ȡjava�ļ� �ֱ���и���
			for(File f: fileList.list) {
				//����ÿһ��java�ļ�
				FileListA.copyFiles(f, des+"\\"+f.getName());
			}
		}
		else{
			System.out.println("������Ч���ļ��У�");
		}
		
		System.out.println("======================");
		System.out.println("�ļ��ɹ�����");
		
		in.close();
	}
}

class FileListA {
	List<File> list;
	
	public FileListA () {
		list = new ArrayList<File>();
	}
	
	//�����ļ��ķ���
	public static void copyFiles(File src, String des) {
		FileReader reader = null;
		FileWriter writer = null;
		try{
			reader = new FileReader(src);
			writer = new FileWriter(des);
			
			int len = 0;
			char[] ch = new char[1024];
			
			while((len = reader.read(ch)) != -1) {
				writer.write(ch, 0, len);
				writer.flush();
			}
		}catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("�ļ�����ʧ�ܣ�");
		}finally{
			try{
				if(reader!=null) reader.close();
				if(writer!=null) writer.close();
			}catch(IOException ex){
				throw new RuntimeException("�ͷ���Դʧ�ܣ�");
			}
		}
	}
	
	//����Ŀ¼
	public void getFiles(File file) {
		//�ж��Ƿ����ļ�
		if(file.isFile()) {
			list.add(file);
			return;
		}
		File[] files = file.listFiles(new FilterA());
		if(files.length == 0)
			return;
		for(File f: files) {
			getFiles(f);
		}
	}
}
class FilterA implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".java");
	}
	
}