package chapter15.IO.demo3;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ȡָ��Ŀ¼����Ŀ¼������txt�ļ��ĸ�����������Щtxt�ļ����Ƶ�D��������Ŀ¼
 * @author caoting
 *
 */

public class TaskDemo3 {
	//����һ����̬ȫ�ֱ������ڱ���txt�ļ�
	static List<File> list = new ArrayList<File>();	
	
	public static void main(String[] args) {
		//���û�ȡtxt�ļ���ָ��Ŀ¼
		File file = new File("G:\\abc");
		//���û�ȡtxt�ļ��ķ���
		getTxt(file);
		System.out.println("txt�ļ�����ĿΪ��" + list.size());
		System.out.println("==================");
		System.out.println("ִ�и��Ʋ���");
		copy(list, "D:\\abc");
		System.out.println("==================");
		System.out.println("���Ƴɹ���");
	}
	
	//�ļ��б��ƹ���
	public static void copy(List<File> list2, String path) {
		File file = new File(path);
		if(!file.exists())
			file.mkdirs();
		for(File f: list2) {
			copyFile(f, file + "\\" + f.getName());
		}
	}

	private static void copyFile(File f, String file) {
		//����һ���ֽ���������һ���ֽ������
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		//����IO�쳣
		try {
			fileInputStream = new FileInputStream(f);
			fileOutputStream = new FileOutputStream(file);
			//����һ���ֽ��������ڻ���
			byte[] bytes = new byte[1024];
			//����whileѭ�����и���
			int len = 0;
			while((len = fileInputStream.read(bytes)) != -1) {
				fileOutputStream.write(bytes, 0, len);
			}
			
		}catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("�ļ�����ʧ��");
		}finally {
			//�ر���Ҳ����Ҫ��׽���쳣���ȿ���أ��ȹ������
			//�ر���֮ǰ���ж��Ƿ�Ϊnull
			try {
				if(fileOutputStream != null)
					fileOutputStream.close();
			}catch(IOException e) {
				throw new RuntimeException("FileOutPutStream���ر�ʧ�ܣ�");
			}finally {
				try{
					if(fileInputStream != null)
						fileInputStream.close();
				}catch(IOException e) {
					throw new RuntimeException("FileInputStream���ر�ʧ�ܣ�");
				}
			}
		}
	}

	//��ȡĿ¼�е�txt�ļ�
	public static void getTxt(File file) {
		File[] files = file.listFiles(new TxtFilter());
		//�ж��Ƿ�Ϊ���ļ���
		if(files.length == 0)
			return;
		for(File f: files) {
			if(f.isFile())
				//���f��txt�ļ� ������list��
				list.add(f);
			else {
				getTxt(f);
			}
		}
	}
}

//ʵ����FileFiter�ӿڵĹ���txt�ļ�����
class TxtFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".txt");
	}
}
